$(document).ready(function () {
    laydate.render({
        elem: '#opaDate', //指定元素
        trigger: 'click'
    });

    $('#mainFrameTabs').bTabs();

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

        autoComplete(keywords);
    });

    $(document).on('click','.click_work',function(){
        var word = $(this).attr("id");
        $('#orderName').val(word);
        $('#orderNameTips').hide();

        autoComplete(word);
    });

    $("#orderName").blur(function(){
        setTimeout(function(){
            $('#orderNameTips').hide();
        },300);
        autoComplete($(this).val());
    });
});

function autoComplete(orderName) {
    $.ajax({
        url: "/getcustomernamebyordername",
        data: {"orderName": orderName},
        success:function(data){
            $("#customerName").val(data);
        },
        error:function(){
        }
    });
    $("#bedNumber").empty();
    $.ajax({
        url: "/getbednumbersbyordername",
        data: {"orderName": orderName},
        success:function(data){
            if (data.bedNumList) {
                $.each(data.bedNumList, function(index,element){
                    $("#bedNumber").append("<option value="+element.bedNumber+">"+element.bedNumber+"</option>");
                })
            }
        },
        error:function(){
        }
    });
    $("#partName").empty();
    $.ajax({
        url: "/getpartnamesbyordername",
        data: {"orderName": orderName},
        success:function(data){
            if (data.partNameList) {
                $.each(data.partNameList, function(index,element){
                    $("#partName").append("<option value="+element.partName+">"+element.partName+"</option>");
                })
            }
        },
        error:function(){
        }
    });
}

var basePath=$("#basePath").val();

function addOPA() {
    $.blockUI({
        css: {
            width: '30%',
            top: '10%',
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
    var url = basePath + "addopa";
    $("#editYes").unbind("click").bind("click", function () {
        var flag = false;
        $("#editPro input").each(function (index, item) {
            if($(this).val() == "") {
                flag = true;
                return false;
            }
        });
        if(flag) {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入完全部信息！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                orderName:$("#orderName").val(),
                customerName:$("#customerName").val(),
                destination:$("#destination").val(),
                bedNumber:$("#bedNumber").val(),
                partName:$("#partName").val(),
                opaDate:$("#opaDate").val(),
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
                        location.href=basePath+"opaStart";
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

function deleteOPA(opaID) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除该条信息吗？</span>",
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
            url: basePath + "deleteopa",
            type:'POST',
            data: {
                opaID:opaID
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
                            location.href=basePath+"opaStart";
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

function detail(orderName, bedNumber, partName) {
    partName = encodeURI(encodeURI(partName));
    $('#mainFrameTabs').bTabsAdd("tabId" + orderName, "详情", "detailOpaStart?orderName="+orderName+"&bedNumber="+bedNumber+"&partName="+partName);
}