<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<h4>User Profile</h4>
	<hr />
	<table border="1">
	<caption></caption>
		<tr>
			<th>User Name</th>
			<th>Aadhar Number</th>
			<th>Age</th>
			<th>Vaccine Name</th>
			<th>First Dose Date</th>
			<th>First Dose Location</th>
			<th>Second Dose Date</th>
			<th>Second Dose Location</th>

		</tr>
		<tr>
			<td>${model.username}</td>
			<td>${model.aadharNumber}</td>
			<td>${model.age}</td>
			<td>${model.vaccineName}</td>
			<td>${model.firstDoseDate}</td>
			<td>${model.firstDoseVaccineLocation}</td>
			<td>${model.secondDoseDate}</td>
			<td>${model.secondDoseVaccineLocation}</td>
		</tr>
	</table>
</body>
</html>