<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Admin</title>
<link rel="stylesheet" type="text/css" href="/css/userstyles.css">
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>

</head>
<body>
	<div class="container">
		<h2>Admin Profile</h2>
		<form:form action="/profile/admin/edit" method="POST"
			modelAttribute="adminModel">
			<div class="group">
				<p
					style="color: #5264AE; font-size: 14px; font-weight: normal; left: 5px; top: 10px;">Admin
					Name</p>
				<input type="text" value="${adminName}" disabled="disabled"
					name="adminName"> <span class="highlight"></span> <span
					class="bar"></span>
			</div>

			<div class="group">
				<input type="Password" name="adminPassword"> <span
					class="highlight"></span> <span class="bar"></span> <label>Password</label>
				<form:errors path="adminPassword" cssClass="error"></form:errors>
			</div>
			<strong><span style="color: green">${msg}</span></strong>
			<strong><span style="color: red">${errmsg}</span></strong>
			<button>UPDATE</button>
		</form:form>
	</div>
</body>
</html>