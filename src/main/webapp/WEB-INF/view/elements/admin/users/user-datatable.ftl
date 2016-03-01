<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading">
		Users Table
	</div>
	<!-- /.panel-heading -->
	
	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover" id="userTable">
				<thead>
					<tr>
						<th class="col-md-3">Username</th>
						<th class="col-md-3">Role</th>
						<th class="col-md-3">Status</th>
						<th class="col-md-3 text-center" style="">Action</th>
					</tr>
				</thead>
				<tbody>
					<#list model["users"] as acc>
					<tr>
						<td>${acc.userName}</td>
						<td>${acc.role}</td> 
						<#if acc.enabled == true>
							<td>available</td> 
						<#else>
							<td>locked</td> 
						</#if>
						<td class="text-center">
						<#if acc.enabled == true>
							<button id="lock-user" style="width:80px" class="btn btn-warning btn-sm" href="#" value="${acc.userName}"> 
								<i class="fa fa-lock"></i> Deactive
							</button>
						<#else>
							<button id="unlock-user" style="width:80px" class="btn btn-success btn-sm" href="#" value="${acc.userName}"> 
								<i class="fa fa-unlock"></i> Active
							</button>
						</#if>
						</td>
					</tr>
					</#list>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.panel-body -->
</div>
<!-- /.panel -->