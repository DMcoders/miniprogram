$(document).ready(function () {
    createDispathTable();
    $('#employeeNumber').keyup(function(){
        var keywords = $(this).val();
        if (keywords=='') { $('#employeeNumberTips').hide(); return };
        $.ajax({
            url: "/getemphint",
            data: {"subEmployeeNumber": $(this).val()},
            success:function(data){
                $('#employeeNumberTips').empty().show();
                if (data.employeeNumberList=='')
                {
                    $('#employeeNumberTips').append('<li class="error" style="color:red;list-style-type:none">没有结果</li>');
                }
                $.each(data.employeeNumberList, function(index,element){
                    if(index < 10) {
                        $('#employeeNumberTips').append('<li id="'+element.employeeNumber+'" class="click_work" style="list-style-type:none">' + element.employeeNumber + '</li>');
                    } else {
                        $('#employeeNumberTips').append('<div style="color:lightgray">更多选项请搜索</div>');
                        return false;
                    }
                })
            },
            error:function(){
                $('#employeeNumberTips').empty().show();
                $('#employeeNumberTips').append('<li style="color:red">搜索发生错误</li>');
            }
        });

        autoComplete(keywords);
    });

    // $('#orderName').keyup(function(){
    //     var keywords = $(this).val();
    //     if (keywords=='') { $('#orderNameTips').hide(); return };
    //     $.ajax({
    //         url: "/getorderhint",
    //         data: {"subOrderName": $(this).val()},
    //         success:function(data){
    //             $('#orderNameTips').empty().show();
    //             if (data.orderNameList=='')
    //             {
    //                 $('#orderNameTips').append('<li class="error" style="color:red;list-style-type:none">没有结果</li>');
    //             }
    //             $.each(data.orderNameList, function(index,element){
    //                 if(index < 10) {
    //                     $('#orderNameTips').append('<li id="'+element.orderName+'" class="click_work" style="list-style-type:none">' + element.orderName + '</li>');
    //                 } else {
    //                     $('#orderNameTips').append('<div style="color:lightgray">更多选项请搜索</div>');
    //                     return false;
    //                 }
    //             })
    //         },
    //         error:function(){
    //             $('#orderNameTips').empty().show();
    //             $('#orderNameTips').append('<li style="color:red">搜索发生错误</li>');
    //         }
    //     });
    //
    //     autoCompleteAnother(keywords);
    // });

    $(document).on('click','.click_work',function(){
        var word = $(this).attr("id");
        $('#employeeNumber').val(word);
        $('#employeeNumberTips').hide();

        autoComplete(word);
    });

    $("#employeeNumber").blur(function(){
        setTimeout(function(){
            $('#employeeNumberTips').hide();
        },300);
        autoComplete($(this).val());
    });


    // $(document).on('click','.click_work',function(){
    //     var word = $(this).attr("id");
    //     $('#orderName').val(word);
    //     $('#orderNameTips').hide();
    //
    //     autoCompleteAnother(word);
    // });
    //
    // $("#orderName").blur(function(){
    //     setTimeout(function(){
    //         $('#orderNameTips').hide();
    //     },300);
    //     autoCompleteAnother($(this).val());
    // });


});


function autoComplete(employeeNumber) {
    $.ajax({
        url: "/getempnamebyempnum",
        data: {"employeeNumber": employeeNumber},
        success:function(data){
            $("#employeeName").val(data);
            $("#employeeName").attr("disabled",true);
        },
        error:function(){
        }
    });
    $("#groupName").empty();
    $.ajax({
        url: "/getgroupnamebyempnum",
        data: {"employeeNumber": employeeNumber},
        success:function(data){
            $("#groupName").val(data);
            $("#groupName").attr("disabled",true);
        },
        error:function(){
        }
    });
}


function autoCompleteAnother(orderName) {
    $.ajax({
        url: "/getprocedurenamesbyorder",
        data: {"orderName": orderName},
        success:function(data){
            if (data.proceNameList) {
                $.each(data.proceNameList, function(index,element){
                    $("#procedureName").append("<option value="+element.procedureName+">"+element.procedureName+"</option>");
                })
            }
        },
        error:function(){
        }
    });
}

var basePath=$("#basePath").val();

var tb;
function createDispathTable() {
    if (tb != undefined) {
        tb.clear(); //清空一下table
        tb.destroy(); //还原初始化了的datatable
    }
    tb = $('#tb').DataTable({
        "retrieve": true,
        "ajax": {
            "url": basePath + "getalldispatch",
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
            },{
                "data": "orderName",
                "title":"订单号",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "procedureName",
                "title": "工序",
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
                "data": "employeeName",
                "title":"姓名",
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
                "data": "dispatchID",
                "title": "操作",
                "width":"8%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [6], // 指定的列
                "data" : "dispatchID",
                "render" : function(data, type, full, meta) {
                    return "<a href='#' style='color:#ff0000' onclick='deleteDispatch("+data+")'>删除</a>";
                }
            }],

    });
}



function addDispatch(dispatchID,employeeNumber,employeeName,groupName,orderName,procedureName) {
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
    var url = basePath + "adddispatch";
    $("#editYes").unbind("click").bind("click", function () {
        if($("#employeeNumber").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入工号！</span>",html: true});
            return false;
        }
        if($("#orderName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入订单号！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                dispatchID:dispatchID,
                employeeNumber:$("#employeeNumber").val(),
                employeeName:$("#employeeName").val(),
                groupName:$("#groupName").val(),
                orderName:$("#orderName").val(),
                procedureName:$("#procedureName").val()
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
                        location.href=basePath+"dispatchStart";
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




function deleteDispatch(dispatchID) {
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
            url: basePath + "deletedispatch",
            type:'POST',
            data: {
                dispatchID:dispatchID
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
                            location.href=basePath+"dispatchStart";
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

