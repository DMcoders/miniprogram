var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize:true,
        dropdownMenu: true,
        contextMenu:true,
        minRows:12,
        minCols:18,
        // colWidths:70,
        language:'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });
    var orderName=$("#orderName").val();
    var bedNumber=$("#bedNumber").val();
    var partName=$("#partName").val();
    $.ajax({
        url: "/getbyordernamebednumpart",
        type:'GET',
        data: {
            orderName:orderName,
            bedNumber:bedNumber,
            partName:partName
        },
        success: function (data) {
            // console.log(data);
            var hotData = [["订单号","顾客名","床号","颜色","尺码","部位","扎数"]];
            var i = 1;
            var sumCount = 0;
            if(data) {
                $.each(data,function (index,item) {
                    var tmp = [];
                    tmp[0] = item.orderName;
                    tmp[1] = item.customerName;
                    tmp[2] = item.bedNumber;
                    tmp[3] = item.colorName;
                    tmp[4] = item.sizeName;
                    tmp[5] = partName;
                    tmp[6] = item.layerCount;
                    sumCount = sumCount + item.layerCount;
                    hotData[i] = tmp;
                    i++;
                })
            }
            var tmpsum = [];
            tmpsum[0] = "";
            tmpsum[1] = "";
            tmpsum[2] = "";
            tmpsum[3] = "";
            tmpsum[4] = "";
            tmpsum[5] = "总量";
            tmpsum[6] = sumCount;
            hotData[i+2] = tmpsum;
            hot.loadData(hotData);
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
});