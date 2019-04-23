<#macro entities>
<#--<section class="panel panel-default">-->
    <div id="editPro" style="display: none;cursor:default">
        <div style="overflow-x: auto;overflow-y:auto;">
            <div style="text-align: right;margin-bottom:20px">
                <a id="editNo" href="#" style="font-size:20px"><i class="fa fa-times icon" style="color: rgb(182,182,182)"></i></a>
            </div>
            <table style="border-collapse:separate;border-spacing: 10px;width: 100%;">
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">订单号</label>
                    </td>
                    <td>
                        <input id="orderName" class="form-control" autocomplete="off" style="width: 100%;margin-bottom: 15px;border-top: none;border-right: none;border-left: none;">
                        <div id="orderNameTips"></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">客户名</label>
                    </td>
                    <td>
                        <input id="customerName" class="form-control" autocomplete="off" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">发送目的地</label>
                    </td>
                    <td>
                        <input id="destination" class="form-control" autocomplete="off" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">床号</label>
                    </td>
                    <td>
                        <select id="bedNumber" class="form-control" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">部位</label>
                    </td>
                    <td>
                        <select id="partName" class="form-control" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">出厂日期</label>
                    </td>
                    <td>
                        <input id="opaDate" readonly="" class="form-control" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;background-color: white;">
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-12" style="padding-top: 10px">
            <button id="editYes" class="btn btn-s-lg" style="border-radius: 5px;"  style="text-align: center;">保存</button>
        </div>
    </div>
<#--</section>-->
</#macro>