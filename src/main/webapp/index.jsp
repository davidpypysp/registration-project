<%--
  Created by IntelliJ IDEA.
  User: shipin
  Date: 2015/7/10
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration System</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">

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
                <input class="keep-cookie" id="keep" type="checkbox" name="keep"/>
                <input type="text" id="username" placeholder="Username" class="form-control">
                <input type="password" id="password" placeholder="Password" class="form-control">
                <button type="submit" id="login" class="btn btn-success">Log in</button>
            </div>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>Welcome to </h1>
        <h1>User Registration System</h1>
        <p>I'm in the progess of studying javaweb and some references techniques. This is my first example project.</p>
        <p> <a class="btn btn-primary btn-lg" href="signup.jsp">Sign up</a> </p>

    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>New feature to add!</h2>
            <p>Excited!</p>
        </div>
        <div class="col-md-6">
            <h2>New feature to add!</h2>
            <p>Very Excited!</p>
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy; Com.Shiping.Webstudy</p>
    </footer>
</div>







<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.cookie.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/index.js"></script>
</body>
</html>
