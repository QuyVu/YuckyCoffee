<span class="label label-primary" style="font-size: 20px">
	<@spring.message "seller.orderedCup"/>
</span>
<div class="panel with-nav-tabs panel-primary">
	<table class="table table-striped custab">
		<thead>
			<tr>
				<th class="col-md-3"><@spring.message "coffee"/></th>
				<th class="col-md-2"><@spring.message "size"/></th>
				<th class="col-md-5"><@spring.message "condiments"/></th>
				<th class="col-md-2"><@spring.message "price"/></th>
			</tr>
		</thead>
		<tbody id="tableCheckOrder">
		</tbody>
	</table>
</div>
<div>
	<button id="rejectOrder" class="fa fa-trash-o btn btn-danger" style="font-size: 20px; float: right; margin:5px;"></button>
	<button id="applyOrder" class="fa fa-check btn btn-primary" style="font-size: 20px; float: right; margin:5px;"></button>
	<span id="total" class="label label-primary" style="font-size: 20px; float: right; margin:5px;"><@spring.message "total"/>: 0 $</span>
</div>