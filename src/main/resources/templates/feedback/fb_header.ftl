<#macro head>
<header class="bg-dark dk header navbar navbar-fixed-top-xs">
    <div class="navbar-header aside-md">
        <#--<a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav">-->
            <#--<i class="fa fa-bars"></i>-->
        <#--</a>-->
        <a href="/homepage" class="navbar-brand" style="font-size: 24px;color:rgb(45, 202, 147);margin-left: 40px;" data-toggle="fullscreen">诚远制衣</a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user">
            <i class="fa fa-cog"></i>
        </a>
    </div>
    <ul class="nav navbar-nav navbar-right hidden-xs nav-user">
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> ${userName!""} <b
                class="caret"></b> </a>
            <ul class="dropdown-menu animated fadeInRight">
                <span class="arrow top"></span>
                <li><a onclick="loginOut()" href="#">退出</a></li>
            </ul>
        </li>
    </ul>
</header>
<script>
    function loginOut() {
        swal({
            title: "",
            text: "<span style=\"font-weight:bolder;font-size: 20px\">你确定退出么？</span>",
            type: "warning",
            html:true,
            showCancelButton: true,
            closeOnConfirm: false,
            confirmButtonText: "确定",
            cancelButtonText:"我再想想",
            confirmButtonColor: "#ec6c62",
            showLoaderOnConfirm: false
        }, function() {
            window.location.href = "/";
        });
    }
</script>
</#macro>


