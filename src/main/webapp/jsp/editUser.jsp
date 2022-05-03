<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Profile</title>
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
		<h2>User Profile</h2>
		<form:form action="/profile/user/edit" method="POST"
			modelAttribute="userModel">

			<div class="group">
				<input type="text" required value="${username}" name="username">
				<span class="highlight"></span> <span class="bar"></span> <label>Name</label>
				<form:errors path="username" cssClass="error"></form:errors>
			</div>

			<div class="group">
				<p
					style="color: #5264AE; font-size: 14px; font-weight: normal; left: 5px; top: 10px;">Aadhar
					Number</p>
				<input type="text" value="${aadharNumber}" disabled="disabled">
				<span class="highlight"></span> <span class="bar"></span>
			</div>

			<div class="group">
				<input type="Password" name="password"> <span
					class="highlight"></span> <span class="bar"></span> <label>Password</label>
				<form:errors path="password" cssClass="error"></form:errors>
			</div>

			<div class="group">
				<input type="Number" min="1" max="100" required value="${age}"
					name="age"> <span class="highlight"></span> <span
					class="bar"></span> <label>Age</label>
				<form:errors path="age" cssClass="error"></form:errors>
			</div>
			<strong><span style="color: red">${errormessage}</span></strong>
			<button>UPDATE</button>
		</form:form>

		<h2>
			<strong><span style="color: green">${successmessage}</span></strong>
		</h2>

	</div>
</body>
</html>