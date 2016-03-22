<#ftl encoding='UTF-8'>
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><@spring.message "user.add"/></h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-4"><@spring.message "user.name"/></th>
							<th class="col-md-4"><@spring.message "user.password"/></th>
							<th class="col-md-2 text-center"><@spring.message "user.role"/></th>
							<th class="col-md-2 text-center"><@spring.message "user.status"/></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input id="new_name" type="text" class="form-control"></td>
							<td><input id="new_password" type="password"
								class="form-control"></td>
							<td class="text-center">
								<div class="dropdown">
									<button id="btnSelectRole" style="min-width: 137px"
										class="btn btn-default dropdown-toggle" data-toggle="dropdown">
										<@spring.message "user.selectRole"/> <span class="caret">
									</button>
									<ul class="dropdown-menu">
										<li><a id="roleAdmin">ROLE_ADMIN</a></li>
										<li><a id="roleSeller">ROLE_SELLER</a></li>
									</ul>
								</div>
							</td>
							<td class="text-center" style="vertical-align: middle"><input
								id="checkStatus" type="checkbox" style="vertical-align: top"
								checked> <@spring.message "available"/></input></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button id="submitUser" class="btn btn-primary" data-dismiss="modal"><@spring.message "button.ok"/></button>
				<button class="btn btn-default" data-dismiss="modal"><@spring.message "button.close"/></button>
			</div>
		</div>
	</div>
</div>