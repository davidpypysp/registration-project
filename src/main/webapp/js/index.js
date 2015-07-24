/**
 * Created by shipin on 2015/7/21.
 */



$(document).ready(function() {
    setCookie();

    $("#login").click(function() {
        if(checkInfo() == false) return;
        $.post(
            "Login.do",
            {
                username: $("#username").val(),
                password: $("#password").val(),
                keep:   $("#keep").val()
            },
            function(data) {
                if(data.status == "LOGIN_STATUS_USERNAME_NOT_EXIST") {
                    alert("Sorry, username is not existed.");
                }
                else if(data.status == "LOGIN_STATUS_PASSWORD_INVALID") {
                    alert("Sorry, password is invalid.");
                }
                else if(data.status == "LOGIN_STATUS_SUCCESS") {
                    window.location.href = "User";
                }
            },
            "json"
        );
    });



});

function checkInfo() {
    //check empty, password valid

    //check empty
    if($("#username").val() == "") {
        alert("Username cannot be blank");
        return false;
    }
    if($("#password").val().length < 6) {
        alert("Password must be at least 6 characters");
        return false;
    }
}

function setCookie() {
    $("#username").val($.cookie("username"));
}
