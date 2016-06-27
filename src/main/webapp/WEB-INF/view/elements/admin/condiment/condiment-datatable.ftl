<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading"><@spring.message "condiment.title"/></div>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover" id="condimentTable">
				<thead>
					<tr>
						<th class="col-md-1 text-center"><@spring.message "id"/></th>
						<th class="col-md-4"><@spring.message "condiment.name"/></th>
						<th class="col-md-2"><@spring.message "price"/></th>
						<th class="col-md-2"><@spring.message "status"/></th>
						<th class="col-md-3 text-center" style=""><@spring.message "action"/></th>
					</tr>
				</thead>
				<tbody>
					<#list model["condiments"] as condiment>
					<tr style="background-color: #${condiment.enabled?string('DCEDC8','FFECB3')}">
						<td class="text-center">${condiment.id}</td>
						<td id="condiment-name-${condiment.id}" class="condiment-name">
							<p id="p-name-${condiment.id}">${condiment.name}</p>
							<input id="input-name-${condiment.id}" type="text" class="form-control input-sm" style="display:none; width:100%" value="${condiment.name}">
						</td>  
						<td id="condiment-price-${condiment.id}" class="condiment-price">
							<p id="p-price-${condiment.id}">${condiment.price}</p>
							<input id="input-price-${condiment.id}" type="text" class="form-control input-sm" style="display:none; width:100%" value="${condiment.price}">
						</td> 
							<td>
								<p id="p-stt-${condiment.id}">
									<#if condiment.enabled> <@spring.message "available"/><#else> <@spring.message "unavailable"/></#if>
								</p> 
								<select id="select-stt-${condiment.id}" class="select-stt form-control" style="display: none">
									<option value="true"><@spring.message "available"/></option>
									<option value="false"><@spring.message "unavailable"/></option>
								</select>
							</td> 
						<td class="text-center">
						<button id="edit-condiment-${condiment.id}" name="edit-condiment" style="width:80px" class="edit-condiment btn btn-warning btn-sm" value="${condiment.id}"> 
							<i class="fa fa-pencil-square-o"></i> <@spring.message "button.edit"/>
						</button>
						
						<button id="save-condiment-${condiment.id}" style="width:80px; display:none;" class="save-condiment btn btn-success btn-sm" value="${condiment.id}"> 
							<i class="fa fa-floppy-o"></i> <@spring.message "button.save"/>
						</button>
						
						<button id="cancel-edit-${condiment.id}" style="width:80px; display:none;" class="cancel-edit btn btn-danger btn-sm" value="${condiment.id}" > 
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