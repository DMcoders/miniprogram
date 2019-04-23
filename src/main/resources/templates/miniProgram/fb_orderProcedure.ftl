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
            <div class="col-md-12" style="padding-top: 20px;">
                <section class="panel panel-default">
                    <div class="panel-body" style="text-align: left">
                        <div class="row" style="margin-left: 10px;margin-bottom: 20px">
                            <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addOrderProcedure()">录入工序</button>
                        </div>
                        <div style="overflow-x: auto;overflow-y:auto;max-height: 600px;text-align: center;font-family: PingFangSC-Semibold,sans-serif;">
                            <table id="tb" class="table table-striped table-bordered ">
                            <#if orderProcedures?? && orderProcedures?size gt 0>
                                <thead>
                                    <tr bgcolor="#ffcb99" style="color: black;">
                                        <th style="width: 10%;text-align:center;font-size:14px">序号</th>
                                        <th style="width: 15%;text-align:center;font-size:14px">订单号</th>
                                        <th style="width: 15%;text-align:center;font-size:14px">工序名</th>
                                        <th style="width: 15%;text-align:center;font-size:14px">工序单价</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">工序耗时</th>
                                        <th style="width: 10%;text-align:center;font-size:14px">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#list orderProcedures as orderProcedure>
                                        <tr>
                                            <td>${orderProcedure_index+1}</td>
                                            <td>${orderProcedure.orderName!}</td>
                                            <td>${orderProcedure.procedureName!}</td>
                                            <td>${orderProcedure.procedurePrice!}</td>
                                            <td>${orderProcedure.procedureTime!}</td>
                                            <td><a href="#" style="color:red" onclick="deleteOrderProcedure(${orderProcedure.orderProcedureID?c})">删除</a></td>
                                            <#--<td><a href="#" style="color:#3e8eea" onclick="addCustomer(${customer.customerID?c},'${customer.customerName!}','${customer.companyName!}','${customer.linkmanName!}','${customer.linkmanPhone!}','${customer.companyAddress!}')">修改</a>&nbsp;&nbsp;<a href="#" style="color:red" onclick="deleteCustomer(${customer.customerID?c})">删除</a></td>-->
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
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/qrcode.min.js" type="text/javascript" ></script>
<script src="/js/miniProgram/orderProcedure.js?t=201904232225"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
