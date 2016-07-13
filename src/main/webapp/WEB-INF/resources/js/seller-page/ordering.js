var order = new Order(0, "", 0, 0);
var coffee = new Product(0, "", 0, true);
var hashCondiment = {};
var cup = new Cup(0, 0, "", "", 0);
var cupArray;

// select type of coffee
$("button.btn-select-coffee").click(function() {
	if ($("a#selected-coffee").text() == "") {
		selectCoffee($(this));
	} else {
		cup.subPrice(parseFloat(coffee.price));
		selectCoffee($(this));
	}
});

function selectCoffee(e) {
	coffee.setProduct(parseFloat(e.val()), e.children("text:nth-child(2)").text(), 
			parseFloat(e.children("text:first-child").text()));
	cup.setCoffee(coffee);
	cup.addPrice(parseFloat(coffee.price));
	$("a#selected-coffee").text(coffee.name);
	$("td#cup-price").text(cup.price + " $");
}

// chose normal size for the cup
$("button#btn-normal").click(function() {
	if (!$("span#cup-size").hasClass("normal")) {
		$("span#cup-size").removeClass("large");
		$("span#cup-size").addClass("normal");
		cup.addPrice(-1);
		cup.setSize("Normal");
	} else {
		cup.setSize("Normal");
	}
	$("span#cup-size").text(string.normalSize);
	$("td#cup-price").text(cup.price + " $");
});

// chose large size for the cup
$("button#btn-large").click(function() {
	if (!$("span#cup-size").hasClass("large")) {
		$("span#cup-size").removeClass("normal");
		$("span#cup-size").addClass("large")
		cup.addPrice(1);
		cup.setSize("Large");
	} else {
		cup.setSize("Large");
	}
	$("span#cup-size").text(string.largeSize);
	$("td#cup-price").text(cup.price + " $");
});

// Add condiment to cup
$("button.btn-add-condiment").click(
		function() {
			var condiment = new Product(parseFloat($(this).val()), $(this)
					.children("text:nth-child(2)").text(), parseFloat($(this)
					.children("text:first-child").text()), true);
			hashCondiment[condiment.name] = condiment;
			cup.addPrice(condiment.price);
			$("td#added-condiments").append(
					"<p id=" + $(this).val()
							+ " class='added-condiment' value='"
							+ $(this).val() + "'>" + condiment.name + "</p>");
			$("td#cup-price").text(cup.price + " $");
			$(this).prop("disabled", true);
		});

// Remove added condiment
$("td#added-condiments").on(
		'click',
		'.added-condiment',
		function(event) {
			var condiment = hashCondiment[$(event.target).text()];
			cup.subPrice(condiment.price);
			delete hashCondiment[condiment.name];
			$("button#btn-condiment-" + $(event.target).attr('id')).prop(
					"disabled", false);
			$(event.target).remove();
			$("td#cup-price").text(parseFloat(cup.price) + " $");
		});

// Submit Cup Info to Server using AJAX
$("button#apply-cup").click(function() {
	if (cup.coffee != "" && cup.size != "") {
		applyCup();
		appendCheckTable();
		resetCup();
	} else
		alert("You must chose coffee and size");
});

// Delete the cup
$("button#delete-cup").click(function() {
	resetCup();
});

var condiments;

function applyCup() {
	condiments = "";
	for (key in hashCondiment) {
		if (condiments == "") {
			condiments += hashCondiment[key].name;
		} else {
			condiments += ", " + hashCondiment[key].name;
		}
	}
	cup.setCondiments(hashCondiment);
	order.addTotal(cup.price);
	$("span#total").text("Total: " + order.total + " $");
	order.addCup(cup);
};

// display ordered cup
function appendCheckTable() {
	var str = "<tr id=\"cup-row\">" + "<td>" + cup.coffee.name + "</td>"
			+ "<td>" + cup.size + "</td>" + "<td>" + condiments + "</td> "
			+ "<td>" + cup.price + "</td>" + "</tr>";
	$("tbody#tableCheckOrder").append(str);
}

function resetCup() {
	cup = new Cup(0, 0, "", "", 0);
	coffee = new Product(0, "", 0, true);
	hashCondiment = {};
	$("a#selected-coffee").text("");
	$("span#cup-size").text("");
	$("p.added-condiment").remove();
	$("td#cup-price").text("");
	$("button.btn-add-condiment").prop("disabled", false);
	$("span#cup-size").removeClass("large");
	$("span#cup-size").addClass("normal");
};

// Submit Cup Info to Server using AJAX
$("button#applyOrder").click(function(event) {
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	str = '<h3>' + string.confirmBody + '</h3>';
	$("div#confirm-body").append(str);
	$("#confirm-modal").modal();
});

$('button#accept-action').click(function() {
	ajaxPostOrder();
	console.log(order);
	resetOrder();
});

$('button#deny-action').click(function() {
	$("div#confirm-body").children().remove();
});

$("button#rejectOrder").click(function() {
	window.location.reload();
})

function ajaxPostOrder() {
	order.setTime(new Date().getTime());
	$.ajax({
		type : "POST",
		url : "seller/submit-order",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		timeout : 100000,
		data : JSON.stringify(order),
		success : function(result) {
			if (result == -1) {
				str = '<h3>' + string.emptyOrder + '</h3>'
				$("div#response-body").append(str);
				$("#response-modal").modal();
			} else if (result == 0) {
				str = '<h3>' + string.invalidPrice + '</h3>'
				$("div#response-body").append(str);
				$("#response-modal").modal();
			} else {
				responseSuccess();
				$("#response-modal").modal();
			}
		},
		error : function(result) {
			alert(order);
		}
	});
	cupArray = order.cups;
};
function responseSuccess() {
	str = '<h3>' + string.success + '</h3>'
			+ '<table class="table table-striped table-bordered"'
			+ 'id="response-cups-table">' + '<thead>' + '<tr>'
			+ '<th class="col-md-2">' + string.coffee + '</th>'
			+ '<th class="col-md-2">' + string.size + '</th>'
			+ '<th class="col-md-6">' + string.condiments + '</th>'
			+ '<th class="col-md-2">' + string.price + ' ($)</th>' + '</tr>'
			+ '</thead>' + '<tbody id="cups-tbody">' + '</tbody>' + '</table>';
	$("#response-modal #response-body").html(str);

	var table = $('#response-cups-table').DataTable({
		responsive : true,
		paging : false,
		info : false,
		language : {
			url : url
		},
		searching : false
	});
	for (i = 0; i < cupArray.length; i++) {
		value = cupArray[i];
		table.row.add(
				[ value.coffee.name, value.size, value.getCondimentsName,
						value.price ]).draw();
	}
}

function resetOrder() {
	order = new Order(0, "", 0, 0);
	resetCup();
	$("tr#cup-row").remove();
	$("span#total").text("Total: " + order.total + " $");
};

$("button#close-modal").click(function() {
	window.location.reload();
})
