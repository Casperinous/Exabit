(function () {

    var App = window.App || {};

    App.Views = {};


    App.Views.PublicKeyTable = Backbone.View.extend({

        el: '#dv-public-keys',
        initialize: function() {
            _.bindAll(this, 'render');

        },

        render: function () {

            var that = this;

            App.GetPublicKeys().done(function (data) {
                App.GetPrivateKeys().done(function (pdata) {

                    var pvkeys = new App.Models.PrivateKeyCollection(pdata);
                    /*

                     */
                    var keys = new App.Models.PublicKeyCollection(data);

                    if( keys ){

                        keys.each(function (keymodel) {

                            var prkey =  pvkeys.filter(function(model){ return model.get('idPublicKey') === keymodel.get('idPublicKey')});
                            console.log(prkey);

                            var key = new App.Views.PublicKeyRow({
                                model: keymodel,
                                privKey: prkey.length === 1 ? prkey[0].get('privateKey') : ''

                            });
                            that.$el.append(key.render().el);
                        });
                    }

                });
            });
        }
    });
    App.Views.PublicKeyRow = Backbone.View.extend({

        tagName: 'tr',
        prvkey: '',

        events: {
            'click .dv-delete-pk': 'delete',
            'click .dv-visible-pk': 'visible',
            'click .dv-public-cp-cb': 'pkcp',
            'click .dv-private-cp-cb': 'prvkcp'
        },

        pkcp: function () {

            var key = this.model;
            var skey = atob( key.get('publicKey'));

            App.Utils.downloadFile('publickey.asc', skey);

        },

        prvkcp: function () {

            var skey = atob( this.prvkey );

            App.Utils.downloadFile('private.asc', skey);
        },


        removeView: function () {
            // COMPLETELY UNBIND THE VIEW
            this.undelegateEvents();

            this.$el.removeData().unbind();

            // Remove view from DOM
            this.remove();
            Backbone.View.prototype.remove.call(this);
        },

        delete: function () {

            var key = this.model;

            App.Utils.Loader.Insert();
            try {
                key.destroy({
                    success: function (model, respose, options) {
                        console.log("The model has been updated to the server");
                    },
                    error: function (model, xhr, options) {
                        console.log("Something went wrong while updating the model");
                        if(xhr.status == 200)
                            console.log("Something went wrong while updating the model");
                    }
                }).always(App.Utils.Loader.Remove());

            } catch(e) {
                console.log(e);
            }
        },

        visible: function () {

            var key = this.model;

            var visibility = key.get('visible');
            key.set('visible', !visibility);
            key.save({}, {
                success: function(model, response) {
                    console.log(response);
                },
                error: function(model, response) {
                    console.log(response);
                }
            });
        },

        initialize: function(options) {
            this.template = _.template($('#dv-public-key-row').html());
            //Pass Private Key Bruh
            this.prvkey = options.privKey;
            this.listenTo(this.model, 'destroy', this.removeView);
            this.listenTo(this.model, 'sync', this.render);

        },

        render: function() {

            this.$el.html(this.template(this.model.attributes));
            return this;
        }

    });



    App.Views.RequestToMeTable = Backbone.View.extend({

        el: '#dv-friend-reqs-to',
        initialize: function() {
            _.bindAll(this, 'render');

        },


        render: function () {

            var that = this;

            App.Friends.GetRequestsToMe().done(function (data) {

                if( data && data.length > 0){

                    var friendreqs = new App.Models.FriendRequestCollection(data);
                    if( friendreqs ){
                        friendreqs.each(function (mfreq) {

                            var vfreq = new App.Views.RequestToMeRow({
                                model: mfreq
                            });
                            that.$el.append(vfreq.render().el);
                        })
                    }
                }
            });
        }

    });
    App.Views.RequestToMeRow = Backbone.View.extend({

        tagName: 'tr',
        userId: 0,

        events: {
            'click .dv-accept-rq': 'reject',
            'click .dv-accept-rq': 'accept'
        },

        reject: function () {

            var req = this.model;

            req.set('accepted',false);
            req.set('fromUserId', this.userId);
            App.Utils.Loader.Insert();
            req.save({}, {
                success: function(model, response) {
                    console.log(response);
                },
                error: function(model, response) {
                    console.log(response);
                }
            }).always(function () {
                App.Utils.Loader.Remove();
                App.UserFriendReqs.render();
            });
        },

        accept: function () {

            var req = this.model;
            App.Utils.Loader.Insert();
            req.set('accepted',true);
            req.set('fromUserId', this.userId);
            req.save({}, {
                success: function(model, response) {
                    console.log(response);
                },
                error: function(model, response) {
                    console.log(response);
                }
            }).always(function () {
                App.Utils.Loader.Remove();
                App.UserFriendReqs.render();
            });
        },
        removeView: function () {
            // COMPLETELY UNBIND THE VIEW
            this.undelegateEvents();

            this.$el.removeData().unbind();

            // Remove view from DOM
            this.remove();
            Backbone.View.prototype.remove.call(this);
        },



        initialize: function(options) {
            this.template = _.template($('#dv-friend-req-gt').html());
            this.listenTo(this.model, 'destroy', this.removeView);
            //this.listenTo(this.model, 'sync', this.render);

        },

        render: function() {
            var that = this;
            this.userId = this.model.get('fromUserId');
            App.Friends.GetFriendUsername(parseInt(this.userId)).done(function (data) {

                that.model.set('fromUserId', data);
                that.$el.html(that.template(that.model.attributes));


            });

            return that;
        }

    });

    /***********************************************************************/

    App.Views.MailBoxInfo = Backbone.View.extend({

        el: '#dv-mail-info',
        messages: null,

        events: {
            'click .compose-mail': 'createmail',
            'click .dv-inbox-a': 'showinbox',
        },

        createmail: function (e) {
            e.preventDefault();
            App.Utils.showOnly('#dv-mail-create');
        },

        showinbox: function (e) {
            e.preventDefault();
            App.Utils.showOnly('#dv-mails-base');
            App.Mail.mailbase.render();
        },

        initialize: function(options) {
            this.template = _.template($('#dv-mail-info-tmp').html());
            _.bindAll(this, 'render');

        },

        render: function() {
            var that = this;
            App.Mail.GetMailBoxInfo().done(function (data) {
                if( data ){
                    that.model = new App.Models.MailBoxInfo(data);
                    if( that.model){
                        that.$el.html(that.template(that.model.attributes));
                        return that;
                    }
                }
            });
        }
    });

    App.Views.MailBoxBase = Backbone.View.extend({

        el: '#dv-mail-table',

        initialize: function(options) {
            this.template = _.template($('#dv-mail-base-tmp').html());
            _.bindAll(this, 'render');

        },

        events: {
            'click .dv-refresh': 'refresh'
        },
        refresh: function () {

            this.render();
        },
        render: function() {
            var that = this;
            this.$el.html('');
            /*
            App.Mail.GetMailBoxInfo().done(function (data) {
                if( data && data.length > 0){
                    that.model = new App.Models.MailBoxInfo(data);
                    if( that.model){
                        that.$el.html(that.template(that.model.attributes));
                        return that;
                    }
                }
            });
            */
            App.Mail.GetMyMail().done(function (data) {

                if( data != null ){
                    that.messages = new App.Models.MessageCollection(data);
                    if( that.messages ){
                        that.messages.each(function (_message) {

                            var vmessage = new App.Views.MailBoxBaseRow({
                                model: _message
                            });

                            that.$el.append(vmessage.render().el);
                            return that;
                        });

                        App.Utils.ICheck();
                    }
                }

            });

        }
    });

    App.Views.MailBoxBaseRow = Backbone.View.extend({

        tagName: 'tr',

        events: {
            'click .dv-delete-pk': 'delete',
            'click .dv-view-mail': 'showmail'
        },

        showmail: function () {

            var message = this.model;

                var mail_content = new App.Views.MailContent({
                model: message
            });
            App.Utils.showOnly('#dv-mail-read');
            mail_content.render();
        },
        removeView: function () {
            // COMPLETELY UNBIND THE VIEW
            this.undelegateEvents();

            this.$el.removeData().unbind();

            // Remove view from DOM
            this.remove();
            Backbone.View.prototype.remove.call(this);
        },

        delete: function () {

            var key = this.model;

            try {
                key.destroy({
                    success: function (model, respose, options) {
                        console.log("The model has been updated to the server");
                    },
                    error: function (model, xhr, options) {
                        console.log("Something went wrong while updating the model");
                        if(xhr.status == 200)
                            console.log("Something went wrong while updating the model");
                    }
                });

            } catch(e) {
                console.log(e);
            }
        },

        initialize: function(options) {
            this.template = _.template($('#dv-mail-row-tmp').html());
            this.listenTo(this.model, 'destroy', this.removeView);
            this.listenTo(this.model, 'sync', this.render);

        },

        render: function() {
            this.$el.addClass('dv-select');
            this.$el.html(this.template(this.model.attributes));
            return this;
        }

    });

    App.Views.MailBoxCreate = Backbone.View.extend({

        el: '#dv-mail-create',
        encrypted: false,

        events: {
            'click .dv-slc-pk': 'dvaddpk',
            'click .dv-send-el': 'sendmail',
        },

        sendmail: function () {


            var $recipient = $('#dv-recipient'),
                $body = $('#dv-msg-bd'),
                $title = $('#dv-subject');

            var brecipien, bbody;

            brecipien = !App.Utils.isEmptyOrNull($recipient) && !App.Utils.isEmptyOrNull($recipient.val());
            bbody = !App.Utils.isEmptyOrNull($body) && !App.Utils.isEmptyOrNull($body.val());

            /*
            *
            * fromUserId': 0,
             'toUserId': 0,
             'title': '',
             'message': '',
             'encrypted': false
            * */
            App.Utils.Loader.Insert();
            var message = new App.Models.Message();
            message.set('toUserId', parseInt($recipient.val()));
            message.set('title', DOMPurify.sanitize(
                                                        $title.val(),
                                                        {SAFE_FOR_JQUERY: true}
                                )
            );
            message.set('message',
                        btoa(
                            DOMPurify.sanitize($body.val(), {SAFE_FOR_JQUERY: true} )
                        )
            );
            message.set('encrypted', $body.val().indexOf('BEGIN PGP MESSAGE') > -1);

            message.save({},{
                success: function(model, response) {
                    console.log(response);
                },
                error: function(model, response) {
                    console.log(response);
                }
            }).always(function () {

                App.Utils.clearForm('#dv-compose-mail-fm');
                App.Utils.Loader.Remove();
                App.Utils.showOnly('#dv-mails-base');
                App.Mail.mailbase.render();


            });
        },

        dvaddpk: function () {

            var $recipient = this.$el.find('#dv-recipient');
            if( !App.Utils.isEmptyOrNull($recipient) && !App.Utils.isEmptyOrNull($recipient.val())){

                try {
                    var id = parseInt($recipient.val());
                    var recipient_pk = new App.Views.RecipientPk();
                    recipient_pk.render(id);
                } catch(error){
                    console.log(error);
                }

            }
        },

        initialize: function(options) {
            this.template = _.template($('#dv-mail-create-tmp').html());
            _.bindAll(this, 'render');
            _.bindAll(this, 'removeView');

        },

        removeView: function () {
            // COMPLETELY UNBIND THE VIEW
            this.undelegateEvents();

            this.$el.removeData().unbind();

            // Remove view from DOM
            this.remove();
            Backbone.View.prototype.remove.call(this);
        },

        render: function() {
            //clean mess, kill vrything
            //this.removeView();
            this.$el.html();
            this.$el.html(this.template());
            return this;
        }

    });


    App.Views.RecipientPk = Backbone.View.extend({

        el: '#dv-pk-tb',
        initialize: function() {
            _.bindAll(this, 'render');

        },

        render: function (id) {

            //Clean ur mess duh
            this.$el.html('');
            var that = this;
            App.Mail.GetRecipientPk(id).done(function (data) {

                if( data ){

                    var pkeys = new App.Models.PublicKeyCollection(data);
                    if( pkeys ){
                        pkeys.each(function (pkey) {
                            var vpkey = new App.Views.RecipientPkRow({
                                model: pkey
                            });
                            that.$el.append(vpkey.render().el);
                        })
                    }
                }
                return that;
            });
        }
    });

    App.Views.RecipientPkRow = Backbone.View.extend({

        tagName: 'li',

        events: {
            'click .dv-st-pk a': 'usethis'
        },

        usethis: function (e) {

            e.preventDefault();
            var key = this.model;
            var pkey = atob( key.get('publicKey'));
            var $mbody = $('#dv-msg-bd');

            if( !App.Utils.isEmptyOrNull($mbody) && !App.Utils.isEmptyOrNull($mbody) ){

                var options = {
                    data: $mbody.val(),
                    publicKeys: openpgp.key.readArmored(pkey).keys
                };

                openpgp.encrypt(options).then(function(ciphertext) {
                    encrypted = ciphertext.data;
                    $mbody.val(encrypted);
                });
            }
        },

        initialize: function(options) {
            this.template = _.template($('#dv-pk-tb-vw').html());
            //Pass Private Key Bruh

        },

        render: function() {

            this.$el.html(this.template(this.model.attributes));
            return this;
        }

    });


    App.Views.RecipientPrk = Backbone.View.extend({

        el: '#dv-prk-tb',
        msg: '',

        initialize: function(options) {
            _.bindAll(this, 'render');
            this.msg = options.msg;
        },

        render: function () {

            //Clean ur mess duh
            this.$el.html('');
            var that = this;

            App.GetPrivateKeys().done(function (data) {

                if( data ){

                    var prkeys = new App.Models.PrivateKeyCollection(data);
                    if( prkeys != null ){
                        prkeys.each(function (pkey) {
                            var vpkey = new App.Views.RecipientPrkRow({
                                model: pkey,
                                msg: that.msg
                            });
                            that.$el.append(vpkey.render().el);
                        })
                    }
                }
                return that;

            });


        }
    });

    App.Views.RecipientPrkRow = Backbone.View.extend({

        tagName: 'li',
        msg: '',

        events: {
            'click .dv-st-pk a': 'usethis',
            'click .dv-evaluate-prk': 'dveval'
        },

        dveval: function (e) {
            e.preventDefault();
            e.stopPropagation();
            var $pass = this.$el.find('.dv-scr-key-pass');
            var hash = CryptoJS.SHA512($pass.val());
            if( hash.toString(CryptoJS.enc.Hex) === this.model.get('password') )
                $pass.removeClass('dv-b-err').addClass('dv-b-suc');
            else
                $pass.removeClass('dv-b-suc').addClass('dv-b-err');
        },

        usethis: function (e) {

            e.preventDefault();
            var key = this.model;
            var pkey = atob( key.get('privateKey'));
            var $mbody = $('#dv-msg-bd');

            if( !App.Utils.isEmptyOrNull($mbody) && !App.Utils.isEmptyOrNull($mbody) ){

                App.Utils.Loader.Insert();
                var privateKey = App.openpgp.key.readArmored(pkey).keys[0];
                var res =  privateKey.decrypt(this.$el.find('.dv-scr-key-pass').val());


                if( res ) {
                    options = {
                        message: openpgp.message.readArmored(this.msg),     // parse armored message
                        privateKey: privateKey // for decryption
                    };

                    openpgp.decrypt(options).then(function (plaintext) {

                        var text = plaintext.data; // 'Hello, World!'
                        $('#dv-decr-err').text('');
                        $('#dv-mail-read .mail-body').first().text('');
                        $('#dv-mail-read .mail-body').first().text(DOMPurify.sanitize(text));
                    }).catch(function(e) {
                        console.log(e); // "oh, no!"
                        $('#dv-decr-err').text('Wrong Key');
                    }).then(App.Utils.Loader.Remove());
                }
            }
        },

        initialize: function(options) {
            this.template = _.template($('#dv-prk-tb-vw').html());
            //Pass Msg Bruh
            this.msg = options.msg;

        },

        render: function() {

            this.$el.html('');
            this.$el.html(this.template(this.model.attributes));
            return this;
        }

    });




    App.Views.MailContent = Backbone.View.extend({

        el: '#dv-mail-read',

        events: {
            'click .dv-decrypt-msg': 'dvdecrypt'
        },

        dvdecrypt: function () {

            var decryview = new App.Views.RecipientPrk({ msg: this.model.get('message')});
            decryview.render();

        },

        initialize: function(options) {
            this.template = _.template($('#dv-mail-read-tmp').html());
            //Pass Private Key Bruh

        },

        render: function() {
            //Clean yo mess
            this.$el.html('');
            this.model.set('message',
                            DOMPurify.sanitize(
                                                atob(this.model.get('message')),
                                                {SAFE_FOR_JQUERY: true}
                                                )
            );
            this.$el.html(this.template(this.model.attributes));
            return this;
        }

    });



}($));