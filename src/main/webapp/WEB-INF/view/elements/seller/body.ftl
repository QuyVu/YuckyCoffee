<#ftl encoding='UTF-8'>
<div class="row">
	<div class="col-md-4">
		<#include "/elements/seller/make-cup.ftl"> <#-- seller create a cup-->
	</div>
	<div class="col-md-8">
		<#include "/elements/seller/ordering-table.ftl"> <#-- the cup which customer is ordering-->
		<#include "/elements/seller/checkout-table.ftl"> <#-- the order after accept cup-->	
		<div id="feedback"></div>
	</div>
</div>