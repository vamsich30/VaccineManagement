<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Centers</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,700"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<link rel="stylesheet" href="/css/centerstyle.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>

	<header class="header">
		<a href="/dashboard" class="logo"> <i class="fas fa-heartbeat"></i>
			medcare.
		</a>

		<nav class="navbar">
			<a href="/dashboard">home</a> <a href="#about">about</a> <a href="#blogs">Blogs</a>
			<a href="/centers">Centers</a> &ensp;
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



	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
				<br>
				<br><br>
					<h2 class="heading-section">Covaxin</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>Location</th>
								<th>Count</th>
							</tr>
						</thead>
						<tbody>
							<core:forEach items="${covaxinMap}" var="map">
								<tr class="alert" role="alert">
									<td><core:out value="${map.key}"></core:out></td>
									<td><core:out value="${map.value}"></core:out></td>
								</tr>
							</core:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">CoviShield</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>Location</th>
								<th>Count</th>
							</tr>
						</thead>
						<tbody>
							<core:forEach items="${covishieldMap}" var="map">
								<tr class="alert" role="alert">
									<td><core:out value="${map.key}"></core:out></td>
									<td><core:out value="${map.value}"></core:out></td>
								</tr>
							</core:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
