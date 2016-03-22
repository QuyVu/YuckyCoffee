<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>2048</title>

<link rel='stylesheet' href='resources/bower_components/bootstrap/dist/css/bootstrap.min.css'>
<link rel="stylesheet" href="resources/css/403-page/main.css" type="text/css">
<link rel="shortcut icon" href="favicon.ico">
<link rel="apple-touch-icon" href="resources/meta/apple-touch-icon.png">
<link rel="apple-touch-startup-image" href="resources/meta/apple-touch-startup-image-640x1096.png"
	media="(device-width: 320px) and (device-height: 568px) and (-webkit-device-pixel-ratio: 2)">
<!-- iPhone 5+ -->
<link rel="apple-touch-startup-image"
	href="resources/meta/apple-touch-startup-image-640x920.png"
	media="(device-width: 320px) and (device-height: 480px) and (-webkit-device-pixel-ratio: 2)">
<!-- iPhone, retina -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport"
	content="width=device-width, target-densitydpi=160dpi, initial-scale=1.0, maximum-scale=1, user-scalable=no, minimal-ui">
</head>
<body>
	<div class="row">
		<div class="col-md-4">
			<div class="container" style="margin-top: 100px;">
				<h1 class"title" style="vertical-align: initial;">
					<strong>403 Forbidden!!!</strong>
				</h1>
				<hr>
				<p style="font-size:25px;">
					<strong class="important">Warning:</strong> You do not have permission to access that page.
					</strong>
				</p>
				<br>
				<p style="font-size:25px;">
					You can try to login with another account, or relax with this famous game.
				</p>
			</div>
		</div>
		<div class="col-md-3">
			<div class="container" style="margin-top: 200px;">
				<p style="font-size:25px;">
					<strong class="important">How to play:</strong> Use your <strong>arrow
						keys</strong> to move the tiles. When two tiles with the same number
						touch, they <strong>merge into one!
					</strong>
				</p>
			</div>
		</div>
		<div class="col-md-5">
			<div class="container">
				<div class="heading">
					<h1 class="title">2048</h1>
					<a class="restart-button">New Game</a>
				</div>

				<div class="above-game">
					<div class="scores-container">
						<div class="score-container">0</div>
						<div class="best-container">0</div>
					</div>
				</div>

				<div class="game-container">
					<div class="game-message">
						<p></p>
						<div class="lower">
							<a class="keep-playing-button">Keep going</a> <a
								class="retry-button">Try again</a>
						</div>
					</div>

					<div class="grid-container">
						<div class="grid-row">
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
						</div>
						<div class="grid-row">
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
						</div>
						<div class="grid-row">
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
						</div>
						<div class="grid-row">
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
							<div class="grid-cell"></div>
						</div>
					</div>

					<div class="tile-container"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/shared/string.js"></script>
	<script src="resources/js/shared/change-lang.js"></script>
	<script src="resources/js/2048/bind_polyfill.js"></script>
	<script src="resources/js/2048/classlist_polyfill.js"></script>
	<script src="resources/js/2048/animframe_polyfill.js"></script>
	<script src="resources/js/2048/keyboard_input_manager.js"></script>
	<script src="resources/js/2048/html_actuator.js"></script>
	<script src="resources/js/2048/grid.js"></script>
	<script src="resources/js/2048/tile.js"></script>
	<script src="resources/js/2048/local_storage_manager.js"></script>
	<script src="resources/js/2048/game_manager.js"></script>
	<script src="resources/js/2048/application.js"></script>
</body>
</html>