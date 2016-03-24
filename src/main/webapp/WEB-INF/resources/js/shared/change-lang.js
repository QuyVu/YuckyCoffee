$(document).ready(function() {
	$(".jp-lang").mouseover(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/jp_hover.png");
	});
	$(".jp-lang").mouseout(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/jp.png");
	});
	$(".jp-lang").mousedown(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/jp_click.png");
	});
	$(".jp-lang").mouseup(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/jp_hover.png");
	});
	$(".us-lang").mouseover(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/us_hover.png");
	});
	$(".us-lang").mouseout(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/us.png");
	});
	$(".us-lang").mousedown(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/us_click.png");
	});
	$(".us-lang").mouseup(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/us_hover.png");
	});
	$(".vi-lang").mouseover(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/vi_hover.png");
	});
	$(".vi-lang").mouseout(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/vi.png");
	});
	$(".vi-lang").mousedown(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/vi_click.png");
	});
	$(".vi-lang").mouseup(function() {
		$(this).attr("src", "/YuckyCoffee/resources/image/vi_hover.png");
	});
});
$("img.vi-lang").click(function(event) {
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	setCookie("lang","vi");
	window.location.reload();
});
$("img.us-lang").click(function(event) {
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	setCookie("lang","en");
	window.location.reload();
});
$("img.jp-lang").click(function(event) {
	// Prevent the form from submitting via the browser.
	event.preventDefault();
	setCookie("lang","jp");
	window.location.reload();
});

function setCookie(cname,cvalue) {
    var d = new Date();
    referer = "path=/YuckyCoffee";
    document.cookie = cname+"="+cvalue + "; " + referer;
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

var lang = getCookie("lang");
var url = "";
var locale = "en";

setLanguage(lang);

if(lang=='jp') {
	locale = 'ja';
    url = "/YuckyCoffee/resources/json/Japanese.json";
} else if (lang=='vi'){
	locale = 'vi';
	url = "/YuckyCoffee/resources/json/Vietnamese.json";
} else {
	locale = lang;
	url = "/YuckyCoffee/resources/json/English.json";
}