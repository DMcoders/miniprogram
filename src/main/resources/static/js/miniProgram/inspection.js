$(document).ready(function () {
    createInspectionTable();
});

var basePath=$("#basePath").val();
var inspectionTable;
var myDate = new Date();
function createInspectionTable(){
    if (inspectionTable != undefined){
        inspectionTable.clear();
        inspectionTable.destroy();
    }
    inspectionTable = $('#inspectionTable').DataTable({
        "retrieve": true,
        "ajax": {
            "url": basePath + "getinspectionsummary",
            "data": {},
            "error": function () {
                swal("OMG!", "发生了未知错误，请联系技术童鞋～～～!", "error");
            }
        },
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
            'title': '质检明细-查询时间'+myDate.toLocaleString( ),
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
                "data": "orderName",
                "title":"订单号",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "wrongCode",
                "title":"问题",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "wrongCount",
                "title":"数量",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "wrongPercent",
                "title":"占比",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ]
    });
}






