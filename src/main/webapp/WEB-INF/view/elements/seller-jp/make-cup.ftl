<div class="panel panel-primary">
		<table class="table">
			<thead>
				<tr>
					<th class="col-md-4"><span>コーヒー</span></th>
					<th class="col-md-4"><span>サイズ</span></th>
					<th class="col-md-4"><span>調味料</span></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="col-md-5"><#include "/WEB-INF/view/elements/seller/coffee-list.ftl"></td> <#-- list of Coffee Type -->
					<td class="col-md-2"><#include "/WEB-INF/view/elements/seller-jp/cup-size.ftl"></td> <#-- choose Size-->
					<td class="col-md-5"><#include "/WEB-INF/view/elements/seller/condiment-list.ftl"></td> <#-- list of Condiment Type -->
				</tr>
			</tbody>
		</table>
</div>