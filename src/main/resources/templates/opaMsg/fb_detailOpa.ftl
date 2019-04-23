<!DOCTYPE html>
<html>
<head>
    <#include "../feedback/fb_script.ftl">
    <@script> </@script>
    <link rel="stylesheet" href="/css/handsontable.full.min.css" type="text/css">
    <script src="/js/common/handsontable.full.min.js" type="text/javascript" ></script>
    <script src="/js/common/zh-CN.js" type="text/javascript" ></script>
    <script src="/js/opaMsg/detailOpa.js?t=201904160822"></script>
</head>

<body>
    <input  type="hidden" value="${basePath}"  id="basePath"/>
    <input  type="hidden" value="${orderName}"  id="orderName"/>
    <input  type="hidden" value="${bedNumber}"  id="bedNumber"/>
    <input  type="hidden" value="${partName}"  id="partName"/>
    <div>
        <div id="addOrderExcel" style="margin-left: 10px;"></div>
    </div>
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
