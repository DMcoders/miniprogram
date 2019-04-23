$(document).ready(function () {

    document.onkeyup = function (event) {
        e = event ? event : (window.event ? window.event : null);
        if (e.keyCode == 13) {
            login();
        }
    }
});

var basePath=$("#basePath").val();

function login() {
    if($("#userName").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入账号！</span>",html: true});
        return false;
    }
    if($("#passWord").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入密码！</span>",html: true});
        return false;
    }
    $.ajax({
        url: basePath + "userlogin",
        type:"POST",
        data: {
            userName:$("#userName").val(),
            passWord:$("#passWord").val()
        },
        success: function (data) {
            if(data.flag) {
                location.href=basePath+"homepage";
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">"+data.msg+"</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    });
}