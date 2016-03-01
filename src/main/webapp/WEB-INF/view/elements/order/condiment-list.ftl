<div>
	<#list model["listCondiment"] as condiment> 
		<button id="btn-condiment-${condiment.condimentID}" class="btn-add-condiment btn btn-lg btn-success" style="margin-bottom: 5px; min-width:127px" value="${condiment.condimentID}">
			<text style="display:none">${condiment.condimentPrice}</text> <text>${condiment.condimentName}</text>
		</button> 
	</#list>
</div>