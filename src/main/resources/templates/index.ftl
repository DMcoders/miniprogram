<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>诚远制衣生产管理系统</title>
</head>
<#include "feedback/fb_script.ftl">
<@script> </@script>
<body>
    <input  type="hidden" value="${basePath}"  id="basePath"/>
    <div class="row" style="text-align: center">
        <label style="color:rgb(45, 202, 147);font-size: 50px;margin-top: 8%;">诚远制衣生产管理系统</label>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3" style="margin-top: 50px;">
            <div class="center-block" style="width: 43%;text-align: left;">
                <label style="color:white;font-size: 18px;">管理员账号</label>
                <input  id="userName" type="text" autocomplete="off" class="form-control center-block" placeholder="请输入账号">
            </div>
        </div>
        <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
            <div class="center-block" style="width: 43%;text-align: left;">
                <label style="color:white;font-size: 18px;">密码</label>
                <input id="passWord" autocomplete="off" type="password" class="form-control center-block" placeholder="请输入密码">
            </div>
        </div>
        <div class="col-md-6 col-md-offset-3" style="margin-top: 84px;">
            <button id="loginBtn" class="btn btn-s-lg" onclick="login()">登录</button>
        </div>
    </div>
</body>
</html>
<script src="/js/login/login.js?t=201904041912"></script>

<style>
    html,body { height: 100% }

    body{
        background:url("/images/index2.jpg") no-repeat;
        background-size: cover;
        text-align:center;
        filter: brightness(0.9);
    }

    #loginBtn {
        outline:none;
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-size: 16px;
        width:43%;
        /*font-family:PingFangSC-Semibold,sans-serif;*/
    }

    .form-control {
        width:100%;
        background: rgb(225,225,225);
        border: rgba(255,255,255);
        opacity:0.86;
        /*font-family:PingFangSC-Medium,sans-serif;*/
    }
</style>