<#ftl encoding='UTF-8'>
<#include "/WEB-INF/view/pages/admin.ftl">

<#macro css>
	<!-- Bootstrap Core CSS -->
    <link href="/YuckyCoffee/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/YuckyCoffee/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/YuckyCoffee/resources/bower_components/datatables/media/css/dataTables.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/YuckyCoffee/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- Custom CSS -->
    <link href="/YuckyCoffee/resources/css/admin-page/sb-admin-2.css" rel="stylesheet">
</#macro>

<#macro script>
    <!-- jQuery -->
    <script src="/YuckyCoffee/resources/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/YuckyCoffee/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="/YuckyCoffee/resources/bower_components/datatables/media/js/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/YuckyCoffee/resources/js/admin-page/sb-admin-2.js"></script>
    <script src="/YuckyCoffee/resources/js/admin-page/manage-condiment.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#userTable').DataTable({
                responsive: true
        });
    });
    </script>
</#macro>

<#macro content>
			<div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">Condiment Management</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">  
					<button class="btn btn-success btn-lg" style="margin-bottom:20px" data-toggle="modal" data-target="#new-condiment-modal">
						<i class="fa fa-plus"></i>
						New Condiment
					</button>
					<#include "/WEB-INF/view/elements/admin/modal/response-modal.ftl">
					
					<#include "/WEB-INF/view/elements/admin/modal/confirm-modal.ftl">
					
					<#include "/WEB-INF/view/elements/admin/condiment/add-condiment-modal.ftl">
					
                    <#include "/WEB-INF/view/elements/admin/condiment/condiment-datatable.ftl">
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
</#macro>

<@display/>