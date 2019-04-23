<!DOCTYPE html>
<html>
<head>
    <#include "../feedback/fb_script.ftl">
    <@script> </@script>
    <link rel="stylesheet" href="/css/handsontable.full.min.css" type="text/css">
    <link rel="stylesheet" href="/css/selectize.bootstrap3.css" type="text/css">
    <script src="/js/common/selectize.js" type="text/javascript"></script>
    <script src="/js/common/handsontable.full.min.js" type="text/javascript" ></script>
    <script src="/js/common/zh-CN.js" type="text/javascript" ></script>
    <script src="/js/opaMsg/addTailor.js?t=201904191814"></script>
</head>

<body>
    <input  type="hidden" value="${basePath}"  id="basePath"/>
    <input  type="hidden" value="${type}"  id="type"/>
    <#if type == "detail">
    <input  type="hidden" value="${orderName}"  id="orderName"/>
    </#if>
    <div class="col-md-12" style="padding-top: 20px;padding-bottom:10px;margin-left: 10px">
        <span style="font-size: 20px;font-family: PingFangSC-Semibold;color:rgb(55,56,57)">输入裁片信息</span>
    </div>
    <div class="row">
        <div class="col-md-3">
            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>数量录入
                </header>
                <div  style="width:100%;overflow-y: auto;height: 410px;">
                    <div id="layerCountExcel"></div>
                </div>
            </section>
        </div>
        <div class="col-md-9">
            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>基本信息
                </header>
                <table style="border-collapse:separate;border-spacing: 10px;width: 100%;" id="baseInfo">
                    <tr>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label" style="">订单号</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="orderName" class="form-control" autocomplete="off">
                            <div id="orderNameTips"></div>
                        </td>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label">缸号</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="jarName" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label" style="">客户</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="customerName" class="form-control">
                        </td>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label">颜色</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <select id="colorName" class="form-control">
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right;margin-bottom: 15px;">
                            <label class="control-label" style="">床号</label>
                        </td>
                        <td style="margin-bottom: 15px;">
                            <input id="bedNumber" class="form-control" oninput="value=value.replace(/[^\d]/g,'')">
                        </td>
                        <td style="text-align: right;margin-bottom: 15px;">
                        </td>
                        <td style="margin-bottom: 15px;">
                        </td>
                    </tr>

                </table>
            </section>

            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>唛架配比
                </header>
                <div style="margin-top: 10px;margin-left: 20px">
                    <label class="control-label" style="">尺码</label>
                    <input name="size" class="form-control" autocomplete="off" style="width:20%">
                </div>
                <div style="margin-bottom: 10px;margin-left: 20px">
                    <label class="control-label" style="">配比</label>
                    <input name="radio" class="form-control" autocomplete="off" style="width:20%" oninput="value=value.replace(/[^\d]/g,'')">
                    <button  class="btn btn-s-xs" style="border-radius: 5px;margin-left: 10px"  onclick="addSize(this)">增加</button>
                    <button  class="btn btn-s-xs" style="border-radius: 5px;margin-left: 10px;background-color: rgb(236, 108, 98);display: none"  onclick="delSize(this)">删除</button>
                </div>
            </section>

            <section class="panel panel-default">
                <header class="panel-heading font-bold">
                    <span class="label bg-success pull-right"></span>部位选择(直接输入，按Enter确认)
                </header>
                <div style="margin-top: 10px;margin-left: 20px;height: 120px;">
                    <select id="partName" multiple style="width:90%" >
                    </select>
                </div>
                <#--<div style="height: 120px">-->
                <#--<div class="RadioStyle">-->
                    <#--<div>-->
                        <#--<input type="checkbox" id="part1" value="大身"/>-->
                        <#--<label for="part1">大身</label>-->
                        <#--<input type="checkbox" id="part2" value="前身"/>-->
                        <#--<label for="part2">前身</label>-->
                        <#--<input type="checkbox" id="part3" value="后身"/>-->
                        <#--<label for="part3">后身</label>-->
                        <#--<input type="checkbox" id="part4" value="左胸"/>-->
                        <#--<label for="part4">左胸</label>-->
                        <#--<input type="checkbox" id="part5" value="大身2"/>-->
                        <#--<label for="part5">大身2</label>-->
                        <#--<input type="checkbox" id="part6" value="前身2"/>-->
                        <#--<label for="part6">前身2</label>-->
                        <#--<input type="checkbox" id="part7" value="后身2"/>-->
                        <#--<label for="part7">后身2</label>-->
                        <#--<input type="checkbox" id="part8" value="左胸2"/>-->
                        <#--<label for="part8">左胸2</label>-->
                    <#--</div>-->
                    <#--<div>-->
                        <#--<input type="checkbox" id="part9" value="大身3"/>-->
                        <#--<label for="part9">大身3</label>-->
                        <#--<input type="checkbox" id="part10" value="前身3"/>-->
                        <#--<label for="part10">前身3</label>-->
                        <#--<input type="checkbox" id="part11" value="后身3"/>-->
                        <#--<label for="part11">后身3</label>-->
                        <#--<input type="checkbox" id="part12" value="左胸3"/>-->
                        <#--<label for="part12">左胸3</label>-->
                        <#--<input type="checkbox" id="part13" value="大身4"/>-->
                        <#--<label for="part13">大身4</label>-->
                        <#--<input type="checkbox" id="part14" value="前身4"/>-->
                        <#--<label for="part14">前身4</label>-->
                        <#--<input type="checkbox" id="part15" value="后身4"/>-->
                        <#--<label for="part15">后身4</label>-->
                        <#--<input type="checkbox" id="part16" value="左胸4"/>-->
                        <#--<label for="part16">左胸4</label>-->
                    <#--</div>-->
                    <#--<div>-->
                        <#--<input type="checkbox" id="part17" value="大身5"/>-->
                        <#--<label for="part17">大身5</label>-->
                        <#--<input type="checkbox" id="part18" value="前身5"/>-->
                        <#--<label for="part18">前身5</label>-->
                        <#--<input type="checkbox" id="part19" value="后身5"/>-->
                        <#--<label for="part19">后身5</label>-->
                        <#--<input type="checkbox" id="part20" value="左胸5"/>-->
                        <#--<label for="part20">左胸5</label>-->
                        <#--<input type="checkbox" id="part21" value="大身6"/>-->
                        <#--<label for="part21">大身6</label>-->
                        <#--<input type="checkbox" id="part22" value="前身6"/>-->
                        <#--<label for="part22">前身6</label>-->
                        <#--<input type="checkbox" id="part23" value="后身6"/>-->
                        <#--<label for="part23">后身6</label>-->
                        <#--<input type="checkbox" id="part24" value="左胸6"/>-->
                        <#--<label for="part24">左胸6</label>-->
                    <#--</div>-->

                </div>
                </div>
            </section>
        </div>
    </div>
    <div class="col-md-12" style="text-align: center;margin-top: auto">
        <button  class="btn btn-s-lg" style="border-radius: 5px;"  onclick="addOrder()">生成</button>
    </div>
</body>
</html>
<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }

    label {
        font-family: PingFangSC-Semibold;
    }

    /*.RadioStyle input {*/
        /*display: none*/
    /*}*/
    /*.RadioStyle label {*/
        /*border: 1px solid #CCC;*/
        /*color: #666;*/
        /*padding: 2px 10px 2px 5px;*/
        /*line-height: 28px;*/
        /*min-width: 70px;*/
        /*text-align: center;*/
        /*!*float: left;*!*/
        /*margin: 2px;*/
        /*border-radius: 4px;*/
        /*margin-left: 12px;*/
    /*}*/
    /*.RadioStyle input:checked + label {*/
        /*background: url("/images/ico_checkon.svg") no-repeat right bottom;*/
        /*border: 1px solid rgb(45, 202, 147);*/
        /*background-size: 21px 21px;*/
        /*color: rgb(45, 202, 147)*/
    /*}*/
    /*.RadioStyle input:disabled + label {*/
        /*opacity: 0.7;*/
    /*}*/
</style>
