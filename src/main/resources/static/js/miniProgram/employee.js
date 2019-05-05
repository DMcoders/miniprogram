$(document).ready(function () {
    createEmployeeTable();
});

var basePath=$("#basePath").val();
var employeeTable;
function createEmployeeTable() {
    if (employeeTable != undefined) {
        employeeTable.clear(); //清空一下table
        employeeTable.destroy(); //还原初始化了的datatable
    }
    tb = $('#employeeTable').DataTable({
        "retrieve": true,
        "ajax": {
            "url": basePath + "getallemployee",
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
                "title":"部门",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "identifyCard",
                "title":"身份证号",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "bankCard",
                "title": "银行卡号",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "role",
                "title": "角色",
                "width":"10%",
                "defaultContent": "",
                "sClass": "text-center",
            }, {
                "data": "phoneNumber",
                "title": "电话",
                "width":"15%",
                "defaultContent": "",
                "sClass": "text-center",
            }
        ],
        "columnDefs" :
            [{
                "orderable" : false, // 禁用排序
                "targets" : [8], // 指定的列
                "data" : "employeeID",
                "render" : function(data, type, full, meta) {
                    return "<a href='#' style='color:#ff0000' onclick='deleteEmployee("+data+")'>删除</a>";
                }
            }],

    });
}



function addEmployee(employeeID,employeeName,employeeNumber,groupName,identifyCard,bankCard,role,phoneNumber) {
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
    var url = basePath + "addemployee";
    $("#editYes").unbind("click").bind("click", function () {
        if($("#employeeName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入姓名！</span>",html: true});
            return false;
        }
        if($("#employeeNumber").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入工号！</span>",html: true});
            return false;
        }
        if($("#groupName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入部门！</span>",html: true});
            return false;
        }
        if($("#identifyCard").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入身份证号！</span>",html: true});
            return false;
        }
        if($("#bankCard").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入银行卡号！</span>",html: true});
            return false;
        }
        if($("#role").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入角色！</span>",html: true});
            return false;
        }
        if($("#phoneNumber").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入电话！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                employeeID:employeeID,
                employeeName:$("#employeeName").val(),
                employeeNumber:$("#employeeNumber").val(),
                groupName:$("#groupName").val(),
                identifyCard:$("#identifyCard").val(),
                bankCard:$("#bankCard").val(),
                role:$("#role").val(),
                phoneNumber:$("#phoneNumber").val()
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
                        location.href=basePath+"employeeStart";
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








function deleteEmployee(employeeID) {
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
            url: basePath + "deleteemployee",
            type:'POST',
            data: {
                employeeID:employeeID
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
                            location.href=basePath+"employeeStart";
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

