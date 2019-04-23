$(document).ready(function () {

});

var basePath=$("#basePath").val();

function addEmbStore(embStoreID,embStoreLocation,embStoreCount) {
    $.blockUI({
        css: {
            width: '25%',
            top: '30%',
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
    var url = basePath + "addembstore";
    if(embStoreID) {
        $("#embStoreLocation").val(embStoreLocation);
        $("#embStoreCount").val(embStoreCount);
        $("#embStoreID").val(embStoreID);
        url = basePath + "updateembstore";
    }
    $("#editYes").unbind("click").bind("click", function () {
        if($("#embStoreLocation").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入仓库名！</span>",html: true});
            return false;
        }
        if($("#embStoreCount").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入容量！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                embStoreID:embStoreID,
                embStoreLocation:$("#embStoreLocation").val(),
                embStoreCount:$("#embStoreCount").val(),
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
                        location.href=basePath+"embStoreStart";
                    });
                }else if(data == 3) {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，仓库位置已存在，请重新输入！</span>",html: true});
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

function deleteEmbStore(embStoreID) {
    swal({
        title: "",
        text: "<span style=\"font-weight:bolder;font-size: 20px\">您确定要删除该条仓库信息吗？</span>",
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
            url: basePath + "deleteembstore",
            type:'POST',
            data: {
                embStoreID:embStoreID
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
                            location.href=basePath+"embStoreStart";
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

function showQrCode(storehouseLocation) {
    $.blockUI({
        css: {
            width: '25%',
            top: '30%',
            border: 'none',
            padding: '15px',
            backgroundColor: '#fff',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: 1,
            color: '#000'
        },
        message: $('#qrCodeWin')
    });
    // $('#qrcode').qrcode(storehouseLocation);
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 150,
        height : 150
    });
    qrcode.makeCode(storehouseLocation);
    $("#closeQrCodeWin").unbind("click").bind("click", function () {
        $.unblockUI();
        $('#qrcode').empty();
    });
}