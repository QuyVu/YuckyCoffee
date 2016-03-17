var curPass = "";
var newPass = "";
var repeat = "";
var lang = getCookie("lang");
setLanguage(lang);
	$("h4#modal-header").text(string.updatePassHeader);
	$("label#label-cur").text(string.curPass);
	$("label#label-new").text(string.newPass);
	$("label#label-repeat").text(string.repeatPass);
	$("button#update-pass").text(string.yesButton);
	$("button#reject").text(string.noButton);


$("a#updatePassword").click(function() {
	$("#updatepw-modal").modal();
});

$("#curPass").keyup(function() {
	curPass = $("#curPass").val();
});

$("#newPass").keyup(function() {
	newPass = $("#newPass").val();
});

$("#repeat").keyup(function() {
	repeat = $("#repeat").val();
});

function updatePassword(curP, newP) {
	$.ajax({
		type : "POST",
		url : "/YuckyCoffee/update-password",
		timeout : 100000,
		data : {
			curPass : curP,
			newPass : newP
		},
		success : function(result) {
			if (result == 0) {
				var str = "<strong>Username does not exist</strong>";
				$("div#notification").removeClass("alert-success");
				$("div#notification").addClass("alert-danger");
				$("div#notification").html(str);
			} else if (result == -1) {
				var str = "<strong>" + string.wrongCur + "</strong>";
				$("div#notification").removeClass("alert-success");
				$("div#notification").addClass("alert-danger");
				$("div#notification").html(str);
			} else {
				var str = "<strong>" + string.success + "</strong>";
				$("div#notification").removeClass("alert-danger");
				$("div#notification").addClass("alert-success");
				$("div#notification").html(str);
				setInterval(logout, 1500);
			}
		},
		error : function(result) {
			alert(result);
		}
	});
};

$("button#update-pass").click(function() {
	if (newPass != repeat) {
		var str = "<strong>" + string.wrongRepeat + "</strong>";
		$("div#notification").show();
		$("div#notification").removeClass("alert-success");
		$("div#notification").addClass("alert-danger");
		$("div#notification").html(str);
	} else if (curPass == "" || newPass == "" || repeat == "") {
		var str = "<strong>" + string.emptyField + "</strong>";
		$("div#notification").show();
		$("div#notification").removeClass("alert-success");
		$("div#notification").addClass("alert-danger");
		$("div#notification").html(str);
	} else {
		updatePassword(curPass, newPass);
	}
});

$("button#reject").click(function() {
	window.location.reload();
});

function logout() {
	$.get("/YuckyCoffee/logout", function() {
	});
	window.location.reload();
}