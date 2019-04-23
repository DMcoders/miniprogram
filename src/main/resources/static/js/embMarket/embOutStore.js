var tailorQcode = [];
var basePath=$("#basePath").val();

$(document).ready(function () {
    $("#embStoreQcode")[0].focus();

    document.onkeyup = function (event) {
        e = event ? event : (window.event ? window.event : null);
        if (e.keyCode==13 && e.target.getAttribute("id")=="embStoreQcode") {
            $("#tailorQcode").focus();
            // var msg = new SpeechSynthesisUtterance("扫描成功");
            // window.speechSynthesis.speak(msg);
            var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text=" + encodeURI("扫描成功");// baidu
            var n = new Audio(url);
            n.src = url;
            n.play();
        }else if(e.keyCode==13 && e.target.getAttribute("id")=="tailorQcode") {
            // var areaRows = $("#tailorQcode").val().split("\n").length;
            var areaValue = $("#tailorQcode").val().split("\n");
            var qrCode = [];
            $.each(areaValue, function (index, value) {
                var flag = true;
                $.each(qrCode,function (index,item) {
                    if(item == value) {
                        flag = false;
                    }
                })
                if(flag && value!="") {
                    qrCode.push(value);
                }
            });
            tailorQcode = qrCode;
            $("#scanNum").html("已扫描" + qrCode.length + "件");
            // var msg = new SpeechSynthesisUtterance("扫描成功");
            // window.speechSynthesis.speak(msg);
            var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text=" + encodeURI("扫描成功");// baidu
            var n = new Audio(url);
            n.src = url;
            n.play();
        }else if(e.keyCode==8 && e.target.getAttribute("id")=="tailorQcode") {
            var areaValue = $("#tailorQcode").val().split("\n");
            var qrCode = [];
            $.each(areaValue, function (index, value) {
                var flag = true;
                $.each(qrCode,function (index,item) {
                    if(item == value) {
                        flag = false;
                    }
                })
                if(flag && value!="") {
                    qrCode.push(value);
                }
            });
            tailorQcode = qrCode;
            $("#scanNum").html("已扫描"+qrCode.length+"件");
        }
    }
});

function emboutstore() {
    if($("#embStoreQcode").val()=="") {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请扫描货架二维码！</span>",html: true});
        return false;
    }
    if(tailorQcode.length==0) {
        swal({type:"warning",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">请扫描裁片二维码！</span>",html: true});
        return false;
    }
    var embOutStoreJson = {};
    embOutStoreJson.embStoreLocation = $("#embStoreQcode").val();
    embOutStoreJson.tailorQcode = tailorQcode;

    $.ajax({
        url: basePath + "embOutstore",
        type:'POST',
        data: {embOutStoreJson:JSON.stringify(embOutStoreJson)},
        success: function (data) {
            if(data) {
                $.unblockUI();
                swal({
                        type:"success",
                        title:"",
                        text: "<span style=\"font-weight:bolder;font-size: 20px\">恭喜你，出库成功！</span>",
                        html: true
                    },
                    function(){
                        location.href=basePath+"embOutStoreStart";
                    });
            }else {
                swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">对不起，出库失败！</span>",html: true});
            }
        },
        error: function () {
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
        }
    })
}