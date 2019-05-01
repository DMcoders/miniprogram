$(document).ready(function () {
    $.ajax({
        url: basePath + "getpieceworktoday",
        type:'GET',
        data: {},
        success: function (data) {
            if(data) {
                createPieceWorkDetailTable(data.pieceWorkToday);
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，没有查到相关信息！</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
});


var basePath=$("#basePath").val();
var pieceWorkDetailTable;
var myDate = new Date();
function createPieceWorkDetailTable(data){
    if (pieceWorkDetailTable != undefined){
        pieceWorkDetailTable.clear();
        pieceWorkDetailTable.destroy();
    }
    pieceWorkDetailTable = $('#pieceWorkDetailTable').DataTable({
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
            'title': '计件明细-查询时间'+myDate.toLocaleString( ),
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
                "width":"5%",
                "defaultContent": "",
                "sClass": "text-center",
                render: function (data, type, row, meta) {
                    var no = meta.settings._iDisplayStart + meta.row + 1;
                    return no;
                }
            },{
                "data": "employeeName",
                "title":"姓名",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "employeeNumber",
                "title":"工号",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "groupName",
                "title":"组名",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "orderName",
                "title":"订单号",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "bedNumber",
                "title":"床号",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "colorName",
                "title":"颜色",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "packageNumber",
                "title":"扎号",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "layerCount",
                "title":"数量",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "procedureName",
                "title":"工序",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "pieceWorkID",
                "title": "操作",
                "width":"5%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [10], // 指定的列
                "data" : "pieceWorkID",
                "render" : function(data, type, full, meta) {
                    return "<a href='#' style='color:#ff0000' onclick='deletePieceWorkDetail("+data+")'>删除</a>";
                }
            }],
    });
}


function deletePieceWorkDetail(pieceWorkID) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除吗？</span>",
        type: "warning",
        html:true,
        showCancelButton: true,
        closeOnConfirm: false,
        confirmButtonText: "确定",
        cancelButtonText:"我再想想",
        confirmButtonColor: "#ec6c62",
        showLoaderOnConfirm: true
    }, function() {
        $.ajax({
            url: basePath + "deletepiecework",
            type:'POST',
            data: {
                pieceWorkID:pieceWorkID
            },
            success: function (data) {
                if(data == 0) {
                    $.unblockUI();
                    $("input").val("");
                    swal({
                            type:"success",
                            title:"",
                            text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，删除成功！</span>",
                            html: true
                        },
                        function(){
                            location.href=basePath+"pieceWorkDetailStart";
                        });
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，删除失败！</span>",html: true});
                }
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        })
    });
}

function changeTable(obj){
    var opt = obj.options[obj.selectedIndex];
    if (opt.value == "thisMonth"){
        $.ajax({
            url: basePath + "getpieceworkthismonth",
            type:'GET',
            data: {},
            success: function (data) {
                if(data) {
                    createPieceWorkDetailTable(data.pieceWorkThisMonth);
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，没有查到相关信息！</span>",html: true});
                }
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        })
    }
}



