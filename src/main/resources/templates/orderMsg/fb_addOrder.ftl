<!DOCTYPE html>
<html>
<head>
    <#include "../feedback/fb_script.ftl">
    <@script> </@script>
    <link rel="stylesheet" href="/css/handsontable.full.min.css" type="text/css">
    <script src="/js/common/handsontable.full.min.js" type="text/javascript" ></script>
    <script src="/js/common/zh-CN.js" type="text/javascript" ></script>
    <script src="/js/orderMsg/addOrder.js?t=201904192115"></script>
</head>

<body>
    <input  type="hidden" value="${basePath}"  id="basePath"/>
    <input  type="hidden" value="${type}"  id="type"/>
    <#if type == "detail">
    <input  type="hidden" value="${orderName}"  id="orderName"/>
    </#if>
    <#if type == "add">
    <div class="col-md-12" style="padding-top: 20px;padding-bottom:10px;margin-left: 10px">
        <span style="font-size: 20px;font-family: PingFangSC-Semibold;color:rgb(55,56,57)">订单详情录入（请必须按照顾客名、订购方式、款号款式描述、版单号、颜色号、颜色名、签订日期、季度、交货日期、尺码数量来粘贴）</span>
    </div>
    </#if>
    <div>
        <div id="addOrderExcel" style="margin-left: 10px;"></div>
    </div>
    <#if type == "add">
    <div class="col-md-12" style="text-align: center;margin-top: 20px">
        <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addOrder()">提交</button>
    </div>
    </#if>
</body>
</html>
<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold;
    }
</style>
