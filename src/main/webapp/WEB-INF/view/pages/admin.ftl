<#ftl encoding='UTF-8'>

<#macro css>
	<!-- custom css-->
</#macro>

<#macro content>
	<!-- custom content-->
</#macro>

<#macro script>
	<!-- custom script file-->
</#macro>

<#macro navbar>
        <nav class="navbar navbar-default  navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="/YuckyCoffee/admin">Yucky Coffee</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav pull-right">
            	<li class=" dropdown">
                	<a id="username" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" value="${user}">Signed in as ${user}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                    	<li><a id="updatePassword">Change Password</a></li>
                    </ul>
                </li>
                <li class=""><a href="/YuckyCoffee/logout">Logout</a></li>
            </ul>

            <div class="navbar-default sidebar" role="navigation">
                	<ul class="nav">
                        <li>
                            <a href="/YuckyCoffee/admin/order"><i class="fa fa-list-alt fa-fw"></i> Orders</a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/statistic"><i class="fa fa-bar-chart fa-fw"></i> Statistic</a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/user"><i class="fa fa-user fa-fw"></i> Users</a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/coffee"><i class="fa fa-coffee fa-fw"></i> Coffee</a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/condiment"><i class="fa fa-cutlery fa-fw"></i> Condiment</a>
                        </li>
                    </ul>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
            
        </nav>
</#macro>

<#macro display> 
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<title>Admin Page</title>
		<@css/>    
	</head>
	<body>
    	<div id="wrapper">
		
        	<!-- Navigation -->
			<@navbar/>
		
            <#include "/WEB-INF/view/shared/update-password.ftl">
			<!-- page-wrapper -->
        	<div id="page-wrapper">
        		<@content/>
       		</div>
        
    	</div>
		<@script/>
    	<script src="/YuckyCoffee/resources/js/shared/update-password.js"></script>
	</body>
	</html>
</#macro>
