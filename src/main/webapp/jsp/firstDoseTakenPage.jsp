<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>taken</title>

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<!-- custom css file link  -->
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<header class="header">
		<a href="#" class="logo"> <i class="fas fa-heartbeat"></i>
			medcare.
		</a>

		<nav class="navbar">
			<a href="/dashboard">home</a>
			<!-- <a href="#services">services</a> -->
			<a href="#about">about</a> <a href="#blogs">Blogs</a> <a
				href="/centers">Centers</a> &ensp;
			<div class="dropdown">
				<button onclick="myFunction()" class="dropbtn">Book</button>
				<div id="myDropdown" class="dropdown-content">
					<a href="/dose/one">Dose 1</a> <a href="/dose/two">Dose 2</a>
				</div>
			</div>
			<a href="/profile/user">Profile</a> <a href="/home">logout</a>
		</nav>

		<div id="menu-btn" class="fas fa-bars"></div>
	</header>

	<section class="book" id="book">

		<h1 class="heading">
			<span>book</span> now
		</h1>

		<div class="row">

			<div class="image">
				<img src="/images/book-img.svg" alt="">
			</div>


			<form action="/dose/one/edit" method="get">
				<h3>Appointment Details</h3>
				<select class="box" disabled>
					<option value="${name}">${name}</option>
				</select> <input type="date" class="box" value="${date}" disabled> <select
					class="box" disabled>
					<option value="${location}">${location}</option>
				</select>
				 <span style="color: green; font-size: 24px; font-weight: bold;">${msg}</span>
				<span style="color: red; font-size: 24px; font-weight: bold;">${errmsg}</span>
				<br/>
				<br/>
				<input type="submit" value="UPDATE DOSE 1" class="btn">
			</form>
		</div>

	</section>
	<script src="/js/script.js"></script>

</body>
</html>