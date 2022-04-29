<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Second Dose</title>
</head>
<body>
<form action="/dose/two" method="POST">
	
	<strong>	Select your vaccine name </strong> &emsp;&emsp;&emsp;&emsp;
		<select name="vaccineName" required disabled>
			<option value="" selected>${vaccineName}</option>
		</select> 
		<br/>
		
		<strong>	Select Second Dose Date</strong> &emsp;&emsp;&emsp;&emsp;		
		 <input type="date" name="secondDoseDate" required value="${date}"/> <br>
		 
		 <strong> Select your nearest Location</strong> &emsp;&emsp;&emsp;&emsp;
		 <select name="vaccineLocation" required>
		 	<option value="${location}">${location}</option>
		 	<option value="GUNTUR"> GUNTUR</option>
		 	<option value="KURNOOL">KURNOOL</option>
		 	<option value="VIJAYAWADA">VIJAYAWADA</option>
			<option value="VISAKHAPATNAM">VISAKHAPATNAM</option>
		 </select>
		 <br>
		 <br>
		
		<input type="submit" value="Book Appointment">
	</form>
	<strong><span style="color: red;font-size: 16;font-weight: bold;">${errormessage}</span></strong>
	<strong><span style="color: red;font-size: 16;font-weight: bold;">${message}</span></strong>
</body>
</html>