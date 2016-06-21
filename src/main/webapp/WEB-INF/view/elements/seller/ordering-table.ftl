<div class="panel with-nav-tabs panel-primary">
	<div class="table-responsive">
		<table class="table ordering">
			<thead>
				<tr>
					<th class="coffee-name col-md-2"><span><@spring.message "coffee"/></span></th>
					<th class="col-md-2"><span><@spring.message "size"/></span></th>
					<th class="col-md-4"><span><@spring.message "condiments"/></span></th>
					<th class="col-md-2"><span><@spring.message "price"/></span></th>
					<th class="col-md-2"></th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="coffee-name"><a id="selected-coffee"></a></td>
					<td><span id="cup-size" class="normal label label-primary"></span></td>
					<td id="added-condiments"></td>
					<td id="cup-price" value="0"></td>
					<td style="width: 20%;">
						<button id="apply-cup" class="fa fa-check btn btn-primary"></button>
						<button id="delete-cup" class="fa fa-trash-o btn btn-danger"></button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>