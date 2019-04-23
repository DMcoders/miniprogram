var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
    var type=$("#type").val();
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize:true,
        dropdownMenu: true,
        contextMenu:true,
        minRows:18,
        minCols:22,
        // colWidths:70,
        language:'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });
    if(type == "detail") {
        var orderName=$("#orderName").val();
        $.ajax({
            url: "/getorderbyname",
            type:'GET',
            data: {
                orderName:orderName
            },
            success: function (data) {
                // console.log(data);
                var hotData = [["顾客名","订购方式","订单号","款式描述","版单号","颜色号","颜色名","尺码","数量","签订日期","季度","交货日期"]];
                var i = 1;
                if(data) {
                    $.each(data,function (index,item) {
                        var tmp = [];
                        tmp[0] = item.customerName;
                        tmp[1] = item.purchaseMethod;
                        tmp[2] = item.orderName;
                        tmp[3] = item.styleDescription;
                        tmp[4] = item.clothesVersionNumber;
                        tmp[5] = item.colorNumber;
                        tmp[6] = item.colorName;
                        tmp[7] = item.sizeName;
                        tmp[8] = item.count;
                        tmp[9] = item.orderDate;
                        tmp[10] = item.season;
                        tmp[11] = item.deadLine;
                        hotData[i] = tmp;
                        i++;
                    })
                }
                hot.loadData(hotData);
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        })
    }
});

function addOrder() {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要提交输入的订单信息吗？</span>",
        type: "warning",
        html:true,
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        cancelButtonText:"我再想想",
        confirmButtonColor: "#ec6c62",
        showLoaderOnConfirm: false
    }, function() {
        var orderclothesJson = [];
        var data = hot.getData();
        // console.log(data);
        var titleRow = data[0];
        var endIndex = titleRow.length;
        $.each(titleRow,function (index, item) {
            if(item==null || item=="") {
                endIndex = index;
                return false;
            }
        });
        titleRow.splice(endIndex,titleRow.length-endIndex);
        $.each(data,function (index, item) {
            if(index!=0 && item[0]!=null && item[0]!="") {
                var orderclothes = {};
                orderclothes.customerName = item[0];
                orderclothes.purchaseMethod = item[1];
                orderclothes.orderName = item[2];
                orderclothes.styleDescription = item[3];
                orderclothes.clothesVersionNumber = item[4];
                orderclothes.colorNumber = item[5];
                orderclothes.colorName = item[6];
                orderclothes.orderDate = item[7];
                orderclothes.season = item[8];
                orderclothes.deadLine = item[9];
                var size = {};
                for(var i=10;i<titleRow.length;i++) {
                    if(item[i]!=null && item[i]!="") {
                        size[titleRow[i]] = item[i];
                    }
                }
                orderclothes.size = size;
                orderclothesJson.push(orderclothes);
            }
        });
        // console.log(orderclothesJson);
        $.ajax({
            url: "/commitorderclothes",
            type:'POST',
            data: {
                orderclothesJson:JSON.stringify(orderclothesJson)
            },
            success: function (data) {
                if(data == 0) {
                    swal({type:"success",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，录入成功！</span>",html: true});
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，录入失败！</span>",html: true});
                }
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        })
    })
}