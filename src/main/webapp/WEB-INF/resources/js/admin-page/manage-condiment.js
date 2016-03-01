var condiment = {
	condimentID : 0,
	condimentName : "",
	condimentPrice : -1,
	enabled : true
};

function setCondiment(id, name, price) {
	condiment.condimentID = id;
	condiment.condimentName = name;
	condiment.condimentPrice = parseFloat(price);
}
function autoCloseModal() {
	setTimeout(function(){ 
		$("#response-modal").modal('hide'); 
		$("div#response-body").children().remove(); 
		window.location.reload();
	}, 1500);
} 

function validateNewCondiment() {
	if (condiment.condimentName == "") {
		return false;
	} else if (condiment.condimentPrice < 0) {
		return false;
	} else {
		return true;
	}
}

function applyNewCondiment() {
	$.ajax({
		type : "POST",
		url : "submit-new-condiment",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(condiment),
		success : function(result) {
			if (result == -1) {
				var str = "<h3 id=\"response-content\">Cannot connect to database</h3>";
				$("div#response-body").append(str);
			} else if (result == 0) {
				var str = "<h3>this name already in use</h3>";
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

//Edit Condiment
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

$("select#select-enabled").change(function() {
    var str = "";
    $( "select#select-enabled option:selected" ).each(function() {
      str = $(this).val();
    });
	if (str=="true") {
		condiment.enabled = true;
	} else {
		condiment.enabled = false;
	}
});

$("button#submit-condiment").click(function() {
	condiment.condimentName = $("#new-name").val();
	condiment.condimentPrice = parseFloat($("#new-price").val());
	if (validateNewCondiment()) {
		applyNewCondiment();
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

$("button.edit-condiment").click(function() {
	$(this).hide();
	displayElement("edit",$(this).val());
});

$("button.save-condiment").click(function() {
	if($("select#select-stt-" + $(this).val() + " option:selected").val()=="true") {
		condiment.enabled = true;
	}
	else {
		condiment.enabled = false;
	}
	setCondiment(parseInt($(this).val()),$("input#input-name-" + $(this).val()).val(),$("input#input-price-" + $(this).val()).val());
	$(this).hide();
	$("button#cancel-edit-" + $(this).val()).hide();
	displayElement("save",$(this).val());
	updateCondiment();
});

$("button.cancel-edit").click(function() {
	$(this).hide();
	$("button#save-condiment-" + $(this).val()).hide();
	displayElement("cancel",$(this).val());
});