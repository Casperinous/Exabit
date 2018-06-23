(function () {

    var App = App || {};

    App.Models = {};

    App.Models.Users = Backbone.Model.extend({
        urlRoot: 'api/v1/UsersEntity',
        idAttribute:"idUsers",
        defaults: {
            'username':'',
            'uid': '',
            'email':'',
            'idAuthority': 1,
            'password': ''
        },
        initialize: function(){

        }
    });

    App.Models.UsersCollection = Backbone.Collection.extend({
        model : App.Models.Users
    });

    /********************************************************/

    App.Models.FriendRequest = Backbone.Model.extend({
        urlRoot: 'api/v1/FriendRequestEntity',
        idAttribute:"idFriendRequest",
        defaults: {
            'fromUserId':'',
            'toUserId': '',
            'accepted':false
        },
        initialize: function(){

        }
    });

    App.Models.FriendRequestCollection = Backbone.Collection.extend({
        model : App.Models.FriendRequest
    });

    /********************************************************/

    App.Models.Friends = Backbone.Model.extend({


        urlRoot: 'api/v1/FriendEntity',
        idAttribute:"idFriends",
        defaults: {
            'fromUserId': 0,
            'toUserId': 0
        },
        initialize: function(){

        }

    });

    App.Models.FriendsCollection = Backbone.Collection.extend({
        model : App.Models.Friends
    });

    /********************************************************/

    App.Models.Message = Backbone.Model.extend({

        urlRoot: 'api/v1/MessageEntity',
        idAttribute:"idMessage",
        defaults: {
            'fromUserId': 0,
            'toUserId': 0,
            'title': '',
            'message': '',
            'encrypted': false
        },
        initialize: function(){

        }
    });

    App.Models.MessageCollection = Backbone.Collection.extend({
        model : App.Models.Message
    });

    /********************************************************/


    App.Models.MessageProperties = Backbone.Model.extend({

        urlRoot: 'api/v1/MessagePropertiesEntity',
        idAttribute:"idMessageProperties",
        defaults: {
            'idUser': 0,
            'idMessage': 0,
            'isEncrypted': false,
            'isDraft': false,
            'isTrashed': false,
            'isImportant': false
        },
        initialize: function(){

        }
    });

    App.Models.MessagePropertiesCollection = Backbone.Collection.extend({
        model : App.Models.MessageProperties
    });

    /********************************************************/

    App.Models.PrivateKey = Backbone.Model.extend({

        urlRoot: 'api/v1/PrivateKeyEntity',
        idAttribute:"idPrivateKey",
        defaults: {
            'idUsers': 0,
            'privateKey': '',
            'password': '',
            'extension': '',
            'idPublicKey': 0
        },
        initialize: function(){

        }
    });

    App.Models.PrivateKeyCollection = Backbone.Collection.extend({
        model : App.Models.PrivateKey
    });

    /********************************************************/

    App.Models.PublicKey = Backbone.Model.extend({

        urlRoot: 'api/v1/PublicKeyEntity',
        idAttribute:"idPublicKey",
        defaults: {
            'idUsers': 0,
            'publicKey': '',
            'extension': 'asc',
            'visible': true
        },
        initialize: function(){

        }

    });



    App.Models.PublicKeyCollection = Backbone.Collection.extend({
        model : App.Models.PublicKey
    });

    //Classical Model Just
    App.Models.MailBoxInfo = Backbone.Model.extend({

        urlRoot: '',
        idAttribute:"",
        defaults: {
            'drafts': 0,
            'inbox': 0,
        },
        initialize: function(){

        }

    });

    window.App = App;

}());