<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading">Users Table</div>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover"
				id="userTable">
				<thead>
					<tr>
						<th class="col-md-1 text-center">ID</th>
						<th class="col-md-4">Name</th>
						<th class="col-md-2">Price</th>
						<th class="col-md-2">Status</th>
						<th class="col-md-3 text-center" style="">Action</th>
					</tr>
				</thead>
				<tbody>
					<#list model["coffees"] as coffee>
					<tr>
						<td class="text-center">${coffee.coffeeID}</td>
						<td id="coffee-name-${coffee.coffeeID}" class="coffee-name">
							<p id="p-name-${coffee.coffeeID}">${coffee.coffeeName}</p> 
							<input id="input-name-${coffee.coffeeID}" type="text"
							class="form-control input-sm" style="display: none; width: 100%"
							value="${coffee.coffeeName}">
						</td>
						<td id="coffee-price-${coffee.coffeeID}" class="coffee-price">
							<p id="p-price-${coffee.coffeeID}">${coffee.coffeePrice}</p> 
							<input id="input-price-${coffee.coffeeID}" type="text" class="form-control input-sm" style="display: none; width: 100%"
							value="${coffee.coffeePrice}">
						</td>
						<td>
							<p id="p-stt-${coffee.coffeeID}">
								<#if coffee.enabled == true>Available 
								<#else>Unavailable 
								</#if>
							</p> 
							<select id="select-stt-${coffee.coffeeID}" class="select-stt form-control" style="display: none">
								<option value="true">Available</option>
								<option value="false">Unavailable</option>
							</select>
						</td>
						<td class="text-center">
							<button id="edit-coffee-${coffee.coffeeID}" name="edit-coffee"
								style="width: 80px" class="edit-coffee btn btn-warning btn-sm"
								value="${coffee.coffeeID}">
								<i class="fa fa-pencil-square-o"></i> Edit
							</button>

							<button id="save-coffee-${coffee.coffeeID}"
								style="width: 80px; display: none;"
								class="save-coffee btn btn-success btn-sm"
								value="${coffee.coffeeID}">
								<i class="fa fa-floppy-o"></i> Save
							</button>

							<button id="cancel-edit-${coffee.coffeeID}"
								style="width: 80px; display: none;"
								class="cancel-edit btn btn-danger btn-sm"
								value="${coffee.coffeeID}">
								<i class="fa fa-times"></i> Cancel
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