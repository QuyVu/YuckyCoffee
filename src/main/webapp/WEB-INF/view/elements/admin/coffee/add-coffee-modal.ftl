<#ftl encoding='UTF-8'>
<div class="modal fade" id="new-coffee-modal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><@spring.message "coffee.add"/></h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-4"><@spring.message "coffee.name"/></th>
							<th class="col-md-4"><@spring.message "price"/></th>
							<th class="col-md-4 text-center"><@spring.message "status"/></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input id="new-name" type="text" class="form-control"></td>
							<td><input id="new-price" type="number" min="0" step="0.5"
								class="form-control">
							</td>
							<td class="text-center" style="vertical-align: middle">
								<select id="select-enabled" class="form-control">
									<option value="true"><@spring.message "available"/></option>
									<option value="false"><@spring.message "unavailable"/></option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button id="submit-coffee" class="btn btn-primary" data-dismiss="modal"><@spring.message "button.ok"/></button>
				<button class="btn btn-default" data-dismiss="modal"><@spring.message "button.close"/></button>
			</div>
		</div>

	</div>
</div>