var order = {
	purchaseTime : 0,
	total : 0
}

var OrderWrapper = {
	purchaseTime : 0,
	total : 0,
	cupArray : []
}

var coffee = {
	id : "",
	name : "",
	price : 0,
	enabled : true
}

var hashCondiment = {};

function Condiment(id, name, price, enabled) {
	this.id = id, this.name = name, this.price = price, this.enabled = true
};

var cupArray = [];
var cArray = [];

var cup = {
	cupID : 0,
	orderID : 0,
	coffeeID : 0,
	size : "",
	condiments : "",
	price : 0
}

function Cup(cupID, orderID, coffeeID, size, condiments, price) {
	this.cupID = cupID, this.orderID = orderID, this.coffeeID = coffeeID,
			this.size = size, this.condiments = condiments, this.price = price
};

function resetCup() {
	cup.coffeeID = 0;
	cup.size = "";
	cup.condiments = "";
	cup.price = 0;
	hashCondiment = {};
	$("a#selected-coffee").text("");
	$("span#cup-size").text("");
	$("p.added-condiment").remove();
	$("td#cup-price").text("");
	$("button.btn-add-condiment").prop("disabled", false);
};

function resetOrder() {
	order.orderID = 0;
	order.userName = "";
	order.purchaseTime = 0;
	order.total = 0;
	resetCup();
	$("tr#cup-row").remove();
	$("span#total").text("Total: " + order.total + " $");
};

// select type of coffee
$("button.btn-select-coffee").click(function() {
	if ($("a#selected-coffee").text() == "") {
		selectCoffee($(this));
	} else {
		cup.price = parseFloat(cup.price) - parseFloat(coffee.price);
		selectCoffee($(this));
	}
});

function selectCoffee(e) {
	coffee.id = e.val();
	coffee.name = e.children("text:nth-child(2)").text();
	coffee.price = parseFloat(e.children("text:first-child").text());
	cup.coffeeID = coffee.id;
	cup.price = parseFloat(cup.price) + parseFloat(coffee.price);
	$("a#selected-coffee").text(coffee.name);
	$("td#cup-price").text(parseFloat(cup.price) + " $");
}

// chose normal size for the cup
$("button#btn-normal").click(function() {
	if ($("span#cup-size").text() == "Large") {
		cup.price = parseFloat(cup.price) - 1;
		cup.size = "Normal";
		$("span#cup-size").text("Normal");
		$("td#cup-price").text(parseFloat(cup.price) + " $");
	} else {
		cup.size = "Normal";
		$("span#cup-size").text("Normal");
	}
});

// chose large size for the cup
$("button#btn-large").click(function() {
	if ($("span#cup-size").text() != "Large") {
		cup.price = parseFloat(cup.price) + 1;
		cup.size = "Large";
		$("span#cup-size").text("Large");
		$("td#cup-price").text(parseFloat(cup.price) + " $");
	} else {
		cup.size = "Large";
		$("span#cup-size").text("Large");
	}
});

// Add condiment to cup
$("button.btn-add-condiment").click(
		function() {
			var condiment = new Condiment($(this).val(), $(this).children(
					"text:nth-child(2)").text(), $(this).children(
					"text:first-child").text(), true);
			hashCondiment[condiment.name] = condiment;
			cup.price = parseFloat(cup.price) + parseFloat(condiment.price);
			$("td#added-condiments").append(
					"<p id=" + $(this).val()
							+ " class='added-condiment' value='"
							+ $(this).val() + "'>" + condiment.name + "</p>");
			$("td#cup-price").text(parseFloat(cup.price) + " $");
			$(this).prop("disabled", true);
		});

// Remove added condiment
$("td#added-condiments").on(
		'click',
		'.added-condiment',
		function(event) {
			var condiment = hashCondiment[$(event.target).text()];
			cup.price = parseFloat(cup.price) - parseFloat(condiment.price);
			delete hashCondiment[condiment.name];
			$("button#btn-condiment-" + $(event.target).attr('id')).prop(
					"disabled", false);
			$(event.target).remove();
			$("td#cup-price").text(parseFloat(cup.price) + " $");
		});

var condiments;

function applyCup() {
	condiments = "";
	for (key in hashCondiment) {
		if (cup.condiments == "") {
			condiments += hashCondiment[key].name;
			cup.condiments += hashCondiment[key].id;
		} else {
			condiments += ", " + hashCondiment[key].name;
			cup.condiments += ", " + hashCondiment[key].id;
		}
	}
	var tmpCup = new Cup(cup.cupID, cup.orderID, cup.coffeeID, cup.size,
			cup.condiments, cup.price);
	order.total += parseFloat(cup.price);
	$("span#total").text("Total: " + order.total + " $");
	cupArray.push(tmpCup);
};

// display ordered cup
function appendCheckTable() {
	var str = "<tr id=\"cup-row\">" + "<td>" + coffee.name + "</td>" + "<td>"
			+ cup.size + "</td>" + "<td>" + condiments + "</td> " + "<td>"
			+ cup.price + "</td>" + "</tr>";
	$("tbody#tableCheckOrder").append(str);
	var letterCup = {coffeeName:coffee.name,size:cup.size,condiment:condiments,price:cup.price};
	cArray.push(letterCup);
}

function responseSuccess() {
	str = '<h3>Succsess!!!</h3>'+'<table class="table table-striped table-bordered"'
			+ 'id="response-cups-table">' + '<thead>' + '<tr>'
			+ '<th class="col-md-2">Coffee</th>' + '<th class="col-md-2">Size</th>'
			+ '<th class="col-md-6">Condiments</th>' + '<th class="col-md-2">Price ($)</th>'
			+ '</tr>' + '</thead>' + '<tbody id="cups-tbody">' + '</tbody>'
			+ '</table>';
	$("#response-modal #response-body").html(str);
		var table = $('#response-cups-table').DataTable({
			responsive : true,
			paging : false,
			info: false,
			searching : false
		});
	for (i = 0; i < cArray.length; i++)
		table.row.add([cArray[i].coffeeName,
						cArray[i].size,
						cArray[i].condiment,
						cArray[i].price]).draw();
	
}

function applyOrder() {
	console.log(JSON.stringify(OrderWrapper));
	OrderWrapper.purchaseTime = order.purchaseTime;
	OrderWrapper.total = order.total;
	OrderWrapper.cupArray = cupArray;
	$.ajax({
		type : "POST",
		url : "seller/submit-order",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		timeout : 100000,
		data : JSON.stringify(OrderWrapper),
		success : function(result) {
			if (result == 1) {
				responseSuccess();
				$("#response-modal").modal();	
			} 
			else if (result == 0) {
				str = '<h3>Invalid order price</h3>'
				$("div#response-body").append(str);
				$("#response-modal").modal();	
			}
			else {
				str = '<h3>This order is empty</h3>'
				$("div#response-body").append(str);
				$("#response-modal").modal();	
			}
		},
		error : function(result) {
			alert(result);
		}
	});
};

function submitOrder() {
	order.purchaseTime = new Date().getTime();
	console.log(order.purchaseTime);
	applyOrder();
	console.log(order);
	cupArray = [];
	resetOrder();
}

//Submit Cup Info to Server using AJAX
$("button#applyOrder").click(function(event) {
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	str = '<h3>Are You sure to submit this order</h3>';
	$("div#confirm-body").append(str);
	$("#confirm-modal").modal();
});

$('button#accept-action').click(function() {
	submitOrder();
});

$('button#deny-action').click(function() {
	$("div#confirm-body").children().remove();
});

//Submit Cup Info to Server using AJAX
$("button#apply-cup").click(function() {
	if (cup.coffeeID != 0 && cup.size != "") {
		applyCup();
		appendCheckTable();
		$("a#selected-coffee").text("");
		$("span#cup-size").text("");
		$("td#cup-price").text("");
		$("p.added-condiment").remove();
		$("button.btn-add-condiment").prop("disabled", false);
		resetCup();
	} else
		alert("You must chose coffee and size");
});

//Delete the cup
$("button#delete-cup").click(function() {
	resetCup();
});

$("button#rejectOrder").click(function() {
	window.location.reload();
})

$("button#close-modal").click(function() {
	window.location.reload();
})
