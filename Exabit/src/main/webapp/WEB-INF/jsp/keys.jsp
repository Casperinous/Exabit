<%--
  Created by IntelliJ IDEA.
  User: nikostot
  Date: 4/9/2016
  Time: 1:41 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Exabit</title>

    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/bootstrap/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/animate.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/style.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/loader.css" rel="stylesheet">

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
                <li class="active">
                    <a href="/Keys"><i class="fa fa-th-large"></i> <span class="nav-label">Keys</span> <span class="fa arrow"></span></a>
                </li>
                <li class="">
                    <a href="/FriendRequests"><i class="fa fa-th-large"></i> <span class="nav-label">Friend Requests</span> <span class="fa arrow"></span></a>
                </li>
                <li class="">
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
            <div class="col-md-3">
                <div>Press the button to create a new pair if you dont have any !</div>
            </div>
            <div class="col-md-3">
                <button type="button" data-toggle="modal" data-target="#dv-keys-modal" class="btn btn-info-outline dv-create-keys"><a href="#">New KeyPair</a></button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="dv-table-header">
                    <div class="dv-table-title">Περιεχόμενα</div>
                </div>
                <div class="dv-table-content">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Id Κλειδιού</th>
                            <th>Extension</th>
                            <th>IsVisible</th>
                            <th>PublicKey</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="dv-public-keys">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="dv-keys-modal" tabindex="-1" role="dialog" aria-labelledby="Keys">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="">Insert Keys Info</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="dv-userid" class="control-label">UserId</label>
                    <input type="text" class="form-control" id="dv-userid">
                </div>
                <div class="form-group">
                    <label for="dv-email" class="control-label">Email</label>
                    <input type="text" class="form-control" id="dv-email">
                </div>
                <div class="form-group">
                    <label for="dv-password" class="control-label">Password</label>
                    <input type="text" class="form-control" id="dv-password">
                </div>
                <div class="form-group"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary dv-create-keys-modal">Save changes</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->

<!-- Template -->
<script type="text/template" id="dv-public-key-row">
    <td>{{= idPublicKey }}</td>
    <td>{{= extension }}</td>
    <td>{{= visible }}</td>
    <td><button type="button" class="btn btn-info-outline dv-public-cp-cb">PublicKey</button></td>
    <td><button type="button" class="btn btn-info-outline dv-private-cp-cb">PrivateKey</button></td>
    <td><button type="button" class="btn btn-info-outline dv-delete-pk">Delete</button></td>
    <td><button type="button" class="btn btn-info-outline dv-visible-pk">Visibility</button></td>
</script>



<!-- Mainly scripts -->
<script src="/resources/bootstrap/js/jquery-2.1.1.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/bootstrap/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/resources/bootstrap/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="/resources/bootstrap/js/inspinia.js"></script>
<script src="/resources/bootstrap/js/plugins/pace/pace.min.js"></script>

<script src="/resources/js/cryptojs/core.js"></script>
<script src="/resources/js/cryptojs/x64-core.js"></script>
<script src="/resources/js/cryptojs/sha512.js"></script>
<script src="/resources/js/openpgp.min.js"></script>
<script src="/resources/js/json2.js"></script>
<script src="/resources/js/underscore-min.js"></script>
<script src="/resources/js/backbone-min.js"></script>
<script src="/resources/js/models.js"></script>
<script src="/resources/js/views.js"></script>
<script src="/resources/js/app.js"></script>




<script>
    $(document).ready(function() {
        App.Utils.initTranspiler();
        App.UserKeys = new App.Views.PublicKeyTable();
        App.UserKeys.render();

        App.Events.registerKeyGeneration('.dv-create-keys-modal');
    });
</script>
</body>
</html>

