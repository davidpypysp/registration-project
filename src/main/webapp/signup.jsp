<%--
  Created by IntelliJ IDEA.
  User: shipin
  Date: 2015/7/10
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login System</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/signup.css" rel="stylesheet">


</head>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">User Register System</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <form class="form-signin" id="form">
            <h2 class="form-signin-heading">Sign Up</h2>

            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" class="form-control" placeholder="Username" required autofocus>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" class="form-control" placeholder="Password" required >
            <label for="password2" class="sr-only">Password Confirmed</label>
            <input type="password" id="password2" class="form-control" placeholder="Password Confirmed" required>
            <label for="email" class="sr-only">Email address</label>
            <input type="email" id="email" class="form-control" placeholder="Email address" >
            <label for="nickname" class="sr-only">Nickname</label>
            <input type="text" id="nickname" class="form-control" placeholder="Nickname" required>
            <label for="sex" class="sr-only">Gender</label>
            <select id="sex" class="form-control">
                <option value="" id="gender1">Gender</option>
                <option value="male" id="gender2">Male</option>
                <option value="female" id="gender3">Female</option>
            </select>
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="submit" >Sign up</button>
            <button class="btn btn-lg btn-primary btn-block" type="back" onclick="window.location.href='index.jsp'">Back</button>
        </form>
    </div>
</div>

<div class="container">
    <div class="row">

    </div>

    <hr>

    <footer>
        <p>&copy; Com.Shiping.Webstudy</p>
    </footer>
</div>


<body>




<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/signup.js"></script>
</body>
</html>
