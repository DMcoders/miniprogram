<#macro search>
    <section id="content">
        <section class="vbox">
            <section class="scrollable padder water-mark-visible-ff"  style="background-color: #f7f7f7;">
                <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                    <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                    <li class="active">裁床查漏</li>
                </ul>

                <div class="col-md-12" style="padding-top: 10px;">
                    <section class="panel panel-default">
                        <div class="panel-body">
                            <div class="row" style="margin-bottom: 10px">
                                <div class="col-md-3 col-md-offset-3" style="padding:0;">
                                    <span class="font-bold">订单号：</span>
                                    <input type="text" id="orderName" class="form-control" placeholder="请输入订单号" style="width:70%;">
                                    <div id="orderNameTips" style="width: 60% margin-left: 56px;;"></div>
                                </div>

                                <div class="col-md-3 col-md-offset-1" style="padding:0">
                                    <button  class="btn" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold, sans-serif;width:50%;"  onclick="search()">查询</button>
                                </div>

                            </div>

                            <div id="addOrderExcel" style="margin-left: 10px;"></div>

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
    <link rel="stylesheet" href="/css/handsontable.full.min.css" type="text/css">
    <script src="/js/common/handsontable.full.min.js" type="text/javascript" ></script>
    <script src="/js/common/zh-CN.js" type="text/javascript" ></script>
    <script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
    <script src="/js/orderMsg/cutQueryLeak.js?t=201904212000"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
