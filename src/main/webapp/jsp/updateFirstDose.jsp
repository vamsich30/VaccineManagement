<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>First Dose</title>
</head>
<body>
	<h4>Update First Dose Details</h4>
	<hr />
	<form action="/dose/one/edit" method="POST">

		<strong> Select your vaccine name </strong>&emsp;&emsp;&emsp;&emsp; <select
			name="vaccineName" required>
			<option value="">${vaccine}</option>
			<option value="Covaxin">Covaxin</option>
			<option value="Covishield">CoviShield</option>
		</select> <br /> <strong> Select First Dose Date</strong>&emsp;&emsp;&emsp;&emsp;
		<input type="date" name="firstDoseDate" required value="${date}" /> <br>

		<strong> Select your nearest Location</strong>&emsp;&emsp;&emsp;&emsp;
		<select name="vaccineLocation" required>
			<option value="">${location}</option>
			<option value="GUNTUR">GUNTUR</option>
			<option value="KURNOOL">KURNOOL</option>
			<option value="VIJAYAWADA">VIJAYAWADA</option>
			<option value="VISAKHAPATNAM">VISAKHAPATNAM</option>
		</select> <br /> <br /> <input type="submit" value="Book Appointment">
	</form>
	<span style="color: red; font-size: 26; font-weight: bold;">${errormessage}</span>
	<span style="color: green; font-size: 26; font-weight: bold;">${msg}</span>
	<span style="color: green; font-size: 26; font-weight: bold;">${updatemsg}</span>
</body>
</html>