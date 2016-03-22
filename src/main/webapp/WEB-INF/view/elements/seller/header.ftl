<#ftl encoding='UTF-8'>
<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/YuckyCoffee"><@spring.message "seller.newOrder"/></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav pull-right">
                        <li class=" dropdown">
                        	<a id="username" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" value="${user}">${user}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a id="updatePassword"><@spring.message "changePass"/></a></li>
                            </ul>
                        </li>
                        <li><a href="logout"><@spring.message "logout"/></a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<#include "/shared/update-password.ftl">
<#include "/shared/confirm-modal.ftl">
<#include "/shared/response-modal.ftl">