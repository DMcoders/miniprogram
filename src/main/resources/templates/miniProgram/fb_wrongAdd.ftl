<#macro entities>
<#--<section class="panel panel-default">-->
    <div id="editPro" style="display: none;cursor:default">
        <div style="overflow-x: auto;overflow-y:auto;">
            <div style="text-align: right;margin-bottom:20px">
                <a id="editNo" href="#" style="font-size:20px"><i class="fa fa-times icon" style="color: rgb(182,182,182)"></i></a>
            </div>
            <input type="text" hidden id="wrongCodeID">
            <table style="border-collapse:separate;border-spacing: 10px;width: 100%;">
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">订单号</label>
                    </td>
                    <td>
                        <input id="orderName" class="form-control" style="width: 100%;margin-bottom: 15px;border-top: none;border-right: none;border-left: none;">
                        <div id="orderNameTips"></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">质量代码</label>
                    </td>
                    <td>
                        <input id="wrongCode" class="form-control" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">质量描述</label>
                    </td>
                    <td>
                        <input id="wrongDescription" class="form-control" style="margin-bottom: 15px;width: 100%;border-top: none;border-right: none;border-left: none;">
                    </td>
                </tr>
            </table>
        </div>
        <div class="col-sm-12" style="padding-top: 10px">
            <button id="editYes" class="btn btn-s-lg" style="border-radius: 5px;"  style="text-align: center;">保存</button>
            <#--<button id="editNo" class="btn btn-danger btn-rounded btn-small" style="text-align: center;">取消</button>-->
        </div>
    </div>
<#--</section>-->
</#macro>