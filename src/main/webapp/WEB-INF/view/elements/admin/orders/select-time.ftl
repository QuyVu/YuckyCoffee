<#ftl encoding='UTF-8'>
<div class="row">
	<h4 style="display: inline; float: left; margin-left: 15px">
		<b>From </b>
	</h4>
	<div class='col-md-4'>
		<div class="form-group">
			<div id='datetimepicker1' class='input-group date'>
				<input type='text' name="startDate" class="form-control"
					placeholder="YYYY/MM/DD" /> <span class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
		</div>
	</div>
	<h4 style="display: inline; float: left">
		<b> To </b>
	</h4>
	<div class='col-md-4'>
		<div class="form-group">
			<div id='datetimepicker2' class='input-group date'>
				<input type='text' name="endDate" class="form-control"
					placeholder="YYYY/MM/DD" /> <span class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
		</div>
	</div>
	<div class='col-md-2'>
		<button id="search-order" class="btn btn-primary" style="margin-left:-15px">Search</button>
	</div>
</div>