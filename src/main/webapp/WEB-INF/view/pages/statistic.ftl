<#ftl encoding='UTF-8'>
<#include "/elements/admin/admin.ftl">

<#macro css>
    <!-- Bootstrap Core CSS -->
    <link href="/YuckyCoffee/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/YuckyCoffee/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/YuckyCoffee/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    
    <!-- DataTables CSS -->
    <link href="/YuckyCoffee/resources/bower_components/datatables/media/css/dataTables.bootstrap.min.css" rel="stylesheet">
    
    <link href="/YuckyCoffee/resources/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>

    <!-- Custom CSS -->
    <link href="/YuckyCoffee/resources/css/admin-page/sb-admin-2.css" rel="stylesheet">
</#macro>

<#macro script>
    <!-- jQuery -->
    <script src="/YuckyCoffee/resources/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Chartist JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/Chart.js/Chart.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    
	<!-- DataTables JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>    
    
    <script src="/YuckyCoffee/resources/bower_components/moment/min/moment.min.js"></script>
    <script src="/YuckyCoffee/resources/bower_components/moment/min/locales.min.js"></script>
    <script src="/YuckyCoffee/resources/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
    
    <!-- Custom JavaScript -->
	<script src="/YuckyCoffee/resources/js/shared/string.js"></script>
    <script src="/YuckyCoffee/resources/js/shared/change-lang.js"></script>
    <script src="/YuckyCoffee/resources/js/admin-page/sb-admin-2.js"></script>
    <script src="/YuckyCoffee/resources/js/admin-page/my-chart.js"></script>
    
</#macro>

<#macro content>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"><@spring.message "statistic.header"/></h1>
		</div>
	</div>

	<!-- /.row -->
	<div class="row">
		<div id="chart-panel" class="panel panel-primary">
			<div class="panel-heading">
				<i class="fa fa-bar-chart"></i>　<@spring.message "statistic.title"/>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="row">
    				<h4 style="display: inline; float: left; margin-left: 15px"> <b><@spring.message "statistic.selectTime"/></b> </h4>
    				<div class='col-md-4'>
        				<div class="form-group">
            				<div id='datetimepicker1' class='input-group date'>
                				<input type='text' name="startDate" class="form-control" placeholder="Select Month"/>
                				<span class="input-group-addon">
                    				<span class="fa fa-calendar"></span>
                				</span>
            				</div>
        				</div>
    				</div>
    				<div class='col-md-2'>
    					<button id="search-order" class="btn btn-primary" style="width:100%"><@spring.message "search"/></button>
    				</div>
    			</div>
    			
				<canvas id="myChart" width="1000" height="400" style="display:none"></canvas>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.row -->
</#macro>

<@display/>