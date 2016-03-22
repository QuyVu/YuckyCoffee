<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading"><@spring.message "coffee.title"/></div>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover"
				id="coffeeTable">
				<thead>
					<tr>
						<th class="col-md-1 text-center"><@spring.message "id"/></th>
						<th class="col-md-4"><@spring.message "coffee.name"/></th>
						<th class="col-md-2"><@spring.message "price"/></th>
						<th class="col-md-2"><@spring.message "status"/></th>
						<th class="col-md-3 text-center" style=""><@spring.message "action"/></th>
					</tr>
				</thead>
				<tbody>
					<#list model["coffees"] as coffee>
					<tr style="background-color: #${coffee.enabled?string('DCEDC8','FFECB3')}">
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
								<#if coffee.enabled> <@spring.message "available"/><#else> <@spring.message "unavailable"/></#if>
							</p> 
							<select id="select-stt-${coffee.coffeeID}" class="select-stt form-control" style="display: none">
								<option value="true"><@spring.message "available"/></option>
								<option value="false"><@spring.message "unavailable"/></option>
							</select>
						</td>
						<td class="text-center">
							<button id="edit-coffee-${coffee.coffeeID}" name="edit-coffee"
								style="width: 80px" class="edit-coffee btn btn-warning btn-sm"
								value="${coffee.coffeeID}">
								<i class="fa fa-pencil-square-o"></i> <@spring.message "button.edit"/>
							</button>

							<button id="save-coffee-${coffee.coffeeID}"
								style="width: 80px; display: none;"
								class="save-coffee btn btn-success btn-sm"
								value="${coffee.coffeeID}">
								<i class="fa fa-floppy-o"></i> <@spring.message "button.save"/>
							</button>

							<button id="cancel-edit-${coffee.coffeeID}"
								style="width: 80px; display: none;"
								class="cancel-edit btn btn-danger btn-sm"
								value="${coffee.coffeeID}">
								<i class="fa fa-times"></i> <@spring.message "button.cancel"/>
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