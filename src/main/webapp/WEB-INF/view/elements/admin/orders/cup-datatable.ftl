<#ftl encoding='UTF-8'>
<div class="col-md-6">
<div class="panel panel-primary">
	<div id="tb-heading" class="panel-heading">
		<i class="fa fa-list fa-fw"></i> <@spring.message "order.cupTable"/>
	</div>
	<!-- /.panel-heading -->

	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover" id="cup-table">
				<thead>
					<tr>
						<th class="col-md-1"><@spring.message "cup.id"/></th>
						<th class="col-md-3"><@spring.message "coffee"/></th>
						<th class="col-md-2"><@spring.message "size"/></th>
						<th class="col-md-5"><@spring.message "condiments"/></th>
						<th class="col-md-1 text-center" style=""><@spring.message "total"/></th>
					</tr>
				</thead>
				<tbody id="cups-tbody">
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.panel-body -->
</div>
</div>
<!-- /.panel -->