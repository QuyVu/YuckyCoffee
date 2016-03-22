var cupTable;
$(document).ready(function() {
	cupTable=$('#cup-table').DataTable({
		responsive : true,
        language: {
        	url: url
        },
		searching : false
	});
});

$('#order-tbody').on( 'click', 'tr', function () {
    if ( $(this).hasClass('selected') ) {
        $(this).removeClass('selected');
		cupTable.clear().draw();
    }
    else {
        table.$('tr.selected').removeClass('selected');
        $(this).addClass('selected');
        listCup(parseInt($(this).children(":first-child").text()));
    }
} );

function listCup(orderID) {
	$('div#tb-heading').html('<i class="fa fa-list fa-fw"></i> Cups of order #' + orderID);
	$.ajax({
		type : "POST",
		url : "list-cup-by-order",
		timeout : 100000,
		data : {id: orderID},
		success : function(result) {
			cupTable.clear().draw();
			for(i=0;i<result.length;i++){
				cupTable.row.add([result[i].cupID, result[i].coffeeName, result[i].size, result[i].condiments, result[i].price]).draw();
			}
		},
		error : function(data) {
			alert(data);
		}
	});
}
