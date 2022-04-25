<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Admin Page</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>Edit Admin Profile</h2>
	<hr />
	<form:form action="/profile/admin/edit" method="POST"
		modelAttribute="adminModel">
		<table>
			<caption></caption>
			<tr>
				<th scope="row">Admin Name</th>
				<td><input type="text" name="adminName" value="${adminName}"
					disabled></td>
			</tr>
			<tr>
				<th scope="row">Enter your new password</th>
				<td><input type="password" name="adminPassword" /></td>
				<td><form:errors path="adminPassword" cssClass="error"></form:errors></td>
			</tr>
		</table>
		<input type="submit" value="Update">
	</form:form>
	<h2>${msg}</h2>
</body>
</html>