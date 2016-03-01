<#ftl encoding='UTF-8'>
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New User</h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-4">Username</th>
							<th class="col-md-4">Password</th>
							<th class="col-md-2 text-center">Role</th>
							<th class="col-md-2 text-center">Status</th>
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
										Select Role <span class="caret">
									</button>
									<ul class="dropdown-menu">
										<li><a id="roleAdmin">ROLE_ADMIN</a></li>
										<li><a id="roleSeller">ROLE_SELLER</a></li>
									</ul>
								</div>
							</td>
							<td class="text-center" style="vertical-align: middle"><input
								id="checkStatus" type="checkbox" style="vertical-align: top"
								checked> Available</input></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button id="submitUser" class="btn btn-primary" data-dismiss="modal">Submit</button>
				<button class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>