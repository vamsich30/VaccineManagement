<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Profile</title>
<link rel="stylesheet" type="text/css" href="/css/userstyles.css">
</head>
<body>
	<div class="container">
		<h2>Admin Profile</h2>
		<div class="group">
		<p style="color: #5264AE; font-size: 14px; 
		font-weight: normal; left: 5px; top: 10px;">Admin Name</p>
			<input type="text" disabled value="${adminName}"> <span
				class="highlight"></span> <span class="bar"></span>
		</div>


		<div class="group">
		<p style="color: #5264AE; font-size: 14px; 
		font-weight: normal; left: 5px; top: 10px;">Admin Password</p>
			<input type="Password" disabled value="${adminPassword}">
			<span class="highlight"></span> <span class="bar"></span>
		</div>
	</div>
</body>
</html>