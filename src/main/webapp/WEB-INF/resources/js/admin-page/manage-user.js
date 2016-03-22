var user = {
	userName : "",
	password : "",
	role : "",
	enabled : true
};

$(document).ready(function() {
    $('#userTable').DataTable({
            responsive: true,
            language: {
            	url: url
            }
    });
});

var action;

function autoCloseModal() {
	setTimeout(function() {
		$("#response-modal").modal('hide');
		$("div#response-body").children().remove();
		window.location.reload();
	}, 1500);
}

$("#new_name").keyup(function() {
	user.userName = $("#new_name").val();
});

$("#new_password").keyup(function() {
	user.password = $("#new_password").val();
});

$("a#roleAdmin").click(
		function() {
			user.role = $("a#roleAdmin").text();
			$("button#btnSelectRole").html(
					$("a#roleAdmin").text() + " " + '<span class="caret">');
		});

$("a#roleSeller").click(
		function() {
			user.role = $("a#roleSeller").text();
			$("button#btnSelectRole").html(
					$("a#roleSeller").text() + " " + '<span class="caret">');
		});

$("#checkStatus").click(function() {
	if (document.getElementById('checkStatus').checked) {
		user.enabled = true;
	} else {
		user.enabled = false;
	}
});

function hasWhiteSpace(s) {
	return s.indexOf(' ') >= 0;
}

function validateNewUser() {
	if (hasWhiteSpace(user.userName) || user.userName == "") {
		return false;
	} else if (hasWhiteSpace(user.password) || user.password == "") {
		return false;
	} else if (user.role == "") {
		return false;
	} else {
		return true;
	}
}

function applyNewUser() {
	$.ajax({
		type : "POST",
		url : "submit-new-user",
		contentType : "application/json",
		dataType : 'json',
		timeout : 100000,
		data : JSON.stringify(user),
		success : function(result) {
			if (result == 0) {
				var str = "<h3 id=\"response-content\">" + string.connectDB +"</h3>";
				$("div#response-body").append(str);
			} else if (result == -1) {
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

function updateUser(name, act) {

	$.ajax({
		type : "POST",
		url : "update-user",
		timeout : 100000,
		data : {
			username : name,
			action : act
		},
		success : function(result) {
			if (result == 0) {
				var str = "<h3>Username does not exist</h3>";
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

function confirmNewUser(){
	action = "addUser";
	var str = "<h3>"+ string.confirmAddUser +"</h3>"
	$("div#confirm-body").append(str);
	$("#confirm-modal").modal();
}

$("button#close-modal").click(function() {
	window.location.reload();
});

$("button#submitUser").click(function() {
	if (validateNewUser()) {
		confirmNewUser();
	} else {
		var str = "<h3>"+ string.inputError +"</h3>";
		$("div#response-body").append(str);
		$("#response-modal").modal();
		autoCloseModal();
	}
});

$("button#unlock-user").click(function() {
	action = "active"
	user.userName = $(this).val();
	var str = "<h3>"+string.confirmUnlockUser+"</h3>"
	$("div#confirm-body").append(str);
	$("#confirm-modal").modal();
});

$("button#lock-user").click(function() {
	action = "deactive"
	user.userName = $(this).val();
	var str = "<h3>"+ string.confirmLockUser +"</h3>"
	$("div#confirm-body").append(str);
	$("#confirm-modal").modal();
});

$("button#accept-action").click(function() {
	console.log(action);
	if(action=="addUser") {
		applyNewUser();
	} else
		updateUser(user.userName, action);
});

$("button#deny-action").click(function() {
	$("div#confirm-body").children().remove();
});
