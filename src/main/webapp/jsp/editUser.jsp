<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>Update Profile</h2>
	<hr />
	<br>
	<form:form action="/user-profile/edit" method="POST" modelAttribute="userModel">
		<table>
		<caption></caption>
			<tr>
				<th scope="row">Enter new User Name</th>
				<td><input type="text" name="username"
					placeholder="Enter User Name"></td>
				<td><form:errors path="username" cssClass="error"></form:errors>
			</tr>
			<tr>
				<th scope="row">Aadhar Number</th>
				<td><input type="text" name="aadharNumber" value="${aadharNumber}"
				title="Aadhar number should be 12 characters length of integers" /></td>
			</tr>
			<tr>
				<th scope="row">Enter new Password</th>
				<td><input type="password" name="password" placeholder="Enter Password"/></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>

			<tr>
				<th scope="row">Enter your new Age</th>
				<td><input type="number" name="age" placeholder="Enter age" min = "1" max = "100"
					style="width : 12em" /></td>
				<td><form:errors path="age" cssClass="error"></form:errors></td>
			</tr>
			</table>
			<br>
			<br>
			<input type="submit" value="Update" />
		
	</form:form>
	<br>
	<br>
	<strong><span style="color: red">${errormessage}</span></strong>
	<h2><strong><span style="color:green">${successmessage}</span></strong></h2>
</body>
</html>