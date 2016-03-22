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
                	<a id="username" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" value="${user}">${user}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                    	<li><a id="updatePassword"><@spring.message "changePass"/></a></li>
                    </ul>
                </li>
                <li><a href="/YuckyCoffee/logout"><@spring.message "logout"/></a></li>
            </ul>

            <div class="navbar-default sidebar" role="navigation">
                	<ul class="nav">
                        <li>
                            <a href="/YuckyCoffee/admin/order"><i class="fa fa-list-alt fa-fw"></i> <@spring.message "orders"/></a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/statistic"><i class="fa fa-bar-chart fa-fw"></i> <@spring.message "statistic"/></a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/user"><i class="fa fa-user fa-fw"></i> <@spring.message "users"/></a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/coffee"><i class="fa fa-coffee fa-fw"></i> <@spring.message "coffee"/></a>
                        </li>
                        <li>
                            <a href="/YuckyCoffee/admin/condiment"><i class="fa fa-cutlery fa-fw"></i> <@spring.message "condiment"/></a>
                        </li>
                            	
            <li style="padding:15px; margin-left:0px; position:fixed; bottom:0px">
  				<a class="flag">
  					<img class="jp-lang" src="/YuckyCoffee/resources/image/jp.png" alt="Submit" height="30px" width="30px"></img>
  				</a>
  				<a class="flag">
	  				<img class="us-lang" src="/YuckyCoffee/resources/image/us.png" alt="Submit" height="30px" width="30px"></img>
				</a>
  				<a class="flag">
	  				<img class="vi-lang" src="/YuckyCoffee/resources/image/vi.png" alt="Submit" height="30px" width="30px"></img>
				</a>
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
    	<style>
			.flag {
    			display:inline!important;
    			background-color:transparent!important;
    			width:60px;
    			padding:0px 0px!important;
			}
		</style> 
	</head>
	<body>
    	<div id="wrapper">
		
        	<!-- Navigation -->
			<@navbar/>
		
            <#include "/shared/update-password.ftl">
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
