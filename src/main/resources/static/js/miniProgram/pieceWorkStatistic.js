$(document).ready(function () {
    laydate.render({
        elem: '#from',
        trigger: 'click'
    });
    laydate.render({
        elem: '#to',
        trigger: 'click'
    });
});


var basePath=$("#basePath").val();

function search() {
    if($("#from").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入开始日期！</span>",html: true});
        return false;
    }
    if($("#to").val().trim()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入结束日期！</span>",html: true});
        return false;
    }
    $.ajax({
        url: basePath + "querypiecework",
        type:'GET',
        data: {
            from:$("#from").val(),
            to:$("#to").val(),
            groupName:$("#groupName").val(),
            employeeNumber:$("#employeeNumber").val(),
        },
        success: function (data) {
            if(data) {
                createPieceWorkStatisticTable(data.queryPieceWork);
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，没有查到相关信息！</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
}

var pieceWorkStatisticTable;
var myDate = new Date();
function createPieceWorkStatisticTable(data) {
    if (pieceWorkStatisticTable != undefined) {
        pieceWorkStatisticTable.clear(); //清空一下table
        pieceWorkStatisticTable.destroy(); //还原初始化了的datatable
    }
    pieceWorkStatisticTable = $('#pieceWorkStatisticTable').DataTable({
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
            'title': '生产统计'+myDate.toLocaleString( ),
            'exportOptions': {
                'modifier': {
                    'page': 'all'
                }
            }
        }],
        "paging": false,
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
                "data": "employeeName",
                "title":"姓名",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "employeeNumber",
                "title":"工号",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "groupName",
                "title":"组名",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "pieceCount",
                "title":"计件",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "salary",
                "title":"工资",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "totalTime",
                "title":"理论耗时",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ]
    });


}




