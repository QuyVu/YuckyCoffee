var time  = parseInt(moment().format('x'));
var day = [];
var total = [];

var data = {
	month: 0,
    labels: [],
    datasets: [
        {
        	label: "My First dataset",
        	fillColor: "rgba(0, 154, 205,0.5)",
        	strokeColor: "rgba(0, 154, 205, 0.8)",
        	highlightFill: "rgba(0, 154, 205, 0.75)",
        	highlightStroke: "rgba(0, 154, 205, 1)",
        	data: []
        },
    ]
};

var options = {
	    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
	    scaleBeginAtZero : true,

	    //Boolean - Whether grid lines are shown across the chart
	    scaleShowGridLines : true,
	    
	    scaleLabel: "<%=value%>",

	    //String - Colour of the grid lines
	    scaleGridLineColor : "rgba(0,0,0,.05)",

	    //Number - Width of the grid lines
	    scaleGridLineWidth : 1,

	    //Boolean - Whether to show horizontal lines (except X axis)
	    scaleShowHorizontalLines: true,

	    //Boolean - Whether to show vertical lines (except Y axis)
	    scaleShowVerticalLines: true,
	    
	    tooltipTemplate: "<%= value %> $",

	    //Boolean - If there is a stroke on each bar
	    barShowStroke : true,

	    //Number - Pixel width of the bar stroke
	    barStrokeWidth : 1,

	    //String - A legend template
	    legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"

	};

var ctx = $("#myChart").get(0).getContext("2d");
var myBarChart = new Chart(ctx).Bar(data, options);

$(function() {
	$('#datetimepicker1').datetimepicker({
		defaultDate: moment(),
		locale: 'ja',
		useCurrent : false,
        viewMode: 'years',
        format: 'MM/YYYY'
	});
	
	$('#datetimepicker1').data("DateTimePicker").maxDate(moment());
	
	$("#datetimepicker1").on("dp.change", function(e) {
		time = parseInt($("#datetimepicker1").data('DateTimePicker').date().format('x'));
	});

});

$("button#search-order").click(function(){
	day.splice(0,day.length);
	total.splice(0,total.length);
	$.ajax({
		type : "POST",
		url : "order-by-month",
		timeout : 100000,
		data : {time: time},
		success : function(result) {
			console.log(JSON.stringify(result));
			for(i=0;i<result.length;i++){
				day.push(result[i].day);
				total.push(result[i].sum);
			}
			data.labels = day;
			data.datasets[0].data = total;
			myBarChart = new Chart(ctx).Bar(data, options);
		},
		error : function(data) {
			alert(data);
		}
	});
});