<#ftl encoding='UTF-8'>
<div class="col-md-6">
<div class="panel panel-primary">
	<div class="panel-heading">
		<i class="fa fa-list fa-fw"></i>　<@spring.message "order.orderTable"/>
	</div>
	<!-- /.panel-heading -->

	<div class="panel-body">
	<#include "/elements/admin/orders/select-time.ftl"> 
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover"
				id="order-table">
				<thead>
					<tr>
						<th class="col-md-3"><@spring.message "order.id"/></th>
						<th class="col-md-3"><@spring.message "order.seller"/></th>
						<th class="col-md-4"><@spring.message "order.purchaseTime"/></th>
						<th class="col-md-2 text-center" style=""><@spring.message "total"/></th>
					</tr>
				</thead>
				<tbody id="order-tbody">
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.panel-body -->
</div>
</div>
<!-- /.panel -->