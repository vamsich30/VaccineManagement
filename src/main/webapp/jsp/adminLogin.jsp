<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title></title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
	font-size: 12px;
}
</style>
<link rel="stylesheet" type="text/css" href="/css/adminstyles.css" />
</head>
<body>
	<form action="/admin" method="post">
		<h2>
			<span class="entypo-login"><i class="fa fa-sign-in"></i></span> Login
		</h2>
		<button class="submit">
			<span class="entypo-lock"><i class="fa fa-lock"></i></span>
		</button>

		<span class="entypo-user inputUserIcon"> <i class="fa fa-user"></i>
		</span>
		<input type="text" class="user" placeholder="Admin Name"
			name="adminName" />
		<span class="entypo-key inputPassIcon"> <i class="fa fa-key"></i>
		</span>
		<input type="password" class="pass" placeholder="Admin Password"
			name="adminPassword" />

		&emsp;&emsp;&emsp;
		<span style="color: red;font-size: 16px;font-weight: bold;font-style: italic;">${errmsg}</span>

	</form>

	<h1>${msg}</h1>
	<script type="text/javascript">
		$(".user").focusin(function() {
			$(".inputUserIcon").css("color", "#e74c3c");
		}).focusout(function() {
			$(".inputUserIcon").css("color", "white");
		});

		$(".pass").focusin(function() {
			$(".inputPassIcon").css("color", "#e74c3c");
		}).focusout(function() {
			$(".inputPassIcon").css("color", "white");
		});
	</script>
</body>
</html>
