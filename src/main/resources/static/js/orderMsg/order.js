$(document).ready(function () {
    createOrderTable();
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

var orderTable;
function createOrderTable() {
    if (orderTable != undefined) {
        orderTable.clear(); //清空一下table
        orderTable.destroy(); //还原初始化了的datatable
    }
    orderTable = $('#orderTable').DataTable({
        "retrieve": true,
        "ajax": {
            "url": basePath + "getordersummary",
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
        pageLength : 10,// 每页显示10条数据
        pagingType : "full_numbers", // 分页样式：simple,simple_numbers,full,full_numbers，
        "paging": true,
        // "ordering" : false,
        "info": false,
        searching:true,
        lengthChange:false,
        "columns": [
        {
            "data": null,
            "title":"序号",
            "width":"8%",
            "defaultContent": "",
            "sClass": "text-center",
            render: function (data, type, row, meta) {
                var no = meta.settings._iDisplayStart + meta.row + 1;
                return no;
            }
        },{
            "data": "orderName",
            "title":"订单号",
            "width":"13%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "customerName",
            "title":"客户名",
            "width":"10%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "orderSum",
            "title":"订单量",
            "width":"10%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "orderDate",
            "title":"订货日期",
            "width":"10%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "season",
            "title":"季度",
            "width":"7%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "deadLine",
            "title":"交货日期",
            "width":"10%",
            "defaultContent": "",
            "sClass": "text-center",
        }, {
            "data": "orderName",
            "title": "操作",
            "width":"12%",
            "defaultContent": "",
            "sClass": "text-center",
        }
        ],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [7], // 指定的列
                "data" : "orderClothesID",
                "render" : function(data, type, full, meta) {
                    return "<a href='#' style='color:#3e8eea' onclick='addOrder("+data+")'>订单详情</a>&nbsp;&nbsp;<a href='#' style='color:#3e8eea' onclick='deleteOrder("+data+")'>删除</a>";
                }
            }]
    });
}


function deleteOrder(orderName) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除该订单信息吗？</span>",
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
            url: basePath + "deleteorderbyname",
            type:'POST',
            data: {
                orderName:orderName
            },
            success: function (data) {
                if(data == 0) {
                    swal({type:"success",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，删除成功！</span>",html: true});
                    createOrderTable();
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

var tabId = 1;
function addOrder(orderName) {
    if(orderName) {
        $('#mainFrameTabs').bTabsAdd("tabId" + orderName, "订单详情", "addOrderStart?orderName="+orderName);
    }else {
        $('#mainFrameTabs').bTabsAdd("tabId" + tabId, "订单录入", "addOrderStart");
    }
    tabId++;
    // calcHeight();
}

