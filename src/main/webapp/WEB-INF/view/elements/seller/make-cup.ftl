<div class="panel panel-primary">
		<table class="table">
			<thead>
				<tr>
					<th class="col-md-4"><span>Coffee</span></th>
					<th class="col-md-4"><span>Size</span></th>
					<th class="col-md-4"><span>Condiments</span></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col-md-5"><#include "/WEB-INF/view/elements/seller/coffee-list.ftl"></td> <#-- list of Coffee Type -->
					<td class="col-md-2"><#include "/WEB-INF/view/elements/seller/cup-size.ftl"></td> <#-- choose Size-->
					<td class="col-md-5"><#include "/WEB-INF/view/elements/seller/condiment-list.ftl"></td> <#-- list of Condiment Type -->
				</tr>
			</tbody>
		</table>
</div>