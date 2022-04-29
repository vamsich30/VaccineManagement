<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/admin/centers/edit/covaxin" style="float: right">Edit</a>
	<h4>Covaxin Centers</h4>
	<hr />
	<table border="1">
		<caption></caption>
		<tr>
			<th>Vaccine Location</th>
			<th>Available Count</th>
			<th>DELETE</th>
		</tr>
		<core:forEach items="${covaxinMap}" var="map">
			<tr>
				<td><core:out value="${map.key}"></core:out></td>
				<td><core:out value="${map.value}"></core:out></td>
				<td><a href="#">Delete</a></td>
			</tr>
		</core:forEach>
	</table>
	<br>
	<hr />

	<h4>CoviShield Centers</h4>
	<hr />
	<table border="1">
		<caption></caption>
		<tr>
			<th>Vaccine Location</th>
			<th>Available Count</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<core:forEach items="${covishieldMap}" var="map">
			<tr>
				<td><core:out value="${map.key}"></core:out></td>
				<td><core:out value="${map.value}"></core:out></td>
				<td><a href="/admin/centers/edit/covishield">Edit</a></td>
				<td><a href="#">Delete</a></td>
			</tr>
		</core:forEach>
	</table>

</body>
</html>