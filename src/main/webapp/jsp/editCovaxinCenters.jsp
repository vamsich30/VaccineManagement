<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit covaxin Centers</title>
</head>
<body>
	<h4>Edit Covaxin Centers</h4>
	<hr />
	<form:form action="/admin/centers/edit/covaxin" method="post" modelAttribute="covaxinDto">
		Selected Location &emsp;&emsp;&emsp; 
		<select name="location" required="required">
			<option value=""></option>
			<option value="GUNTUR">GUNTUR</option>
			<option value="KURNOOL">KURNOOL</option>
			<option value="VIJAYAWADA">VIJAYAWADA</option>
			<option value="VISAKHAPATNAM">VISAKHAPATNAM</option>
		</select>
		<br>
		<br> Update Vaccine Count &emsp;&emsp; 
		 <input type="number" name="vaccineCount" value="${count}" required>
		<br>
		<br>
		<input type="button" value="Update">
	</form:form>
	<span style="color: green; font-size: 26; font-weight: bold;">${msg}</span>

</body>
</html>