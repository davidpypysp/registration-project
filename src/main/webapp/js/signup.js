/**
 * Created by shipin on 2015/7/22.
 */
$(document).ready(function() {
    $("#form").submit(function() {
        if(checkInfo() == false) return false;
        $.post(
            "SignUp.do", //action to do
            {//data to send
                username: $("#username").val(),
                nickname: $("#nickname").val(),
                password: $("#password").val(),
                email   : $("#email").val(),
                sex     : $("#sex").val()
            },
            function(data) { //return data from back-end(servlet)
                if(data.status == "SIGN_UP_STATUS_SUCCESS") {
                    alert("Signed up success! " + "  Welcome, " + data.username + ".");
                    window.location.href='index.jsp';
                } else if(data.status == "SIGN_UP_STATUS_USERNAME_USED") {
                    alert("Failed!   " + "Username: \"" + data.username + "\" has been signed up.");
                }
            },
            "json" //returned data's type
        );
        return false;
    });
});

function checkInfo() {
    //check empty, password valid, mail valid

    //check empty
    if($("#username").val() == "") {
        alert("Username cannot be blank");
        return false;
    }
    if($("#nickname").val() == "") {
        alert("Nickname cannot be blank");
        return false;
    }
    if($("#password").val() == "") {
        alert("Password cannot be blank");
        return false;
    }
    if($("#password2").val() == "") {
        alert("Password Confirmed cannot be blank");
        return false;
    }

    //check password valid
    if($("#password").val().length < 6) {
        alert("Password must be at least 6 characters");
        return false;
    }
    if($("#password").val() != $("#password2").val()) {
        alert("Passwords do not match");
        return false;
    }

    //check email
    if( ($("#email").val() != "" ) && !validateEmail($("#email").val()) ) {
        alert("Email is invalid");
        return false;
    }
}

function validateEmail(email) {
    var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    return re.test(email);
}