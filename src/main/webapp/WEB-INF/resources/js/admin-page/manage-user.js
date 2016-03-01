var user = {
	userName : "",
	password : "",
	role : "",
	enabled : true
};
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
				var str = "<h3 id=\"response-content\">Cannot connect to database</h3>";
				$("div#response-body").append(str);
			} else if (result == -1) {
				var str = "<h3>username already in use</h3>";
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

function updateUser(name, action) {

	$.ajax({
		type : "POST",
		url : "update-user",
		timeout : 100000,
		data : {
			username : name,
			action : action
		},
		success : function(result) {
			if (result == 0) {
				var str = "<h3>Username does not exist</h3>";
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

$("button#close-modal").click(function() {
	window.location.reload();
});

$("button#submitUser").click(function() {
	if (validateNewUser()) {
		applyNewUser();
	} else {
		var str = "<h3>Input error!!!</h3>";
		$("div#response-body").append(str);
		$("#response-modal").modal();
		autoCloseModal();
	}
});

$("button#unlock-user").click(
		function() {
			$("button#accept-action").val("active");
			user.userName = $(this).val();
			$("#confirm-modal").modal();
			var str = "<h3>Are you sure you want to active user "
					+ user.userName + " ?</h3>"
			$("div#confirm-body").append(str);
		});

$("button#lock-user").click(
		function() {
			$("button#accept-action").val("deactive");
			user.userName = $(this).val();
			$("#confirm-modal").modal();
			var str = "<h3>Are you sure you want to deactive user "
					+ user.userName + " ?</h3>"
			$("div#confirm-body").append(str);
		});

$("button#accept-action").click(function() {
	console.log($(this).val());
	if ($(this).val() == "active") {
		updateUser(user.userName, "active")
	} else {
		updateUser(user.userName, "deactive")
	}
});

$("button#deny-action").click(function() {
	$("div#confirm-body").children().remove();
});
