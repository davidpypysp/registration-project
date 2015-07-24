<%--
  Created by IntelliJ IDEA.
  User: shipin
  Date: 2015/7/11
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login System</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/management.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar  "></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">User Register System</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">

            <div class="navbar-form navbar-right">
                <button type="button" id="logout" class="btn btn-success">Log out</button>
            </div>

            <ul class="nav navbar-nav navbar-right" >
                <li><a href="#">${sessionScope.user.username}</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">

        <div class="row">
            <!-- edit form column -->
            <div class="personal-info">


                <form id="form" class="form-horizontal" role="form">
                    <div class="form-group">
                        <h3>Edit Profile</h3>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Username:</label>
                        <div class="col-lg-8">
                            <input id="username" class="form-control" type="text" value="${sessionScope.user.username}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Email:</label>
                        <div class="col-lg-8">
                            <input id="email" class="form-control" type="text" value="${sessionScope.user.email}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">Nickname:</label>
                        <div class="col-md-8">
                            <input id="nickname" class="form-control" type="text" value="${sessionScope.user.nickname}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Gender:</label>
                        <div class="col-lg-8" >
                            <div class="ui-select">
                                <input id="sexval" type="hidden" value="${sessionScope.user.sex}" />
                                <select id="sex" class="form-control">
                                    <option value="" id="gender1">Gender</option>
                                    <option value="male" id="gender2">Male</option>
                                    <option value="female" id="gender3">Female</option>
                                </select>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-md-3 control-label"></label>
                        <div class="col-md-8">
                            <input type="submit" class="btn btn-primary" value="Save Changes">
                            <span></span>
                            <input type="reset" class="btn btn-default" value="Cancel">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>



</div>





<div class="container">

    <hr>
    <footer>
        <p>&copy; Com.Shiping.Webstudy</p>
    </footer>
</div>





<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/management.js"></script>

</body>
</html>
