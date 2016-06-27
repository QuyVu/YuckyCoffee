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
						<td class="text-center">${coffee.id}</td>
						<td id="coffee-name-${coffee.id}" class="coffee-name">
							<p id="p-name-${coffee.id}">${coffee.name}</p> 
							<input id="input-name-${coffee.id}" type="text"
							class="form-control input-sm" style="display: none; width: 100%"
							value="${coffee.name}">
						</td>
						<td id="coffee-price-${coffee.id}" class="coffee-price">
							<p id="p-price-${coffee.id}">${coffee.price}</p> 
							<input id="input-price-${coffee.id}" type="text" class="form-control input-sm" style="display: none; width: 100%"
							value="${coffee.price}">
						</td>
						<td>
							<p id="p-stt-${coffee.id}">
								<#if coffee.enabled> <@spring.message "available"/><#else> <@spring.message "unavailable"/></#if>
							</p> 
							<select id="select-stt-${coffee.id}" class="select-stt form-control" style="display: none">
								<option value="true"><@spring.message "available"/></option>
								<option value="false"><@spring.message "unavailable"/></option>
							</select>
						</td>
						<td class="text-center">
							<button id="edit-coffee-${coffee.id}" name="edit-coffee"
								style="width: 80px" class="edit-coffee btn btn-warning btn-sm"
								value="${coffee.id}">
								<i class="fa fa-pencil-square-o"></i> <@spring.message "button.edit"/>
							</button>

							<button id="save-coffee-${coffee.id}"
								style="width: 80px; display: none;"
								class="save-coffee btn btn-success btn-sm"
								value="${coffee.id}">
								<i class="fa fa-floppy-o"></i> <@spring.message "button.save"/>
							</button>

							<button id="cancel-edit-${coffee.id}"
								style="width: 80px; display: none;"
								class="cancel-edit btn btn-danger btn-sm"
								value="${coffee.id}">
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