<#ftl encoding='UTF-8'>	
<div class="modal fade" id="confirm-modal" role="dialog">
	<div class="modal-dialog">
	<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 id="confirm-header" class="modal-title"><@spring.message "confirm.header"/></h4>
			</div>
			
			<div id="confirm-body" class="modal-body">
        	</div>
        	
			<div class="modal-footer">
				<button id="accept-action" type="button" class="btn btn-success" data-dismiss="modal">
					<i class="fa fa-check"></i><@spring.message "button.yes"/>
				</button>
				<button id="deny-action" type="button" class="btn btn-danger" data-dismiss="modal">
					<i class="fa fa-times"></i><@spring.message "button.no"/>
				</button>
			</div>
		</div>
	</div>
</div>