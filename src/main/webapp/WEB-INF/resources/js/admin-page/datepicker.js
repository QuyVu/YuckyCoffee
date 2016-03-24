var table;
var startDate = 0;
var endDate = 0;
var orderList = [];

$(document).ready(function() {
    table=$('#order-table').DataTable({
        responsive: true,
        language: {
        	url: url
        },
        searching: false
    });
});

$(function() {
	$('#datetimepicker1').datetimepicker({
		locale: locale,
		useCurrent : false,
		format: 'L'
	});
	
	$('#datetimepicker2').datetimepicker({
		locale: locale,
		useCurrent : false,
		format: 'L'
	});
	
	$("#datetimepicker1").on("dp.change", function(e) {
		$('#datetimepicker2').data("DateTimePicker").minDate(e.date);
		startDate = parseInt($("#datetimepicker1").data('DateTimePicker').date().format('x'));
	});
	
	$("#datetimepicker2").on("dp.change", function(e) {
		$('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
		endDate = $("#datetimepicker2").data('DateTimePicker').date().format('LL');
		if (endDate == moment().format('LL')) {
			endDate = parseInt(moment().format('x'));
		} 
		else {
			var time = $("#datetimepicker2").data('DateTimePicker').date().add(1,'days');
			endDate = parseInt(time.format('x')-1);
		}
	});
});

$("button#search-order").click(function(){
	console.log(startDate);
	console.log(endDate);
	table.clear().draw();
	$.ajax({
		type : "POST",
		url : "order",
		timeout : 100000,
		data : {sDate: startDate, eDate: endDate},
		success : function(result) {
			for(i=0;i<result.length;i++){
				table.row.add([result[i].orderID, result[i].userName, 
				               moment(result[i].purchaseTime).format('LL'), result[i].total]).draw();
			}
		},
		error : function(data) {
			alert(data);
		}
	});
});