var hot;
var basePath=$("#basePath").val();

$(document).ready(function () {
    $('#orderName1').keyup(function(){
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

        autoComplete(keywords);
    });

    $(document).on('click','.click_work',function(){
        var word = $(this).attr("id");
        $('#orderName1').val(word);
        $('#orderNameTips').hide();

        autoComplete(word);
    });

    $("#orderName1").blur(function(){
        setTimeout(function(){
            $('#orderNameTips').hide();
        },300);
        autoComplete($(this).val());
    });
});

function autoComplete(orderName) {
    $("#bedNumber1").empty();
    $.ajax({
        url: "/getbednumbersbyordername",
        data: {"orderName": orderName},
        success:function(data){
            if (data.bedNumList) {
                $.each(data.bedNumList, function(index,element){
                    $("#bedNumber1").append("<option value="+element.bedNumber+">"+element.bedNumber+"</option>");
                })
            }
        },
        error:function(){
        }
    });
}

function reportCut() {
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


    if($("#orderName1").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的订单号！</span>",html: true});
        return false;
    }
    if($("#bedNumber1").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的床号！</span>",html: true});
        return false;
    }
    $.ajax({
        url: basePath+"tailorreport",
        type:'GET',
        data: {
            orderName:$("#orderName1").val(),
            bedNumber:$("#bedNumber1").val(),
        },
        success: function (data) {
            console.log(data);
            var hotData = [["颜色","尺码","扎号","数量"]];
            var i = 1;
            if(data) {
                $.each(JSON.parse(data),function (index,item) {
                    var tmp = [];
                    tmp[0] = item.colorName;
                    tmp[1] = item.sizeName;
                    tmp[2] = item.packageNumber;
                    tmp[3] = item.layerCount;
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


function reportOpa() {
    var container = document.getElementById('addOrderExcel');
    hot = new Handsontable(container, {
        // data: data,
        rowHeaders: true,
        colHeaders: true,
        autoColumnSize: true,
        dropdownMenu: true,
        contextMenu: true,
        minRows: 20,
        minCols: 20,
        // colWidths:70,
        language: 'zh-CN',
        licenseKey: 'non-commercial-and-evaluation'
    });


    if($("#orderName1").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的订单号！</span>",html: true});
        return false;
    }
    if($("#bedNumber1").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的床号！</span>",html: true});
        return false;
    }
    $.ajax({
        url: basePath+"tailorreport",
        type:'GET',
        data: {
            orderName:$("#orderName1").val(),
            bedNumber:$("#bedNumber1").val(),
        },
        success: function (data) {
            console.log(data);
            var hotData = [["颜色","尺码","数量"]];
            var i = 1;
            if(data) {
                $.each(JSON.parse(data),function (index,item) {
                    var tmp = [];
                    tmp[0] = item.colorName;
                    tmp[1] = item.sizeName;
                    tmp[2] = item.tailorReportCount;
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