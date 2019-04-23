var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
});

function reportStorage() {
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize: true,
        dropdownMenu: true,
        contextMenu: true,
        minRows: 20,
        minCols: 15,
        // colWidths:70,
        language: 'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });


    if($("#storehouseLocation").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的仓库名！</span>",html: true});
        return false;
    }

    $.ajax({
        url: basePath+"storagereport",
        type:'GET',
        data: {
            storehouseLocation:$("#storehouseLocation").val(),
        },
        success: function (data) {
            console.log(data);
            var hotData = [["序号","库存"]];
            var i = 1;
            if(data) {
                $.each(data,function (index,item) {
                    var tmp = [];
                    tmp[0] = i;
                    tmp[1] = item;
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
