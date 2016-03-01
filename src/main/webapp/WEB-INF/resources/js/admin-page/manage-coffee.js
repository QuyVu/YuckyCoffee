var coffee = {
	coffeeID : 0,
	coffeeName : "",
	coffeePrice : -1,
	enabled : true
};

function setCoffee(id, name, price) {
	coffee.coffeeID = id;
	coffee.coffeeName = name;
	coffee.coffeePrice = parseFloat(price);
}

function autoCloseModal() {
	setTimeout(function(){ 
		$("#response-modal").modal('hide'); 
		$("div#response-body").children().remove();
		window.location.reload(); 
	}, 1500);
}

function validateNewCoffee() {
	if (coffee.coffeeName == "") {
		return false;
	} else if (coffee.coffeePrice < 0) {
		return false;
	} else {
		return true;
	}
}

function applyNewCoffee() {
	$.ajax({
		type : "POST",
		url : "submit-new-coffee",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(coffee),
		success : function(result) {
			if (result == -1) {
				var str = "<h3 id=\"response-content\">Cannot connect to database</h3>";
				$("div#response-body").append(str);
			} else if (result == 0) {
				var str = "<h3>coffee name already in use</h3>";
				$("div#response-body").append(str);
			} else {
				var str = "<h3>Success!!!</h3>";
				$("div#response-body").append(str);
			}
			$("#response-modal").modal();
			autoCloseModal();
		},
		error : function(result) {
			alert(result);
		}
	});
};

//Edit coffee
function updateCoffee() {
	$.ajax({
		type : "POST",
		url : "update-coffee",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(coffee),
		success : function(result) {
			if (result == 0) {
				var str = "<h3>Update fail! This name already exists!</h3>";
				$("div#response-body").append(str);
			} else if (result == -1) {
				var str = "<h3>Cannot connect to database</h3>";
				$("div#response-body").append(str);
			} else {
				var str = "<h3>Success!!!</h3>";
				$("div#response-body").append(str);
			}
			$("#response-modal").modal();
			autoCloseModal();
		},
		error : function(result) {
			alert(result);
		}
	});
};

function displayElement(action,id){
	if (action == "edit") {
		$("button#save-coffee-" + id).show();
		$("button#cancel-edit-" + id).show();
		$("input#input-name-" + id).show();
		$("input#input-price-" + id).show();
		$("select#select-stt-" + id).show();
		$("p#p-name-" + id).hide();
		$("p#p-price-" + id).hide();
		$("p#p-stt-" + id).hide();
		$("button.edit-coffee").prop("disabled", true);
	} else {
		$("button#edit-coffee-" + id).show();
		$("p#p-name-" + id).show();
		$("p#p-price-" + id).show();
		$("p#p-stt-" + id).show();
		$("input#input-name-" + id).hide();
		$("input#input-price-" + id).hide();
		$("select#select-stt-" + id).hide();
		$("button.edit-coffee").prop("disabled", false);
	}
}  

$("select#select-enabled").change(function() {
    var str = "";
    $( "select#select-enabled option:selected" ).each(function() {
      str = $(this).val();
    });
	if (str=="true") {
		coffee.enabled = true;
	} else {
		coffee.enabled = false;
	}
});

$("button#submit-coffee").click(function() {
	coffee.coffeeName = $("#new-name").val();
	coffee.coffeePrice = parseFloat($("#new-price").val());
	if (validateNewCoffee()) {
		applyNewCoffee();
	} else {
		var str = "<h3>Input error!!!</h3>";
		$("div#response-body").append(str);
		$("#response-modal").modal();
		autoCloseModal();
	}
});

$("button#close-modal").click(function() {
	window.location.reload();
});

$("button.edit-coffee").click(function() {
	$(this).hide();
	displayElement("edit",$(this).val());
});

$("button.save-coffee").click(function() {
	if($("select#select-stt-" + $(this).val() + " option:selected").val()=="true") coffee.enabled = true;
	else coffee.enabled = false;
	setCoffee(parseInt($(this).val()),$("input#input-name-" + $(this).val()).val(),$("input#input-price-" + $(this).val()).val());
	updateCoffee();
	displayElement("save",$(this).val());
	$(this).hide();
	$("button#cancel-edit-" + $(this).val()).hide();
});

$("button.cancel-edit").click(function() {
	displayElement("cancel",$(this).val());
	$(this).hide();
	$("button#save-coffee-" + $(this).val()).hide();
});