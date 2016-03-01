var time  = null;
var day = [];
var total = [];

var data = {
	month: 0,
    labels: ["1","2","3","4","5"],
    datasets: [
        {
        	label: "My First dataset",
        	fillColor: "rgba(0, 154, 205,0.5)",
        	strokeColor: "rgba(0, 154, 205, 1)",
        	pointColor: "rgba(0, 154, 205, 1)",
            pointStrokeColor: "#fff",
            pointHighlightFill: "#fff",
            pointHighlightStroke: "rgba(0, 154, 205, 1)",
        	data: [34,18,25,44,37]
        },
    ]
};

var options = {
	    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
	    scaleBeginAtZero : true,
	    
	    scaleLabel: "<%=value%>",

	    //Boolean - Whether grid lines are shown across the chart
	    scaleShowGridLines : true,

	    //String - Colour of the grid lines
	    scaleGridLineColor : "rgba(0,0,0,.05)",

	    //Number - Width of the grid lines
	    scaleGridLineWidth : 1,

	    //Boolean - Whether to show horizontal lines (except X axis)
	    scaleShowHorizontalLines: true,

	    //Boolean - Whether to show vertical lines (except Y axis)
	    scaleShowVerticalLines: true,
	    
	    //Boolean - Whether the line is curved between points
	    bezierCurve : false,

	    //Boolean - Whether to show a dot for each point
	    pointDot : true,

	    //Number - Radius of each point dot in pixels
	    pointDotRadius : 3,

	    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
	    pointHitDetectionRadius : 20,

	    //Boolean - Whether to show a stroke for datasets
	    datasetStroke : true,

	    //Number - Pixel width of dataset stroke
	    datasetStrokeWidth : 2,

	    //Boolean - Whether to fill the dataset with a colour
	    datasetFill : true,

	    //String - A legend template
	    legendTemplate : "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"

	};

var ctx = $("#myChart").get(0).getContext("2d");
var myLineChart = new Chart(ctx).Line(data, options);

$("button#search-order").click(function(){
	console.log(time);
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
			myLineChart = new Chart(ctx).Line(data, options);
		},
		error : function(data) {
			alert(data);
		}
	});
});