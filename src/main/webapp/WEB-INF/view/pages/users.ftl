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
	<script src="/YuckyCoffee/resources/js/shared/product.js"></script>
	<script src="/YuckyCoffee/resources/js/shared/user.js"></script>
    <script src="/YuckyCoffee/resources/js/shared/change-lang.js"></script>
    <script src="/YuckyCoffee/resources/js/admin-page/sb-admin-2.js"></script>
    <script src="/YuckyCoffee/resources/js/admin-page/default-page-chart.js"></script>
    
</#macro>

<#macro content>
	<div class="row">
			<h1 class="page-header">
				This Month
				<button class="btn btn-primary btn-lg">Detail</button>
			</h1>
        <!-- /.col-lg-12 -->
	</div>
	<div class="panel panel-default" style="background-color:#F7F7F9; border-color:transparent">
  		<div class="panel-body">
    		<canvas id="myChart" width="1000" height="400"></canvas>
  		</div>
	</div>
	
</#macro>

<@display/>