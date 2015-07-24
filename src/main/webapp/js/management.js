/**
 * Created by shipin on 2015/7/23.
 */

$(document).ready(function() {
    setSex();  //set sex text's default value

    $("#logout").click(function() {
        window.location.href = "Logout.do";
    });

    $("#form").submit(function() {
        $.post(
            "Update.do",
            {
                nickname: $("#nickname").val(),
                email: $("#email").val(),
                sex: $("#sex").val()
            },
            function(data) {
                if(data.status == "UPDATE_STATUS_SUCCESS") {
                    alert("Update information success.");
                    window.location.href = "management.jsp";
                }
                else {
                    alert("Update information failed.");
                }
            },
            "json"
        )
        return false;
    });



});

function setSex() {
    var sexVal = $("#sexval").val();
    if(sexVal == "male") {
        $("#gender2").attr("selected", "selected");
    }
    else if(sexVal == "female") {
        $("#gender3").attr("selected", "selected");
    }
    else {
        $("#gender1").attr("selected", "selected");
    }
}


