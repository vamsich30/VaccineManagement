<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>User Profile</h4>
	<hr />
	<table border="1">
		<caption></caption>
		<tr>
			<th>User Name</th>
			<th>Password</th>

		</tr>
		<tr>
			<td>${model.adminName}</td>
			<td>${model.adminPassword}</td>
		</tr>
	</table>
</body>
</html>