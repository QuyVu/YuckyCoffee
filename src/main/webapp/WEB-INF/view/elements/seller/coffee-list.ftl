<div>
	<#list model["listCoffee"] as coffee> 
		<button id="btn-coffee-${coffee.id}" class="btn-select-coffee btn btn-lg btn-primary btn-coffee" style="margin-bottom: 5px; min-width:146px" value="${coffee.id}"> 
			<text style="display:none">${coffee.price?c}</text> <text>${coffee.name}</text>
		</button> 
	</#list>
</div>