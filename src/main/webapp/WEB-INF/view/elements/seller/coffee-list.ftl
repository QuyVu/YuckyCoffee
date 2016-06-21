<div>
	<#list model["listCoffee"] as coffee> 
		<button id="btn-coffee-${coffee.productID}" class="btn-select-coffee btn btn-lg btn-primary btn-coffee" style="margin-bottom: 5px; min-width:146px" value="${coffee.productID}"> 
			<text style="display:none">${coffee.productPrice?c}</text> <text>${coffee.productName}</text>
		</button> 
	</#list>
</div>