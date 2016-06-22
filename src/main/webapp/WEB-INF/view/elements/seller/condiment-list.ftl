<div>
	<#list model["listCondiment"] as condiment> 
		<button id="btn-condiment-${condiment.id}" class="btn-add-condiment btn btn-lg btn-success" style="margin-bottom: 5px; min-width:127px" value="${condiment.id}">
			<text style="display:none">${condiment.price?c}</text> <text>${condiment.name}</text>
		</button> 
	</#list>
</div>