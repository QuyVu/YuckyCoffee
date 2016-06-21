<div>
	<#list model["listCondiment"] as condiment> 
		<button id="btn-condiment-${condiment.productID}" class="btn-add-condiment btn btn-lg btn-success" style="margin-bottom: 5px; min-width:127px" value="${condiment.productID}">
			<text style="display:none">${condiment.productPrice?c}</text> <text>${condiment.productName}</text>
		</button> 
	</#list>
</div>