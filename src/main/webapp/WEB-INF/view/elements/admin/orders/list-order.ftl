<#ftl encoding='UTF-8'>
<#include "/WEB-INF/view/pages/admin.ftl">

<#macro css>
    <!-- Bootstrap Core CSS -->
    <link href="/YuckyCoffee/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/YuckyCoffee/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Chartist CSS -->
    <link href="/YuckyCoffee/resources/bower_components/chartist/dist/chartist.min.css" rel="stylesheet">

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
    <script src="/YuckyCoffee/resources/bower_components/Chart.js/Chart.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    
	<!-- DataTables JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="/YuckyCoffee/resources/bower_components/datatables/media/js/dataTables.bootstrap.min.js"></script>    
    
    <script src="/YuckyCoffee/resources/bower_components/moment/min/moment.min.js"></script>
    <script src="/YuckyCoffee/resources/bower_components/moment/min/locales.min.js"></script>
    <script src="/YuckyCoffee/resources/bower_components/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
    
    <!-- Custom JavaScript -->
    <script src="/YuckyCoffee/resources/js/admin-page/sb-admin-2.js"></script>
    <script src="/YuckyCoffee/resources/js/admin-page/datepicker.js"></script>
    <!--script src="/YuckyCoffee/resources/js/admin-page/chart-example.js"></script-->
    
</#macro>

<#macro content>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Orders</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12"> 
			<#include "/WEB-INF/view/elements/admin/orders/select-time.ftl"> 
			<#include "/WEB-INF/view/elements/admin/orders/order-datatable.ftl">
		</div>
	</div>
	<!-- /.row -->
</#macro>

<@display/>