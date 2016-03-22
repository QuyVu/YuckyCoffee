<#ftl encoding='UTF-8'>	
<div class="modal fade" id="updatepw-modal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="close-updatepw" type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 id="modal-header" class="modal-title"><@spring.message "changePass"/></h4>
			</div>

			<div id="response-body" class="modal-body">
				
				<div id="notification" class="alert col-md-10 col-md-offset-1">
					<!-- content -->
				</div>
				
				<!-- Password input-->
				<div class="form-group row">
					<label id="label-cur" class="col-md-4 col-md-offset-1"><@spring.message "updatePass.curPass"/></label>
					<div class="col-md-6">
						<input id="curPass" type="password" class="form-control input-md">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group row">
					<label id="label-new" class="col-md-4 col-md-offset-1"><@spring.message "updatePass.newPass"/></label>
					<div class="col-md-6">
						<input id="newPass" type="password" class="form-control input-md">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group row">
					<label id="label-repeat" class="col-md-4 col-md-offset-1"><@spring.message "updatePass.repeat"/></label>
					<div class="col-md-6">
						<input id="repeat"type="password" class="form-control input-md">
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<button id="update-pass" type="button" class="btn btn-success">
					<i class="fa fa-check"></i><@spring.message "button.ok"/>
				</button>
				<button id="reject" type="button" class="btn btn-default" data-dismiss="modal"><@spring.message "button.close"/></button>
			</div>
		</div>
	</div>
</div>