window.onload=autoRowSpan;
$(document).ready(function () {
});

var basePath=$("#basePath").val();

function addOrderProcedure(orderProcedureID,orderName,procedureName,procedurePrice,procedureTime) {
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
    var url = basePath + "addorderprocedure";
    $("#editYes").unbind("click").bind("click", function () {
        if($("#orderName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入订单号！</span>",html: true});
            return false;
        }
        if($("#procedureName").val().trim()=="") {
            swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请输入工序名！</span>",html: true});
            return false;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {
                orderProcedureID:orderProcedureID,
                orderName:$("#orderName").val(),
                procedureName:$("#procedureName").val(),
                procedurePrice:$("#procedurePrice").val(),
                procedureTime:$("#procedureTime").val()
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
                        location.href=basePath+"orderProcedureStart";
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


function autoRowSpan() {
    var tb = document.getElementById("tb");
    var lastValue="";
    var value="";
    var pos=1;
    for(var i=0;i<tb.rows.length;i++){
        value = tb.rows[i].cells[1].innerText;
        if(lastValue == value){
            tb.rows[i].deleteCell(1);
            tb.rows[i-pos].cells[1].rowSpan = tb.rows[i-pos].cells[1].rowSpan+1;
            pos++;
        }else{
            lastValue = value;
            pos=1;
        };
    };
}