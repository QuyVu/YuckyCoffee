<#ftl encoding='UTF-8'>
<div class="panel panel-primary">
	<div class="panel-heading">Users Table</div>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<div class="dataTable_wrapper">
			<table class="table table-striped table-bordered table-hover" id="userTable">
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
					<#list model["condiments"] as condiment>
					<tr>
						<td class="text-center">${condiment.condimentID}</td>
						<td id="condiment-name-${condiment.condimentID}" class="condiment-name">
							<p id="p-name-${condiment.condimentID}">${condiment.condimentName}</p>
							<input id="input-name-${condiment.condimentID}" type="text" class="form-control input-sm" style="display:none; width:100%" value="${condiment.condimentName}">
						</td>  
						<td id="condiment-price-${condiment.condimentID}" class="condiment-price">
							<p id="p-price-${condiment.condimentID}">${condiment.condimentPrice}</p>
							<input id="input-price-${condiment.condimentID}" type="text" class="form-control input-sm" style="display:none; width:100%" value="${condiment.condimentPrice}">
						</td> 
							<td>
								<p id="p-stt-${condiment.condimentID}">
									<#if condiment.enabled == true>Available
									<#else>Unavailable	
									</#if> 
								</p> 
								<select id="select-stt-${condiment.condimentID}" class="select-stt form-control" style="display: none">
									<option value="true">Available</option>
									<option value="false">Unavailable</option>
								</select>
							</td> 
						<td class="text-center">
						<button id="edit-condiment-${condiment.condimentID}" name="edit-condiment" style="width:80px" class="edit-condiment btn btn-warning btn-sm" value="${condiment.condimentID}"> 
							<i class="fa fa-pencil-square-o"></i> Edit
						</button>
						
						<button id="save-condiment-${condiment.condimentID}" style="width:80px; display:none;" class="save-condiment btn btn-success btn-sm" value="${condiment.condimentID}"> 
							<i class="fa fa-floppy-o"></i> Save
						</button>
						
						<button id="cancel-edit-${condiment.condimentID}" style="width:80px; display:none;" class="cancel-edit btn btn-danger btn-sm" value="${condiment.condimentID}" > 
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