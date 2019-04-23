
$(document).ready(function () {
    var basePath=$("#basePath").val();
    $.ajax({
        url: basePath+"getembstoragestate",
        success:function(data){
            if(data && data != "null") {
                var json = JSON.parse(data);
                var rows = [];
                // console.log(json);
                $.each(json,function (index,item) {
                    var locations = item.embStoreLocation.split("-");
                    if(rows.indexOf(locations[0]) != -1) {
                        return true;
                    }
                    rows.push(locations[0]);

                    var html = "<div class=\"col-sm-1\" style=\"margin-top: 45px;text-align: right\">\n" +
                        "                <span style=\"font-size: 26px;font-family: PingFangSC-Semibold\">"+locations[0]+"</span>\n" +
                        "            </div>\n" +
                        "            <div class=\"col-sm-11\">\n" +
                        "                <section class=\"panel panel-default\">\n" +
                        "                    <div class=\"panel-body\" style=\"text-align: left\">\n" +
                        "                        <table name=\"storageStateTable\">\n" +
                        "                        </table>\n" +
                        "                    </div>\n" +
                        "                </section>\n" +
                        "            </div>";

                    $("#storageSection").append(html);
                });
                $.each(rows,function (index,item) {
                    var cols = [];
                    var tr = "<tr>";
                    var td = "";
                    $.each(json,function (s_index,s_item) {
                        var s_locations = s_item.embStoreLocation.split("-");
                        if(item==s_locations[0] && cols.indexOf(s_locations[1])==-1) {
                            cols.push(s_locations[1]);
                            td += "<td style='font-size: 16px;font-family: PingFangSC-Semibold;width:60px;'><span style=\"margin-left: 34px;\">"+s_locations[1]+"</span></td>";
                        }
                    });
                    tr += td+"/<tr>";
                    $("table[name='storageStateTable']").eq(index).append(tr);

                    for(var i=1;i<4;i++) {
                        var tr = "<tr>";
                        var td = "";
                        $.each(cols,function (ss_index,ss_item) {
                            var location = item+"-"+ss_item+"-"+i;
                            var flag = true;
                            $.each(json,function (sss_index,sss_item) {
                                if(location == sss_item.embStoreLocation) {
                                    var radio = sss_item.embStorageState/sss_item.embStoreCount;
                                    if(radio < 0.3) {
                                        td += "<td><label style=\"margin-left: 20px;border-radius: 6px;background: rgb(45,202,147)\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>";
                                    }else if (0.3<=radio && radio<=0.9) {
                                        td += "<td><label style=\"margin-left: 20px;border-radius: 6px;background: rgb(217,202,23)\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>";
                                    }else {
                                        td += "<td><label style=\"margin-left: 20px;border-radius: 6px;background: rgb(206,39,60)\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>";
                                    }
                                    flag = false;
                                    return false;
                                }
                            })
                            if(flag) {
                                td += "<td></td>";
                            }
                        });
                        tr += td+"</tr>";
                        $("table[name='storageStateTable']").eq(index).append(tr);
                    }
                });
            }
        },
        error:function(){
            swal({type:"error",title:"",text: "<span style=\"font-weight:bolder;font-size: 20px\">服务器发生了未知错误～！</span>",html: true});
        }
    });

});

