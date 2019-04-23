<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">订单信息</li>
            </ul>

            <div id="mainFrameTabs" style="height:80%">
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active noclose" id="orderListTab"><a href="#orderListDiv" data-toggle="tab">订单信息</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="orderListDiv" style="background-color: #f7f7f7;overflow-y:auto">
                        <div class="col-md-12" style="padding-top: 20px;">
                            <section class="panel panel-default">
                                <div class="panel-body" style="text-align: left">
                                    <div class="row" style="margin-left: 0;margin-bottom: 20px">
                                        <button  class="btn btn-s-lg" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold, sans-serif;"  onclick="addOrder()">录入订单</button>
                                    </div>
                                    <div style="text-align: center;font-family: PingFangSC-Semibold;">
                                        <table id="orderTable" class="table table-striped table-hover">
                                        </table>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>

                </div>
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
<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="/css/b.tabs.css" type="text/css">

<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/b.tabs.js?t=201904221212"></script>
<script src="/js/orderMsg/order.js?t=201904071512"></script>

</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
