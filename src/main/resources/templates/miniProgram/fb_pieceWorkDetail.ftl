<#macro search>
<section id="content">
    <section class="vbox">
        <section class="scrollable padder water-mark-visible-ff">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                <li><a href="/homepage"><i class="fa fa-home"></i> Home</a></li>
                <li class="active">计件明细</li>
            </ul>
            <div class="col-md-12" style="padding-top: 20px;">
                <section class="panel panel-default">
                    <div class="panel-body">
                        <div class="row" style="margin-bottom: 10px">
                            <div class="col-md-2" style="padding:0;text-align: left; margin-left: 10px;">
                                <button  class="btn" style="border-radius: 5px;color:white;font-family: PingFangSC-Semibold, sans-serif;width:60%;"  onclick="search()">手动输入</button>
                            </div>
                            <div class="col-md-2" style="padding:0;margin-left: 50px;">
                            </div>
                            <div class="col-md-2" style="padding:0;margin-left: 50px;">
                            </div>
                            <div class="col-md-2" style="padding:0;margin-left: 50px;">
                            </div>
                            <div class="col-md-2" style="padding:0;text-align: right; margin-left: 0px;">
                                <select class="btn btn-default" style="border-radius: 5px;color:black;font-family: PingFangSC-Semibold, sans-serif;width:60%;" onchange="changeTable(this)">
                                    <option value="today">今日</option>
                                    <option value="thisMonth">本月</option>
                                </select>
                            </div>
                        </div>
                        <div style="text-align: center;font-family: PingFangSC-Semibold;">
                            <table id="pieceWorkDetailTable" class="table table-striped table-hover">
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
<link rel="stylesheet" href="/css/b.tabs.css" type="text/css">
<script src="/js/common/laydate.js" type="text/javascript" ></script>
<script src="/js/common/jquery.blockUI.js" type="text/javascript" ></script>
<script src="/js/common/b.tabs.js?t=201904221212"></script>
<link rel="stylesheet" href="/css/selectize.bootstrap3.css" type="text/css">
<script src="/js/common/selectize.js" type="text/javascript"></script>
<#--<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" type="text/css">-->
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css" type="text/css">

<#--<script src="/js/common/buttons.html5.min.js" type="text/javascript"></script>-->
<#--<script src="/js/common/dataTables.buttons.min.js" type="text/javascript"></script>-->
<#--<script src="/js/common/jszip.min.js" type="text/javascript"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.html5.min.js"></script>

<script src="/js/miniProgram/pieceWorkDetail.js?t=201905011354"></script>


</#macro>

<style>
    button {
        background:rgb(45, 202, 147);
        opacity:0.86;
        color: white;
        font-family: PingFangSC-Semibold, sans-serif;
    }
</style>
