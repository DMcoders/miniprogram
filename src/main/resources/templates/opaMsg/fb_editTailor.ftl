<#macro entities>
    <div id="editTailor" style="display: none;cursor:default">
        <div style="overflow-x: auto;overflow-y:auto;">
            <div style="text-align: right;margin-bottom:20px">
                <a id="editTailorNo" href="#" style="font-size:20px"><i class="fa fa-times icon" style="color: rgb(182,182,182)"></i></a>
            </div>
            <table style="border-collapse:separate;border-spacing: 10px;width: 100%;">
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">订单号</label>
                    </td>
                    <td>
                        <input id="orderName" class="form-control" autocomplete="off" style="width: 100%;margin-bottom: 15px;">
                        <div id="orderNameTips"></div>
                    </td>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">客户名</label>
                    </td>
                    <td>
                        <input id="customerName" class="form-control" autocomplete="off" style="margin-bottom: 15px;width: 100%;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">颜色</label>
                    </td>
                    <td>
                        <input id="colorName" class="form-control" autocomplete="off" style="margin-bottom: 15px;width: 100%;">
                    </td>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">缸号</label>
                    </td>
                    <td>
                        <input id="jarName" class="form-control" autocomplete="off" style="margin-bottom: 15px;width: 100%;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">床号</label>
                    </td>
                    <td>
                        <input id="bedNumber" class="form-control" style="margin-bottom: 15px;width: 100%;" oninput="value=value.replace(/[^\d]/g,'')">
                    </td>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">数量</label>
                    </td>
                    <td>
                        <input id="layerCount" class="form-control" style="margin-bottom: 15px;width: 100%;" oninput="value=value.replace(/[^\d]/g,'')">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">扎号</label>
                    </td>
                    <td>
                        <input id="packageNumber" class="form-control" style="margin-bottom: 15px;width: 100%;" oninput="value=value.replace(/[^\d]/g,'')">
                    </td>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">部位</label>
                    </td>
                    <td>
                        <input id="partName" class="form-control" style="margin-bottom: 15px;width: 100%;">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="control-label" style="margin-bottom: 15px;text-align: right;">尺码</label>
                    </td>
                    <td>
                        <input id="sizeName" class="form-control" style="margin-bottom: 15px;width: 100%;">
                    </td>
                    <td></td>
                    <td></td>
                </tr>

            </table>
        </div>
        <div class="col-sm-12" style="padding-top: 10px">
            <button id="editTailorYes" class="btn btn-s-lg" style="border-radius: 5px;text-align: center;color:white;font-family: PingFangSC-Semibold;">保存</button>
        </div>
    </div>
</#macro>