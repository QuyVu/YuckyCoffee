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
					<tr style="background-color:#${acc.enabled?string('DCEDC8','FFECB3')}">
						<td>${acc.userName}</td>
						<td>${acc.role}</td> 
						<td>${acc.enabled?string('Available','Unavailable')}</td> 
						<td class="text-center">
							<button id="${acc.enabled?string('lock-user','unlock-user')}" style="width:80px" class="btn btn-default btn-sm" value="${acc.userName}">
								<i class="fa fa-lock"></i> ${acc.enabled?string('Lock','Unlock')}
							</button>
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