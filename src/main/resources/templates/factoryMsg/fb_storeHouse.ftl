<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">仓库信息</li>
            </ul>
            <div class="col-md-12" style="padding-top: 20px;">
                <span style="font-size: 20px;font-family: PingFangSC-Semibold">仓库信息录入</span>
            </div>
            <div class="col-md-12" style="padding-top: 20px;">
                <section class="panel panel-default">
                    <div class="panel-body" style="text-align: left">
                        <div class="row" style="margin-left: 10px;margin-bottom: 20px">
                            <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addStoreHouse()">增加仓库</button>
                        </div>
                        <div style="overflow-x: auto;overflow-y:auto;max-height: 600px;text-align: center;font-family: PingFangSC-Semibold,sans-serif;">
                            <table class="table table-striped table-bordered ">
                            <#if storeHouses?? && storeHouses?size gt 0>
                                <thead>
                                    <tr bgcolor="#ffcb99" style="color: black;">
                                        <th style="width: 10%;text-align:center;font-size:14px">序号</th>
                                        <th style="width: 24%;text-align:center;font-size:14px">仓库</th>
                                        <th style="width: 24%;text-align:center;font-size:14px">容量</th>
                                        <th style="width: 24%;text-align:center;font-size:14px">二维码</th>
                                        <th style="width: 15%;text-align:center;font-size:14px">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list storeHouses as storeHouse>
                                    <tr>
                                        <td>${storeHouse_index+1}</td>
                                        <td>${storeHouse.storehouseLocation!}</td>
                                        <td>${storeHouse.storehouseCount?c}</td>
                                        <td><a href="#" style="color:#3e8eea" onclick="showQrCode('${storeHouse.storehouseLocation!}')">查看</a></td>
                                        <td><a href="#" style="color:#3e8eea" onclick="addStoreHouse(${storeHouse.storehouseID?c},'${storeHouse.storehouseLocation!}',${storeHouse.storehouseCount?c})">修改</a>&nbsp;&nbsp;<a href="#" style="color:red" onclick="deletestorehouse(${storeHouse.storehouseID?c})">删除</a></td>
                                    </tr>
                                </#list>
                                </tbody>
                            <#else>
                            <h4 style="text-align: center">暂无数据</h4>
                            </#if>
                            </table>
                        </div>
                    </div>
                </section>
            </div>
            <div class="row">
                <div id="entities" class="col-sm-12">
                </div>
                <#include "fb_storeHouseAdd.ftl">
                <@entities></@entities>
                <#include "fb_qrCode.ftl">
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
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/qrcode.min.js" type="text/javascript" ></script>
<script src="/js/factoryMsg/storeHouse.js?t=201904022212"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
