<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">订单工序</li>
            </ul>
            <div class="col-md-12" style="padding-top: 20px;">
                <span style="font-size: 20px;font-family: PingFangSC-Semibold">订单工序录入</span>
            </div>
            <div class="tab-content">
                <div class="col-md-12" style="padding-top: 20px;">
                    <section class="panel panel-default">
                        <div class="panel-body" style="text-align: left">
                            <div class="row" style="margin-left: 0;margin-bottom: 20px">
                                <button  class="btn btn-s-lg" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold, sans-serif;"  onclick="addOrderProcedure()">录入工序</button>
                            </div>
                            <div style="text-align: center;font-family: PingFangSC-Semibold;">
                                <table id="tb" class="table table-striped table-hover">
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            <div class="row">
                <div id="entities" class="col-sm-12">
                </div>
                <#include "fb_orderProcedureAdd.ftl">
                <@entities></@entities>
            </div>
        </section>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen"
       data-target="#nav"></a>
</section>
<aside class="bg-light lter b-l aside-md hide" id="notes">
    <div class="wrapper">Notification</div>
</aside>
</section>
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/css/b.tabs.css" type="text/css">

<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/b.tabs.js?t=201904221212"></script>
<script src="/js/common/qrcode.min.js" type="text/javascript" ></script>
<script src="/js/miniProgram/orderProcedure.js?t=201904241030"></script>


</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
