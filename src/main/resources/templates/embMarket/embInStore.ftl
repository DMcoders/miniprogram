<!DOCTYPE html>
<html lang="en" class="app">
<#include "../feedback/fb_script.ftl">
<@script> </@script>
<body>
<section class="vbox">
    <input  type="hidden" value="${basePath}"  id="basePath"/>
    <#include "../feedback/fb_header.ftl">
    <@head> </@head>
    <section>
        <section class="hbox stretch">
            <#include "../feedback/fb_menu.ftl">
            <@aside></@aside>
            <#include "fb_embInStore.ftl">
            <@search> </@search>
        </section>
    </section>
</section>
</body>