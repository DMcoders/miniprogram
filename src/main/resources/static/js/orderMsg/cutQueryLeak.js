var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
    $('#orderName').keyup(function(){
        var keywords = $(this).val();
        if (keywords=='') { $('#orderNameTips').hide(); return };
        $.ajax({
            url: "/getorderhint",
            data: {"subOrderName": $(this).val()},
            success:function(data){
                $('#orderNameTips').empty().show();
                if (data.orderNameList=='')
                {
                    $('#orderNameTips').append('<li class="error" style="color:red;list-style-type:none">没有结果</li>');
                }
                $.each(data.orderNameList, function(index,element){
                    if(index < 10) {
                        $('#orderNameTips').append('<li id="'+element.orderName+'" class="click_work" style="list-style-type:none">' + element.orderName + '</li>');
                    } else {
                        $('#orderNameTips').append('<div style="color:lightgray">更多选项请搜索</div>');
                        return false;
                    }
                })
            },
            error:function(){
                $('#orderNameTips').empty().show();
                $('#orderNameTips').append('<li style="color:red">搜索发生错误</li>');
            }
        });

    });

    $(document).on('click','.click_work',function(){
        var word = $(this).attr("id");
        $('#orderName').val(word);
        $('#orderNameTips').hide();

    });

    $("#orderName1").blur(function(){
        setTimeout(function(){
            $('#orderNameTips').hide();
        },300);
    });
});

function search() {
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize: true,
        dropdownMenu: true,
        contextMenu: true,
        minRows: 20,
        minCols: 18,
        // colWidths:70,
        language: 'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });


    if($("#orderName").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的订单号！</span>",html: true});
        return false;
    }
    $.ajax({
        url: basePath+"searchCutQueryLeak",
        type:'GET',
        data: {
            orderName:$("#orderName").val(),
        },
        success: function (data) {
            // console.log(data);
            var hotData = [["颜色","尺码","订单数量","裁床数量","对比"]];
            var i = 1;
            if(data) {
                $.each(JSON.parse(data),function (index,item) {
                    var tmp = [];
                    tmp[0] = item.colorName;
                    tmp[1] = item.sizeName;
                    tmp[2] = item.orderCount;
                    tmp[3] = item.layerCount;
                    tmp[4] = item.orderCount - item.layerCount;
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