<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title><@tiles.insertAttribute name="title" /></title>
<link rel='stylesheet' href='resources/bower_components/font-awesome/css/font-awesome.min.css'>
<link rel='stylesheet' href='resources/bower_components/bootstrap/dist/css/bootstrap.min.css'>
<link rel='stylesheet' href='resources/bower_components/datatables/media/css/dataTables.bootstrap.min.css'>
<link rel='stylesheet' href='resources/css/shared/custom.css'>
<link rel='stylesheet' href='resources/css/shared/tab.css'>
<link rel='stylesheet' href='resources/css/seller-page/ordering.css'>
</head>
<body>
	<@tiles.insertAttribute name="header" />
	<div class="main">
		<div id="body" class="row">
   			<@tiles.insertAttribute name="body" />
   		</div>
	</div>
	<@tiles.insertAttribute name="footer" />
</body>
<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>    
<script src="resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="resources/bower_components/datatables/media/js/dataTables.bootstrap.min.js"></script>
<script src="resources/js/seller-page/change-lang.js"></script>
<script src="resources/js/shared/string.js"></script>
<script src="resources/js/seller-page/ordering.js"></script>
<script src="resources/js/shared/update-password.js"></script>
</html>