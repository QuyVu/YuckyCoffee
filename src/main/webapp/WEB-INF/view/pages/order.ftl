<#ftl encoding='UTF-8'>
<div class="row">
	<div class="col-md-4">
		<#include "/WEB-INF/view/elements/order/make-cup.ftl"> <#-- seller create a cup-->
	</div>
	<div class="col-md-8">
		<#include "/WEB-INF/view/elements/order/ordering-table.ftl"> <#-- the cup which customer is ordering-->
		<#include "/WEB-INF/view/elements/order/checkout-table.ftl"> <#-- the order after accept cup-->	
		<div id="feedback"></div>
	</div>
</div>