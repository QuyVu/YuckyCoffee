<div class="panel panel-primary">
		<table class="table">
			<thead>
				<tr>
					<th class="col-md-4"><span><@spring.message "coffee"/></span></th>
					<th class="col-md-4"><span><@spring.message "size"/></span></th>
					<th class="col-md-4"><span><@spring.message "condiment"/></span></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col-md-5"><#include "/elements/seller/coffee-list.ftl"></td> <#-- list of Coffee Type -->
					<td class="col-md-2"><#include "/elements/seller/cup-size.ftl"></td> <#-- choose Size-->
					<td class="col-md-5"><#include "/elements/seller/condiment-list.ftl"></td> <#-- list of Condiment Type -->
				</tr>
			</tbody>
		</table>
</div>