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

var basePath=$("#basePath").val();
function reportCut() {
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
            if(data) {
                createCutReportTable(data.reportList);
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，没有查到相关信息！</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })


}
var cutReportTable;
function createCutReportTable(data) {
    if (cutReportTable != undefined) {
        cutReportTable.clear(); //清空一下table
        cutReportTable.destroy(); //还原初始化了的datatable
    }
    cutReportTable = $('#cutReportTable').DataTable({
        "data":data,
        language : {
            processing : "载入中",//处理页面数据的时候的显示
            paginate : {//分页的样式文本内容。
                previous : "上一页",
                next : "下一页",
                first : "第一页",
                last : "最后一页"
            },
            search:"搜索：",
            zeroRecords : "没有内容",//table tbody内容为空时，tbody的内容。
            //下面三者构成了总体的左下角的内容。
            info : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//左下角的信息显示，大写的词为关键字。
            infoEmpty : "第 _PAGE_/_PAGES_页 共 _TOTAL_条记录",//筛选为空时左下角的显示。
            infoFiltered : ""//筛选之后的左下角筛选提示(另一个是分页信息显示，在上面的info中已经设置，所以可以不显示)，
        },
        dom: 'Bfrtip',
        "buttons": [{
            'extend': 'excel',
            'text': '导出',//定义导出excel按钮的文字
            'className': 'btn', //按钮的class样式
            'title': '生产统计',
            'exportOptions': {
                'modifier': {
                    'page': 'all'
                }
            }
        }],
        pageLength : 13,// 每页显示10条数据
        pagingType : "full_numbers", // 分页样式：simple,simple_numbers,full,full_numbers，
        "paging": true,
        "info": false,
        searching:true,
        lengthChange:false,
        "columns": [
            {
                "data": null,
                "title":"序号",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
                render: function (data, type, row, meta) {
                    var no = meta.settings._iDisplayStart + meta.row + 1;
                    return no;
                }
            },{
                "data": "colorName",
                "title":"颜色",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "sizeName",
                "title":"尺码",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "packageNumber",
                "title":"扎号",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "layerCount",
                "title":"数量",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ]
    });


}

// function reportCut() {
//     var container = document.getElementById('addOrderExcel');
//     hot = new Handsontable(container, {
//         // data: data,
//         rowHeaders: true,
//         colHeaders: true,
//         autoColumnSize: true,
//         dropdownMenu: true,
//         contextMenu: true,
//         minRows: 20,
//         minCols: 18,
//         // colWidths:70,
//         language: 'zh-CN',
//         licenseKey: 'non-commercial-and-evaluation'
//     });
//
//
//     if($("#orderName1").val().trim()=="") {
//         swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的订单号！</span>",html: true});
//         return false;
//     }
//     if($("#bedNumber1").val().trim()=="") {
//         swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入要查询的床号！</span>",html: true});
//         return false;
//     }
//     $.ajax({
//         url: basePath+"tailorreport",
//         type:'GET',
//         data: {
//             orderName:$("#orderName1").val(),
//             bedNumber:$("#bedNumber1").val(),
//         },
//         success: function (data) {
//             console.log(data);
//             var hotData = [["颜色","尺码","扎号","数量"]];
//             var i = 1;
//             if(data) {
//                 $.each(JSON.parse(data),function (index,item) {
//                     var tmp = [];
//                     tmp[0] = item.colorName;
//                     tmp[1] = item.sizeName;
//                     tmp[2] = item.packageNumber;
//                     tmp[3] = item.layerCount;
//                     hotData[i] = tmp;
//                     i++;
//                 })
//             }
//             hot.loadData(hotData);
//         },
//         error: function () {
//             swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
//         }
//     })
//
//
// }
