var condiment = new Product(0,"",-1,true);

var action;

$(document).ready(function() {
    $('#condimentTable').DataTable({
            responsive: true,
            language: {
            	url: url
            }
    });
});

function autoCloseModal() {
	setTimeout(function() {
		$("#response-modal").modal('hide');
		$("div#response-body").children().remove();
		window.location.reload();
	}, 1500);
}

function validateNewCondiment() {
	if (condiment.name == "") {
		return false;
	} else if (condiment.price < 0) {
		return false;
	} else {
		return true;
	}
}

function confirmCondiment(act) {
	if (act == "addCondiment") {
		action = "addCondiment";
		var str = "<h3 id=\"response-content\">" + string.confirmAddCondiment + "</h3>";
	} else if (action = "update") {
		action = "updateCondiment";
		var str = "<h3 id=\"response-content\">" + string.confirmUpdateCondiment + "</h3>";
	}
	$("div#confirm-body").append(str);
	$("#confirm-modal").modal();
}

function applyNewCondiment() {
	console.log(condiment.name);
	$.ajax({
		type : "POST",
		url : "submit-new-condiment",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(condiment),
		success : function(result) {
			if (result == -1) {
				var str = "<h3 id=\"response-content\">" + string.connectDB +"</h3>";
				$("div#response-body").append(str);
			} else if (result == 0) {
				var str = "<h3>"+ string.existName +"</h3>";
				$("div#response-body").append(str);
			} else {
				var str = "<h3>"+ string.success +"</h3>";
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

// Edit Condiment
function updateCondiment() {
	$.ajax({
		type : "POST",
		url : "update-condiment",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(condiment),
		success : function(result) {
			if (result == 0) {
				var str = "<h3>"+ string.existName +"</h3>";
				$("div#response-body").append(str);
			} else if (result == -1) {
				var str = "<h3>" + string.connectDB +"</h3>";
				$("div#response-body").append(str);
			} else {
				var str = "<h3>"+ string.success +"</h3>";
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

function displayElement(action, id) {
	if (action == "edit") {
		$("button#save-condiment-" + id).show();
		$("button#cancel-edit-" + id).show();
		$("input#input-name-" + id).show();
		$("input#input-price-" + id).show();
		$("select#select-stt-" + id).show();
		$("p#p-name-" + id).hide();
		$("p#p-price-" + id).hide();
		$("p#p-stt-" + id).hide();
		$("button.edit-condiment").prop("disabled", true);
	} else {
		$("button#edit-condiment-" + id).show();
		$("p#p-name-" + id).show();
		$("p#p-price-" + id).show();
		$("p#p-stt-" + id).show();
		$("input#input-name-" + id).hide();
		$("input#input-price-" + id).hide();
		$("select#select-stt-" + id).hide();
		$("button.edit-condiment").prop("disabled", false);
	}
}

$('button#accept-action').click(function() {
	if (action == "addCondiment")
		applyNewCondiment();
	else
		updateCondiment();
});

$("select#select-enabled").change(function() {
	var str = "";
	$("select#select-enabled option:selected").each(function() {
		str = $(this).val();
	});
	if (str == "true") {
		condiment.enabled = true;
	} else {
		condiment.enabled = false;
	}
});

$("button#submit-condiment").click(function() {
	condiment.setName($("#new-name").val());
	condiment.setPrice(parseFloat($("#new-price").val()));
	if (validateNewCondiment()) {
		confirmCondiment("addCondiment");
	} else {
		var str = "<h3>"+ string.inputError +"</h3>";
		$("div#response-body").append(str);
		$("#response-modal").modal();
		autoCloseModal();
	}
});

$("button#close-modal").click(function() {
	window.location.reload();
});

$("button.edit-condiment").click(function() {
	$(this).hide();
	displayElement("edit", $(this).val());
});

$("button.save-condiment").click(function() {
	if ($("select#select-stt-" + $(this).val() + " option:selected").val() == "true") {
		condiment.enabled = true;
	} else {
		condiment.enabled = false;
	}
	condiment.setProduct(parseInt($(this).val()), 
			$("input#input-name-" + $(this).val()).val(), 
			$("input#input-price-" + $(this).val()).val());
	$(this).hide();
	$("button#cancel-edit-" + $(this).val()).hide();
	displayElement("save", $(this).val());
	confirmCondiment("updateCondiment");
});

$("button.cancel-edit").click(function() {
	$(this).hide();
	$("button#save-condiment-" + $(this).val()).hide();
	displayElement("cancel", $(this).val());
});