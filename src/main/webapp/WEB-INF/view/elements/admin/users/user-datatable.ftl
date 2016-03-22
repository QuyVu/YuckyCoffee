<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading">
		<@spring.message "user.title"/>
	</div>
	<!-- /.panel-heading -->
	
	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover" id="userTable">
				<thead>
					<tr>
						<th class="col-md-3"><@spring.message "user.name"/></th>
						<th class="col-md-3"><@spring.message "user.role"/></th>
						<th class="col-md-3"><@spring.message "status"/></th>
						<th class="col-md-3 text-center" style=""><@spring.message "action"/></th>
					</tr>
				</thead>
				<tbody>
					<#list model["users"] as acc>
					<tr style="background-color:#${acc.enabled?string('DCEDC8','FFECB3')}">
						<td>${acc.userName}</td>
						<td>${acc.role}</td> 
						<td><#if acc.enabled> <@spring.message "available"/><#else> <@spring.message "unavailable"/></#if></td> 
						<td class="text-center">
							<button id="${acc.enabled?string('lock-user','unlock-user')}" style="width:80px" class="btn btn-default btn-sm" value="${acc.userName}">
								<i class="fa fa-lock"></i><#if acc.enabled> <@spring.message "user.lock"/><#else> <@spring.message "user.unlock"/></#if>
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