(function(){

    var App = window.App;
    App.PGP = {};
    App.Utils = {};

    App.UserKeys = null;
    App.UserFriendReqs = null;


    App.Utils.showOnly = function (selector) {

        var selectors = ['#dv-mails-base','#dv-mail-create','#dv-mail-read'];

        for(var i = 0, y = selectors.length; i < y; i++){
            if( selectors[i] !== selector ){
                App.Utils.clearForm(selector[i]);
                $(selectors[i]).addClass('dv-hidden');
            } else {
                $(selectors[i]).removeClass('dv-hidden');
            }

        }

    };

    App.Utils.Loader ={};
    App.Utils.Loader.Insert = function () {

        //check if we failed to remove one
        var $loader = $('.loading');

        if( !App.Utils.isEmptyOrNull($loader) ) return;
        $('body').append('<div class="loading">Loading&#8230;</div>');

    };

    App.Utils.Loader.Remove = function () {

        var $loader = $('.loading');

        if( App.Utils.isEmptyOrNull($loader) ) return;

        $loader.fadeOut(500, function () {
           $(this).remove();
        });
    };

    App.Utils.clearForm = function (selector) {

        var $form = $(selector);
        if( $form.length > 0)
            $form.find('input[type=text], input[type=password], input[type=number], input[type=email], textarea').val('');

    };

    App.Utils.unescapeHtml = function (safe) {

        return safe.replace(/&amp;/g, '&')
                .replace(/&lt;/g, '<')
                .replace(/&gt;/g, '>')
                .replace(/&quot;/g, '"')
                .replace(/&#039;/g, "'");
    };

    App.Utils.isEmptyOrNull = function (str) {

        return !str || str.length === 0;
    };

    App.Utils.downloadFile = function (filename, text) {


        var element = document.createElement('a');
        element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
        element.setAttribute('download', filename);
        element.style.display = 'none';
        document.body.appendChild(element);
        element.click();
        document.body.removeChild(element);


    };

    App.Utils.ICheck = function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    };


    App.Utils.initTranspiler = function () {

        _.templateSettings.interpolate = /\{\{=([^-][\S\s]+?)\}\}/g;
        _.templateSettings.evaluate = /\{\{([^-=][\S\s]+?)\}\}/g;
        _.templateSettings.escape = /\{\{-([^=][\S\s]+?)\}\}/g;
    };

    App.base = 'api/v1/';

    var pgp = window.openpgp;
    App.openpgp = pgp;

    App.GetPublicKeys = function () {

        return $.ajax({
            type: "GET",
            url: App.base + 'PublicKeys',
            contentType: "application/json; charset=utf-8",
            success: function(data){
                console.log(data);
            },
            failure: function(errMsg) {
            }
        });
    };

    App.GetPrivateKeys = function () {

        return $.ajax({
            type: "GET",
            url: App.base + 'PrivateKeys',
            contentType: "application/json; charset=utf-8",
            success: function(data){
                console.log(data);
            },
            failure: function(errMsg) {
            }
        });
    };

    App.PGP.SavePrivateKey = function (idpkey,prvkey, password){


        var hash = CryptoJS.SHA512(password);

        var prkey = new App.Models.PrivateKey();
        prkey.set('idPublicKey',idpkey);
        prkey.set('privateKey', btoa(prvkey));
        prkey.set('password', hash.toString(CryptoJS.enc.Hex));

        prkey.save({},{
                success: function(model, response) {
                    console.log(response);
                },
                error: function(model, response) {
                console.log(response);
                }
            }
        ).always(function(){
            App.Utils.Loader.Remove();
            App.UserKeys.render();
        });
    }

    App.PGP.GenerateKeyPair = function (name, email, passphrase) {

        var options = {
            userIds: [{ name:name, email:email }], // multiple user IDs
            numBits: 4096,                                            // RSA key size
            passphrase: passphrase         // protects the private key
        };

        App.Utils.Loader.Insert();
        App.openpgp.generateKey(options).then(function(key) {

            var privkey = key.privateKeyArmored;
            var pubkey = key.publicKeyArmored;

            var pkey = new App.Models.PublicKey();
            pkey.set('publicKey', btoa(pubkey));
            pkey.save({}, {
                    success: function (model, response) {
                        var id = model.get('idPublicKey');
                        App.PGP.SavePrivateKey(id, privkey,passphrase);
                    },
                    error: function (model, response) {
                        console.log(response);
                        App.Utils.Loader.Remove();
                    }
                }
            );
        });
    }

    App.Events = {};

    App.Events.registerKeyGeneration = function (selector) {

        var $el = $(selector);
        if( $el. length <= 0) return;


        $(document).on('click', selector, function () {

            var $id         = $('#dv-userid'),
                $email      = $('#dv-email'),
                $password   = $('#dv-password');


            var bid, bemail, bpassword;

            bid = !App.Utils.isEmptyOrNull($id) && !App.Utils.isEmptyOrNull($id.val());
            bemail = !App.Utils.isEmptyOrNull($email) && !App.Utils.isEmptyOrNull($email.val());
            bpassword = !App.Utils.isEmptyOrNull($password) && !App.Utils.isEmptyOrNull($password.val());

            if( !bid || !bemail || !bpassword) return;

            App.PGP.GenerateKeyPair($id.val(),$email.val(),$password.val());
            App.Utils.clearForm('#dv-keys-modal');
            $('#dv-keys-modal').modal('hide');

        });
    }

    App.Events.registerFriendRequest = function (selector) {

        var $el = $(selector);
        if( $el. length <= 0) return;

        $(document).on('click', selector, function () {

            var $username = $('#dv-username');

            if( !App.Utils.isEmptyOrNull($username) && !App.Utils.isEmptyOrNull($username.val()) ){

                App.Utils.Loader.Insert();
                App.Friends.SendFriendRequest($username.val()).done(function (data) {

                    $('.dv-friend-rsp').text(data);

                })

            }

        });

    }

    App.Friends = {};


    App.Friends.GetRequestsToMe = function () {

        return $.ajax({
            type: "GET",
            url: App.base + '/GetFriendRequestsToMe',
            success: function(data){
                console.log(data);},
            failure: function(errMsg) {
                console.log(errMsg);
            }
        });
    }

    App.Friends.GetFriendUsername = function (_id) {

        return $.ajax({
            type: "POST",
            url: App.base + '/GetUsernameFromId',
            data: {
                id: _id
            },
            async: false,
            //contentType: "application/text; charset=utf-8",
            //dataType: "text",
            success: function(data){
                console.log(data);},
            failure: function(errMsg) {
                console.log(errMsg);
            }
        });
    }

    App.Friends.SendFriendRequest = function (_username) {

        return $.ajax({
            type: "POST",
            url: App.base + '/SendFriendRequest',
            data: {
                username: _username
            },
            //contentType: "application/text; charset=utf-8",
            //dataType: "text",
            success: function(data){
                console.log(data);},
            failure: function(errMsg) {
                console.log(errMsg);
            }
        });
    }

    App.Mail = {};

    App.Mail.mailboxinfo = null;
    App.Mail.mailbase = null;
    App.Mail.mailboxcreate = null;


    App.Mail.InitApp = function () {

        App.Mail.mailboxinfo = new App.Views.MailBoxInfo();
        App.Mail.mailboxinfo.render();

        App.Mail.mailbase = new App.Views.MailBoxBase();
        App.Mail.mailbase.render();

        App.Mail.mailboxcreate = new App.Views.MailBoxCreate();
        App.Mail.mailboxcreate.render();

    };

    App.Mail.GetMailBoxInfo = function () {

        return $.ajax({
            type: "GET",
            url: App.base + '/GetMailBoxInfo',
            success: function(data){
                console.log(data);},
            failure: function(errMsg) {
                console.log(errMsg);
            }
        });
    };

    App.Mail.GetMyMail = function () {

        return $.ajax({
            type: "GET",
            url: App.base + 'GetMyMails',
            success: function(data){
                console.log(data);},
            failure: function(errMsg) {
                console.log(errMsg);
            }
        });
    };

    App.Mail.GetRecipientPk = function (_id) {

        return $.ajax({
            type: "POST",
            url: App.base + 'GetRecipientPK',
            data: {
                id: _id
            },
            success: function(data){
                console.log(data);},
            failure: function(errMsg) {
                console.log(errMsg);
            }
        });
    }

}($))