<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Covaxin Centers</h4>
	<hr />
	<table border="1">
		<caption></caption>
		<tr>
			<th>Vaccine Location</th>
			<th>Available Count</th>
		</tr>
		<core:forEach items="${covaxinMap}" var="map">
			<tr>
				<td><core:out value="${map.key}"></core:out></td>
				<td><core:out value="${map.value}"></core:out></td>
			</tr>
		</core:forEach>
	</table>

	<h4>CoviShield Centers</h4>
	<hr />
	<table border="1">
		<caption></caption>
		<tr>
			<th>Vaccine Location</th>
			<th>Available Count</th>
		</tr>
		<core:forEach items="${covishieldMap}" var="map">
			<tr>
				<td><core:out value="${map.key}"></core:out></td>
				<td><core:out value="${map.value}"></core:out></td>
			</tr>
		</core:forEach>
	</table>

</body>
</html>