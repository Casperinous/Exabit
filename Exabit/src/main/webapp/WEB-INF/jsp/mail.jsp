<%--
  Created by IntelliJ IDEA.
  User: nikostot
  Date: 4/9/2016
  Time: 11:21 μμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>INSPINIA | Dashboard</title>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/bootstrap/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/animate.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/style.css" rel="stylesheet">

</head>

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">Profile</a></li>
                            <li><a href="contacts.html">Contacts</a></li>
                            <li><a href="mailbox.html">Mailbox</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                <li class="">
                    <a href="/Keys"><i class="fa fa-th-large"></i> <span class="nav-label">Keys</span> <span class="fa arrow"></span></a>
                </li>
                <li class="">
                    <a href="/FriendRequests"><i class="fa fa-th-large"></i> <span class="nav-label">Friend Requests</span> <span class="fa arrow"></span></a>
                </li>
                <li class="active">
                    <a href="/Mail"><i class="fa fa-th-large"></i> <span class="nav-label">Mail</span> <span class="fa arrow"></span></a>
                </li>
            </ul>

        </div>
    </nav>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a7.jpg">
                                    </a>
                                    <div class="media-body">
                                        <small class="pull-right">46h ago</small>
                                        <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
                                        <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/a4.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right text-navy">5h ago</small>
                                        <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
                                        <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="dropdown-messages-box">
                                    <a href="profile.html" class="pull-left">
                                        <img alt="image" class="img-circle" src="img/profile.jpg">
                                    </a>
                                    <div class="media-body ">
                                        <small class="pull-right">23h ago</small>
                                        <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                                        <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                                    </div>
                                </div>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="mailbox.html">
                                        <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="mailbox.html">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="profile.html">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="grid_options.html">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <div class="text-center link-block">
                                    <a href="notifications.html">
                                        <strong>See All Alerts</strong>
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </li>


                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>
                    <li>
                        <a class="right-sidebar-toggle">
                            <i class="fa fa-tasks"></i>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row  border-bottom white-bg dashboard-header">
        </div>
        <div class="row">
            <div class="col-lg-3">
                <div id="dv-mail-info" class="">
                </div>
            </div>
            <div class="col-lg-9 animated fadeInRight">
                <div id="dv-mails-base" class="">
                    <div class="mail-box-header">
                        <form method="get" action="index.html" class="pull-right mail-search">
                            <div class="input-group">
                                <input type="text" class="form-control input-sm" name="search" placeholder="Search email">
                                <div class="input-group-btn">
                                    <button type="submit" class="btn btn-sm btn-primary">
                                        Search
                                    </button>
                                </div>
                            </div>
                        </form>
                        <h2>
                            Inbox (16)
                        </h2>
                        <div class="mail-tools tooltip-demo m-t-md">
                            <div class="btn-group pull-right">
                                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>
                                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>
                            </div>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="Refresh inbox"><i class="fa fa-refresh"></i> Refresh</button>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Mark as read"><i class="fa fa-eye"></i> </button>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Mark as important"><i class="fa fa-exclamation"></i> </button>
                            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to trash"><i class="fa fa-trash-o"></i> </button>
                        </div>
                    </div>
                    <div class="mail-box">
                        <table class="table table-hover table-mail">
                            <tbody id="dv-mail-table">

                            </tbody>
                        </table>
                    </div>
                </div>
                <div id="dv-mail-create" class="dv-hidden"></div>
                <div id="dv-mail-read" class="dv-hidden"></div>
            </div>
        </div>
    </div>
</div>

<!-- Mail Info Template -->
<script type="text/template" id="dv-mail-info-tmp">
<div class="ibox float-e-margins">
    <div class="ibox-content mailbox-content">
        <div class="file-manager">
            <a class="btn btn-block btn-primary compose-mail" href="#">Compose Mail</a>
            <div class="space-25"></div>
            <h5>Folders</h5>
            <ul class="folder-list m-b-md" style="padding: 0">
                <li><a href="#" class="dv-inbox-a"> <i class="fa fa-inbox "></i> Inbox <span class="label label-warning pull-right">{{= inbox }}</span> </a></li>
                <li><a href="#"> <i class="fa fa-envelope-o"></i> Send Mail</a></li>
                <li><a href="#"> <i class="fa fa-certificate"></i> Important</a></li>
                <li><a href="#"> <i class="fa fa-file-text-o"></i> Drafts <span class="label label-danger pull-right">{{= drafts }}</span></a></li>
                <li><a href="#"> <i class="fa fa-trash-o"></i> Trash</a></li>
            </ul>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
</script>
<!-- -->

<script type="text/template" id="dv-mail-read-tmp">
    <div class="mail-box-header">
        <div class="pull-right tooltip-demo">
            <a href="#" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to trash"><i class="fa fa-trash-o"></i> </a>
            {{ if(encrypted) { }}
                <button class="btn btn-white btn-sm dv-decrypt-msg dropdown-toggle" type="button" id="dv-decr-msg" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" data-toggle="tooltip" data-placement="top" title="Decrypt"><i class="fa fa-trash-o"></i> </button>
                <ul id="dv-prk-tb" class="dropdown-menu" aria-labelledby="dv-decr-msg">
                </ul>
            {{ } }}
        </div>
        <h2>
            View Message
        </h2>
        <div class="mail-tools tooltip-demo m-t-md">
            <h3>
                <span class="font-noraml">Subject: </span>{{= title }}
            </h3>
            <h5>
                <span class="font-noraml">From: </span> {{= fromUserId }}
            </h5>
            <div id="dv-decr-err" ></div>
        </div>
    </div>
    <div class="mail-box">
        <div class="mail-body">
            {{= message }}
        </div>
        <div class="mail-body text-right tooltip-demo">
            <button title="" data-placement="top" data-toggle="tooltip" data-original-title="Trash" class="btn btn-sm btn-white"><i class="fa fa-trash-o"></i> Remove</button>
        </div>
        <div class="clearfix"></div>
    </div>
</script>

<!-- Mail Info Template -->
<script type="text/template" id="dv-mail-row-tmp">
    <td class="check-mail">
        <input type="checkbox" class="i-checks">
    </td>
    <td class="mail-ontact"><a href="mail_detail.html">{{= fromUserId }}</a></td>
    <td class="mail-subject"><a href="mail_detail.html">{{= title }}</a></td>
    <td class="dv-encrypted"></td>
    <td class="dv-encrypted"><button type="button" class="btn btn-block dv-view-mail">View</button></td>
</script>

<!-- Mail Base Template -->
<script type="text/template" id="dv-mail-base-tmp">
    <div class="mail-box-header">
        <form method="get" action="#" class="pull-right mail-search">
            <div class="input-group">
                <input type="text" class="form-control input-sm" name="search" placeholder="Search email">
                <div class="input-group-btn">
                    <button type="submit" class="btn btn-sm btn-primary">
                        Search
                    </button>
                </div>
            </div>
        </form>
        <h2>
            Inbox
        </h2>
        <div class="mail-tools tooltip-demo m-t-md">
            <div class="btn-group pull-right">
                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>
                <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>
            </div>
            <button class="btn btn-white btn-sm dv-refresh" data-toggle="tooltip" data-placement="left" title="Refresh inbox"><i class="fa fa-refresh"></i> Refresh</button>
            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Mark as read"><i class="fa fa-eye"></i> </button>
            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Mark as important"><i class="fa fa-exclamation"></i> </button>
            <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to trash"><i class="fa fa-trash-o"></i> </button>
        </div>
        <div class="mail-box">
            <table class="table table-hover table-mail">
                <tbody id="">

                </tbody>
            </table>
        </div>
    </div>
</script>
<!-- -->

<!-- Mail Create Template -->
<script type="text/template" id="dv-mail-create-tmp">
    <div class="mail-box-header">
        <div class="pull-right tooltip-demo">
            <a href="#" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Move to draft folder"><i class="fa fa-pencil"></i> Draft</a>
            <a href="#" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top" title="Discard email"><i class="fa fa-times"></i> Discard</a>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle dv-slc-pk" type="button" id="dv-pk" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    dropdown
                    <span class="caret"></span>
                </button>
                <ul id="dv-pk-tb" class="dropdown-menu" aria-labelledby="dv-pk">
                </ul>
            </div>
        </div>
        <h2>
            Compose Mail
        </h2>
    </div>
    <div class="mail-box" id="dv-compose-mail-fm">
        <div class="mail-body">
            <div class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">To:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="dv-recipient" value="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Subject:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="dv-subject" value="">
                    </div>
                </div>
            </div>
        </div>
        <div class="mail-text h-200">
            <textarea id="dv-msg-bd" class="dv-message-body"></textarea>
            <div class="clearfix"></div>
        </div>
        <div class="mail-body text-right tooltip-demo">
            <a href="#" class="btn btn-sm btn-primary dv-send-el"  title="Send"><i class="fa fa-reply"></i> Send</a>
            <a href="#" class="btn btn-white btn-sm" title="Discard email"><i class="fa fa-times"></i> Discard</a>
            <a href="#" class="btn btn-white btn-sm" title="Move to draft folder"><i class="fa fa-pencil"></i> Draft</a>
        </div>
        <div class="clearfix"></div>
    </div>
</script>

<!-- Public Key User -->
<script type="text/template" id="dv-pk-tb-vw">
    <div class="dv-pk-am">
        <div class="dv-d-i-b">
            {{= idPublicKey }}
        </div>
        <div class="dv-dw-pk dv-d-i-b">
            <a href="#">Download</a>
        </div>
        <div class="dv-st-pk dv-d-i-b">
            <a href="#">Use this</a>
        </div>
    </div>
</script>



<!-- Public Key User -->
<script type="text/template" id="dv-prk-tb-vw">
    <div class="dv-pk-am">
        <div class="dv-d-i-b">
            {{= idPrivateKey }}
        </div>
        <div class="dv-dw-pk dv-d-i-b">
            <a href="#">Download</a>
        </div>
        <div class="dv-st-pk dv-d-i-b">
            <a href="#">Use this</a>
        </div>
        <div class="form-group dv-d-i-b">
            <input  type="text" class="dv-d-i-b dv-scr-key-pass">
            <button class="btn btn-default dv-d-i-b dv-evaluate-prk">Evaluate</button>
        </div>
    </div>
</script>

<!-- Mainly scripts -->
<script src="/resources/bootstrap/js/jquery-2.1.1.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/bootstrap/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/resources/bootstrap/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="/resources/bootstrap/js/inspinia.js"></script>
<script src="/resources/bootstrap/js/plugins/pace/pace.min.js"></script>
<!-- iCheck -->
<script src="/resources/js/iCheck/icheck.min.js"></script>

<script src="/resources/js/cryptojs/core.js"></script>
<script src="/resources/js/cryptojs/x64-core.js"></script>
<script src="/resources/js/cryptojs/sha512.js"></script>
<script src="/resources/js/openpgp.min.js"></script>
<script src="/resources/js/purify.min.js"></script>
<script src="/resources/js/json2.js"></script>
<script src="/resources/js/underscore-min.js"></script>
<script src="/resources/js/backbone-min.js"></script>
<script src="/resources/js/models.js"></script>
<script src="/resources/js/views.js"></script>
<script src="/resources/js/app.js"></script>




<script>
    $(document).ready(function() {

        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });

        App.Utils.initTranspiler();
        App.Mail.InitApp();
        $('.dv-refresh').on('click',function () {

            App.Mail.mailbase.render();
        });
    });
</script>

</body>
</html>

