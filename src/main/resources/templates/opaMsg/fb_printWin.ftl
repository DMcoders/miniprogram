<#macro entities>
    <div id="qrCodeWin" style="display: none;cursor:default">
        <div style="overflow-x: auto;overflow-y:auto;height: 480px;">
            <div style="text-align: right;margin-bottom:10px;">
                <a id="closeQrCodeWin" href="#" style="font-size:20px"><i class="fa fa-times icon" style="color: rgb(182,182,182)"></i></a>
            </div>
            <#--<div id="page1">-->
            <div style="text-align: center">
                <table style="border-spacing: 10px;margin-left: 20px">
                    <tr>
                        <td style="text-align: right">订单号</td>
                        <td style="text-align: left"><span id="printOrderName" style="margin-left: 20px">订单号</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">客户</td>
                        <td style="text-align: left"><span id="printCustomerName" style="margin-left: 20px">客户</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">颜色</td>
                        <td style="text-align: left"><span id="printColorName" style="margin-left: 20px">白色</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">缸号</td>
                        <td style="text-align: left"><span id="printJarName" style="margin-left: 20px">02341412</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">床号</td>
                        <td style="text-align: left"><span id="printBedNumber" style="margin-left: 20px">2</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">数量</td>
                        <td style="text-align: left"><span id="printLayerCount" style="margin-left: 20px">100</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">扎号</td>
                        <td style="text-align: left"><span id="printPackageNumber" style="margin-left: 20px">1</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">部位</td>
                        <td style="text-align: left"><span id="printPartName" style="margin-left: 20px">上身</span></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">尺码</td>
                        <td style="text-align: left"><span id="printSizeName" style="margin-left: 20px">M</span></td>
                    </tr>
                </table>
                <div id="qrCode" style="width:130px; height:130px;margin: 0 auto;"></div>
            </div>
            <#--</div>-->
        </div>
    </div>

    <style>
        tr {
            height: 30px;
        }
    </style>
</#macro>
