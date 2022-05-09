<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8" />
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
	font-size: 12px;
}
</style>
<link rel="stylesheet" href="/css/regstyles.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
	<div class="container">
		<div class="title">Registration</div>
		<div class="content">
			<form:form action="/user/signup" method="POST"
				modelAttribute="userModel">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Full Name</span> <input type="text"
							name="username" placeholder="Enter your name" value="${username}"
							data-validate="enter user name" />
						<form:errors path="username" cssClass="error"></form:errors>
					</div>
					<div class="input-box">
						<span class="details">Aadhar Number</span> <input type="text"
							name="aadharNumber" placeholder="Enter your aadhar"
							value="${aadharNumber}" />
						<form:errors path="aadharNumber" cssClass="error"></form:errors>
						<span
							style="color: red; font-style: italic; font-weight: bold; font-size: 12px;">${errormessage}</span>
					</div>
					<div class="input-box">
						<span class="details">Age</span> <input type="number" min="1"
							max="100" name="age" placeholder="Enter your age" value="${age}" />
						<form:errors path="age" cssClass="error"></form:errors>
					</div>

					<div class="input-box">
						<span class="details">Password</span> <input type="password"
							name="password" placeholder="Enter your password"
							value="${password}" />
						<form:errors path="password" cssClass="error"></form:errors>
					</div>

					<div class="input-box">
						<span class="details">Mobile Number</span> <input type="text"
							name="mobileNumber" placeholder="Enter your mobile Number"
							value="${mobileNumber}" />
						<form:errors path="mobileNumber" cssClass="error"></form:errors>
						<span
							style="color: red; font-style: italic; font-weight: bold; font-size: 12px;">${phnmsg}</span>
					</div>
				</div>
				<p style="text-align: center; font-size: 12px;">
					<span style="color: red; font-style: italic; font-weight: bold;">${message}</span>
				</p>

				<div class="button">
					<input type="submit" value="Register" /> <br> <br>
					<p style="text-align: center">
						Already have an account <a href="/user/signin">Login</a>
					</p>
				</div>
			</form:form>

		</div>
	</div>
</body>
</html>
