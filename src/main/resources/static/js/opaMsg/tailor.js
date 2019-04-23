$(document).ready(function () {
    // createOrderTable();
    $('#mainFrameTabs').bTabs();

    $('#orderListTab').click(function(){
        createOrderTable();
    });
});

//计算内容区域高度
function calcHeight(){
    var browserHeight = $(window).innerHeight();
    var topHeight = $('#mainFrameHeadBar').outerHeight(true);
    var tabMarginTop = parseInt($('#mainFrameTabs').css('margin-top'));//获取间距
    var tabHeadHeight = $('ul.nav-tabs',$('#mainFrameTabs')).outerHeight(true) + tabMarginTop;
    var contentMarginTop = parseInt($('div.tab-content',$('#mainFrameTabs')).css('margin-top'));//获取内容区间距
    var contentHeight = browserHeight - topHeight - tabHeadHeight - contentMarginTop;
    $('div.tab-content',$('#mainFrameTabs')).height(contentHeight);
};

var basePath=$("#basePath").val();

function createOrderTable() {

}

var tabId = 1;
function addTailor(orderName) {
    if(orderName) {
        $('#mainFrameTabs').bTabsAdd("tabId" + orderName, "订单详情", "addTailorStart?orderName="+orderName);
    }else {
        $('#mainFrameTabs').bTabsAdd("tabId" + tabId, "裁片信息录入", "addTailorStart");
    }
    tabId++;
    // calcHeight();
}


function printer(type) {
    var tailorList = [];
    $("#tailorBody input[type='checkbox']:checked").each(function () {
        var tailor = {};
        tailor.orderName = $(this).parent().parent().find("td").eq(2).text();
        tailor.customerName = $(this).parent().parent().find("td").eq(3).text();
        tailor.colorName = $(this).parent().parent().find("td").eq(4).text();
        tailor.jarName = $(this).parent().parent().find("td").eq(5).text();
        tailor.bedNumber = $(this).parent().parent().find("td").eq(6).text();
        tailor.layerCount = $(this).parent().parent().find("td").eq(7).text();
        tailor.packageNumber = $(this).parent().parent().find("td").eq(8).text();
        tailor.partName = $(this).parent().parent().find("td").eq(9).text();
        tailor.sizeName = $(this).parent().parent().find("td").eq(10).text();
        tailor.tailorQcode = $(this).parent().parent().find("td").eq(11).text();
        tailorList.push(tailor);
    });
    if(tailorList.length<1){
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请选择要打印的信息！</span>",html: true});
    }else{
        // console.log(tailorList);
        $("div[id^='qrcode']").remove();
        $("div[id^='page']").remove();
        $("#tailorBody input[type='checkbox']:checked").each(function (index) {
            var id = index+1;
            var pageId = "page"+id;
            var qrcodeId = "qrcode"+id;
            var div = $("<div id='"+pageId+"'></div>");
            div.appendTo(document.body);
            div.append("<table style=\"border-spacing: 10px;\">\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">订单号</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printOrderName\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(2).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">客户</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printCustomerName\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(3).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">颜色</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printColorName\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(4).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">缸号</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printJarName\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(5).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">床号</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printBedNumber\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(6).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">数量</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printLayerCount\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(7).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">扎号</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printPackageNumber\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(8).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">部位</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printPartName\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(9).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"text-align: right\">尺码</td>\n" +
                "                        <td style=\"text-align: left\"><span id=\"printSizeName\" style=\"margin-left: 20px\">"+$(this).parent().parent().find('td').eq(10).text()+"</span></td>\n" +
                "                    </tr>\n" +
                "                </table>" +
                "                <div id='"+qrcodeId+"' style=\"width:130px; height:130px;text-align:left\"></div>\n" +
                "");
            var tailorQcode = $(this).parent().parent().find("td").eq(11).text();
            var qrcode = new QRCode(document.getElementById(qrcodeId), {
                width : 130,
                height : 130
            });
            qrcode.makeCode(tailorQcode);

        });

        var myDoc = {
            settings:{
                paperWidth:45,
                paperHeight:100
            },
            documents:document,   // 要打印的div 对象在当前文档document中
            copyrights:'杰创软件拥有版权  www.jatools.com'  // 版权声明,必须
        };
        var jcp = getJCP();
        if (type == 'preView') {
            jcp.printPreview(myDoc, false);
        } else if (type == 'dialog') {
            jcp.print(myDoc, true);
        } else {
            $.ajax({
                url: "/savetailordata",
                data: {tailorList: JSON.stringify(tailorList)},
                success:function(data){
                    if(data == 0) {
                        jcp.print(myDoc, false); // 不弹出对话框打印
                    }else {
                        swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，保存扎号信息失败！</span>",html: true});
                    }
                },
                error:function(){
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务器发生了未知错误～！</span>",html: true});
                }
            });
        }
    }
}

function showQrCode(obj) {
    $("#printOrderName").text($(obj).parent().parent().find("td").eq(2).text());
    $("#printCustomerName").text($(obj).parent().parent().find("td").eq(3).text());
    $("#printColorName").text($(obj).parent().parent().find("td").eq(4).text());
    $("#printJarName").text($(obj).parent().parent().find("td").eq(5).text());
    $("#printBedNumber").text($(obj).parent().parent().find("td").eq(6).text());
    $("#printLayerCount").text($(obj).parent().parent().find("td").eq(7).text());
    $("#printPackageNumber").text($(obj).parent().parent().find("td").eq(8).text());
    $("#printPartName").text($(obj).parent().parent().find("td").eq(9).text());
    $("#printSizeName").text($(obj).parent().parent().find("td").eq(10).text());
    var tailorQcode = $(obj).parent().parent().find("td").eq(11).text();
    $.blockUI({
        css: {
            width: '20%',
            top: '10%',
            left:'45%',
            border: 'none',
            padding: '15px',
            backgroundColor: '#fff',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: 1,
            color: '#000'
        },
        message: $('#qrCodeWin')
    });
    // $('#qrcode').qrcode(storehouseLocation);
    var qrcode = new QRCode(document.getElementById("qrCode"), {
        width : 130,
        height : 130
    });
    qrcode.makeCode(tailorQcode);
    $("#closeQrCodeWin").unbind("click").bind("click", function () {
        $.unblockUI();
        $('#qrCode').empty();
    });
}

function updateTailor(obj) {
    $("#orderName").val($(obj).parent().parent().find("td").eq(2).text());
    $("#customerName").val($(obj).parent().parent().find("td").eq(3).text());
    $("#colorName").val($(obj).parent().parent().find("td").eq(4).text());
    $("#jarName").val($(obj).parent().parent().find("td").eq(5).text());
    $("#bedNumber").val($(obj).parent().parent().find("td").eq(6).text());
    $("#layerCount").val($(obj).parent().parent().find("td").eq(7).text());
    $("#packageNumber").val($(obj).parent().parent().find("td").eq(8).text());
    $("#partName").val($(obj).parent().parent().find("td").eq(9).text());
    $("#sizeName").val($(obj).parent().parent().find("td").eq(10).text());
    $.blockUI({
        css: {
            width: '40%',
            top: '15%',
            border: 'none',
            padding: '15px',
            backgroundColor: '#fff',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: 1,
            color: '#000'
        },
        message: $('#editTailor')
    });

    $("#editTailorYes").unbind("click").bind("click", function () {
        var flag = false;
        $("#editTailor input").each(function () {
            if($(this).val().trim() == "") {
                flag = true;
                return false;
            }
        })
        if(flag) {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请填写完所有字段信息！</span>",html: true});
            return false;
        }
        $(obj).parent().parent().find("td").eq(2).text($("#orderName").val());
        $(obj).parent().parent().find("td").eq(3).text($("#customerName").val());
        $(obj).parent().parent().find("td").eq(4).text($("#colorName").val());
        $(obj).parent().parent().find("td").eq(5).text($("#jarName").val());
        $(obj).parent().parent().find("td").eq(6).text($("#bedNumber").val());
        $(obj).parent().parent().find("td").eq(7).text($("#layerCount").val());
        $(obj).parent().parent().find("td").eq(8).text($("#packageNumber").val());
        $(obj).parent().parent().find("td").eq(9).text($("#partName").val());
        $(obj).parent().parent().find("td").eq(10).text($("#sizeName").val());
        $(obj).parent().parent().find("td").eq(11).text($("#orderName").val()+"-"+$("#customerName").val()+"-"+$("#bedNumber").val()+"-"+$("#jarName").val()+"-"+$("#colorName").val()+"-"+$("#sizeName").val()+"-"+$("#layerCount").val()+"-"+$("#packageNumber").val()+"-"+$("#partName").val());
        $.unblockUI();
        $("#editTailor input").val("");

    });
    $("#editTailorNo").unbind("click").bind("click", function () {
        $.unblockUI();
        $("#editTailor input").val("");
    });
}

function delTailor(obj) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除该条裁片信息吗？</span>",
        type: "warning",
        html:true,
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        cancelButtonText:"我再想想",
        confirmButtonColor: "#ec6c62",
        showLoaderOnConfirm: false
    }, function() {
        $(obj).parent().parent().remove();
        swal({
                type:"success",
                title:"",
                text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，删除成功！</span>",
                html: true
            });
    });
    
}