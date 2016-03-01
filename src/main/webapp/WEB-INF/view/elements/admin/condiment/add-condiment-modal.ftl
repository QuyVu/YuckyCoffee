<#ftl encoding='UTF-8'>
<div class="modal fade" id="new-condiment-modal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">New Condiment</h4>
			</div>
			<div class="modal-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-4">Condiment Name</th>
							<th class="col-md-4">Price</th>
							<th class="col-md-4 text-center">Status</th>
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
									<option value="true">Available</option>
									<option value="false">Unavailable</option>
								</select>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button id="submit-condiment" class="btn btn-primary" data-dismiss="modal">Submit</button>
				<button class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>