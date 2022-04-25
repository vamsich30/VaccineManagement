<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
	font-size: 12px;
}
</style>
</head>
<body>
	<form:form action="/admin/login" method="post"
		modelAttribute="adminDto">
		Admin Name <input type="text" placeholder="Enter your admin name"
			name="adminName">
		&nbsp;
		<form:errors path="adminName" cssClass="error"></form:errors>
		<br>
		<br> 
		Password <input type="password" placeholder="Enter your password"
			name="adminPassword">
		<form:errors path="adminPassword" cssClass="error"></form:errors>

		<br>
		<br>

		<input type="submit" value="Login">
	</form:form>
	<h1>${msg}</h1>
</body>
</html>