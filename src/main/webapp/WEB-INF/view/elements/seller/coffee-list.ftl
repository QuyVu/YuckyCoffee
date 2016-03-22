<div>
	<#list model["listCoffee"] as coffee> 
		<button id="btn-coffee-${coffee.coffeeID}" class="btn-select-coffee btn btn-lg btn-primary btn-coffee" style="margin-bottom: 5px; min-width:146px" value="${coffee.coffeeID}"> 
			<text style="display:none">${coffee.coffeePrice?c}</text> <text>${coffee.coffeeName}</text>
		</button> 
	</#list>
</div>