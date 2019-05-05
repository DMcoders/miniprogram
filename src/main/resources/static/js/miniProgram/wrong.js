$(document).ready(function () {
    createWrongTable();

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

    $("#orderName").blur(function(){
        setTimeout(function(){
            $('#orderNameTips').hide();
        },300);
    });

});

var basePath=$("#basePath").val();


var wrongTable;
function createWrongTable() {
    if (wrongTable != undefined) {
        wrongTable.clear(); //清空一下table
        wrongTable.destroy(); //还原初始化了的datatable
    }
    wrongTable = $('#wrongTable').DataTable({
        "retrieve": true,
        "ajax": {
            "url": basePath + "getallwrong",
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
        pageLength : 13,// 每页显示10条数据
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
            }, {
                "data": "orderName",
                "title":"订单号",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "wrongCode",
                "title":"质量代码",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "wrongDescription",
                "title":"质量描述",
                "width":"20%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "wrongCodeID",
                "title": "操作",
                "width":"8%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [4], // 指定的列
                "data" : "wrongCodeID",
                "render" : function(data, type, full, meta) {
                    return "<a href='#' style='color:#ff0000' onclick='deleteOrderProcedure("+data+")'>删除</a>";
                }
            }],

    });
}



function addWrong(wrongCodeID,orderName,wrongCode,wrongDescription) {
    $.blockUI({
        css: {
            width: '30%',
            top: '15%',
            border: 'none',
            padding: '15px',
            backgroundColor: '#fff',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: 1,
            color: '#000'
        },
        message: $('#editPro')
    });
    var url = basePath + "addwrong";
    $("#editYes").unbind("click").bind("click", function () {
        if($("#orderName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入订单号！</span>",html: true});
            return false;
        }
        if($("#wrongCode").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入质量代码！</span>",html: true});
            return false;
        }
        if($("#wrongDescription").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入质量描述！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                wrongCodeID:wrongCodeID,
                orderName:$("#orderName").val(),
                wrongCode:$("#wrongCode").val(),
                wrongDescription:$("#wrongDescription").val()
            },
            success: function (data) {
                if(data == 0) {
                    $.unblockUI();
                    $("input").val("");
                    swal({
                        type:"success",
                        title:"",
                        text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，保存成功！</span>",
                        html: true
                    },
                    function(){
                        location.href=basePath+"wrongStart";
                    });
                }else {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，保存失败！</span>",html: true});
                }
            },
            error: function () {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
            }
        });
    });
    $("#editNo").unbind("click").bind("click", function () {
        $.unblockUI();
        $("input").val("");
    });
}








function deleteOrderProcedure(orderProcedureID) {
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
            url: basePath + "deleteorderprocedure",
            type:'POST',
            data: {
                orderProcedureID:orderProcedureID
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
                            location.href=basePath+"orderProcedureStart";
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

