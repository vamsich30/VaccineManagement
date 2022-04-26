<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Vaccine Details</h4>
	<hr />
	<br>
	<br>
	<strong>Vaccine Selected</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<input type="text" disabled value="${name}">
	<br />

	<strong>Date Of Vaccination</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<input type="date" disabled value="${date}" />
	<br>
	<strong> Vaccine Booked at Location</strong>&emsp;&emsp;&emsp;&emsp;
	<input type="text" disabled="disabled" value="${location}">

	<span style="color: green; font-size: 26; font-weight: bold;">${msg}</span>
</body>
</html>