<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading">
		<i class="fa fa-list fa-fw"></i> Orders Table
	</div>
	<!-- /.panel-heading -->

	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover"
				id="order-table">
				<thead>
					<tr>
						<th class="col-md-2">Order ID</th>
						<th class="col-md-4">Seller name</th>
						<th class="col-md-4">Purchase Time</th>
						<th class="col-md-2 text-center" style="">Total</th>
					</tr>
				</thead>
				<tbody id="order-tbody">
					<#list foo["orders"] as order>
					<tr>
						<td>${order.orderID!""}</td>
						<td>${order.userName!""}</td>
						<td>${order.purchaseTime!""}</td>
						<td class="text-center">${order.total!""} $</td>
					</tr>
					</#list>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.panel-body -->
</div>
<!-- /.panel -->