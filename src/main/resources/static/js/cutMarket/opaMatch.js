var tailorQcode = [];
var basePath=$("#basePath").val();

$(document).ready(function () {
    $("#opaQcode")[0].focus();

    document.onkeyup = function (event) {
        e = event ? event : (window.event ? window.event : null);
        if(e.keyCode==13 && e.target.getAttribute("id")=="opaQcode") {
            var areaValue = $("#opaQcode").val().split("\n");
            if(areaValue[0] == "") {
                swal({
                    type:"warning",title:"",
                    text: "<span style=\"font-weight:bolder;font-size: 20px\">二维码内容为空，请重新扫描！</span>",
                    html: true,
                    timer: 2000,
                    showConfirmButton: false,
                });
                $("#opaQcode").val("");
                return false;
            }
            var qrCode = [];
            qrCode.push(areaValue[0]);
            $("#scanNum").html("已扫描1扎");
            var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text=" + encodeURI("扫描成功");// baidu
            var n = new Audio(url);
            n.src = url;
            n.play();

            var matchJson = {};
            matchJson.tailorQcode = qrCode;

            $.ajax({
                url: basePath + "getMatch",
                type:'GET',
                data: {matchJson:JSON.stringify(matchJson)},
                success: function (data) {
                    // console.log(data);
                    var goodsLocation = "";
                    $.each(data, function(index, item) {
                        goodsLocation += item;
                        goodsLocation += "\n";
                    })
                    // $("#storeLocation").val(goodsLocation);
                    swal({
                        title:"仓库位置",
                        text: "<span style=\"font-weight:bolder;color:#F00;font-size: 50px\">"+goodsLocation+"</span>",
                        html: true,
                        timer: 5000,
                        showConfirmButton: false,
                    });
                    setTimeout (function(){
                        $("#opaQcode").val("");
                        $("#scanNum").html("已扫描0扎");
                    },5000);


                },
                error: function () {
                    swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务发生未知错误～</span>",html: true});
                }
            })

        }else if(e.keyCode==8 && e.target.getAttribute("id")=="opaQcode") {
            var areaValue = $("#opaQcode").val().split("\n");
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