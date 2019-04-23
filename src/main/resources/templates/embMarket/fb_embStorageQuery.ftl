<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff"  style="background-color: #f7f7f7;">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">衣胚查询</li>
            </ul>

            <div class="col-md-12" style="padding-top: 20px;">
                <section class="panel panel-default">
                    <div class="panel-body">
                        <div class="row" style="margin-bottom: 10px">
                            <div class="col-md-3" style="padding:0;text-align: right;">
                                <span class="font-bold">订单号：</span>
                                <input type="text" id="orderName" class="form-control" autocomplete="off" placeholder="请输入订单号" style="width:50%;">
                                <div id="orderNameTips" style="width: 50%;margin-left: 145px;"></div>
                            </div>
                            <div class="col-md-2" style="padding:0;margin-left: 30px;">
                                <span class="font-bold">颜色：</span>
                                <select id="colorName" class="form-control" placeholder="请输入颜色" style="width:70%;">
                                </select>
                            </div>
                            <div class="col-md-2" style="padding:0;margin-left: 20px;">
                                <span class="font-bold">床次：</span>
                                <select id="bedNumber" class="form-control" placeholder="请输入床次" style="width:70%;">
                                </select>
                            </div>
                            <div class="col-md-2" style="padding:0;margin-left: 20px;">
                                <span class="font-bold">尺码：</span>
                                <select id="sizeName" class="form-control" placeholder="请输入尺码" style="width:70%;">
                                </select>
                            </div>
                            <div class="col-md-2" style="padding:0;width:12%">
                            <button  class="btn" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold, sans-serif;width:50%;"  onclick="search()">查找</button>
                            </div>
                        </div>
                        <div style="text-align: center;font-family: PingFangSC-Semibold;">
                            <table id="orderTable" class="table table-striped table-hover">
                            </table>
                        </div>
                    </div>
                </section>
            </div>
        </section>
    </section>
    <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen"
       data-target="#nav"></a>
</section>
<aside class="bg-light lter b-l aside-md hide" id="notes">
    <div class="wrapper">Notification</div>
</aside>
</section>
<#--<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">-->
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/embMarket/embStorageQuery.js?t=201904211512"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
