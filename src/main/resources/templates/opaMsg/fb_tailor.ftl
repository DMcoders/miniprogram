<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">扎号信息</li>
            </ul>

            <div id="mainFrameTabs" style="height: 80%;">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active noclose" id="orderListTab"><a id="tailorA" href="#orderListDiv" data-toggle="tab">扎号信息</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="orderListDiv" style="background-color: #f7f7f7;overflow-y:auto">
                        <div class="col-md-12" style="padding-top: 20px">
                            <section class="panel panel-default">
                                <div class="panel-body" style="text-align: left;">
                                    <div class="row" style="margin-left: 0;margin-bottom: 20px">
                                        <button  class="btn btn-s-lg" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold, sans-serif;"  onclick="addTailor()">输入裁片信息</button>
                                    </div>
                                    <#--<div class="row" style="font-family: PingFangSC-Semibold, sans-serif;margin-bottom: 15px;">-->
                                        <#--<div class="col-md-3 col-md-offset-2">-->
                                            <#--<input type="text" id="orderNameSearch" class="form-control" style="width: 180px" placeholder="请输入订单号">-->
                                        <#--</div>-->
                                        <#--<div class="col-md-3">-->
                                            <#--<input type="text" id="bedNumberSearch" class="form-control" style="width: 180px" placeholder="请输入床号">-->
                                        <#--</div>-->
                                        <#--<div class="col-md-2">-->
                                            <#--<a href="#" style="color:#3e8eea;font-size:20px" onclick="search()">查找</a>-->
                                        <#--</div>-->
                                    <#--</div>-->
                                    <div style="text-align: center;font-family: PingFangSC-Semibold,sans-serif;overflow-x: auto;">
                                        <table class="table table-striped" id="tailorTable" style="width:1500px">
                                            <thead>
                                            <tr bgcolor="#ffcb99" style="color: black;">
                                                <input type="text" hidden id="numberID" value="1">
                                                <th style="width: 3%;text-align:center;font-size:14px"><input type="checkbox"</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">序号</th>
                                                <th style="width: 6%;text-align:center;font-size:14px">订单号</th>
                                                <th style="width: 6%;text-align:center;font-size:14px">客户</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">颜色</th>
                                                <th style="width: 7%;text-align:center;font-size:14px">缸号</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">床号</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">数量</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">扎号</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">部位</th>
                                                <th style="width: 4%;text-align:center;font-size:14px">尺码</th>
                                                <th style="width: 21%;text-align:center;font-size:14px">二维码</th>
                                                <th style="width: 10%;text-align:center;font-size:14px">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="tailorBody">
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="col-md-12" style="text-align: center;margin-top: 20px">
                                        <button  class="btn btn-s-lg" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold;"  onclick="printer('preView')">打印预览</button>
                                        <button  class="btn btn-s-lg" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold;"  onclick="printer('dialog')">打印机选择对话框</button>
                                        <button  class="btn btn-s-lg" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold;"  onclick="printer('print')">打印</button>
                                    </div>
                                </div>
                            </section>
                        </div>

                    </div>

                </div>
            </div>
            <#include "fb_printWin.ftl">
                <@entities></@entities>
            <#include "fb_editTailor.ftl">
                <@entities></@entities>
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
<link rel="stylesheet" href="https://printjs-4de6.kxcdn.com/print.min.css" type="text/css">

<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/b.tabs.js?t=201904221212"></script>
<script src="/js/common/qrcode.js" type="text/javascript" ></script>
<script src="/js/common/jcpfree.js" type="text/javascript" ></script>
<script src="https://printjs-4de6.kxcdn.com/print.min.js" type="text/javascript" ></script>
<script src="/js/opaMsg/tailor.js?t=201904201412"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold;
    }
</style>
