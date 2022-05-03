<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>first dose page</title>
<link rel="stylesheet" type="text/css" href="/css/dosestyles.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />

<link href="https://fonts.googleapis.com/css?family=Poppins:600"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
</head>
<body>

	<header class="header">
		<a href="#" class="logo"> <i class="fas fa-heartbeat"></i>
			medcare.
		</a>

		<nav class="navbar">
			<a href="#">home</a>
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



	<form action="/dose/one/edit" method="POST">
		<!--[if gte IE 9]><label for="favcity" class="ie9"><![endif]-->
		<!--[if !IE]><!-->
		<strong style="font-size: 16px; font-family: monospace;">Choose
			your Vaccine</strong> <label for="favcity"> <!--<![endif]--> <select
			name="vaccineName" required>
				<option value="${vaccine}">${vaccine}</option>
				<option value="Covaxin">Covaxin</option>
				<option value="Covishield">CoviShield</option>
		</select>

		</label> <br /> <strong style="font-size: 16px; font-family: monospace;">
			Select First Dose Date</strong>&emsp;&emsp;&emsp;&emsp;

		<div class="container-fluid px-0 px-sm-4 mx-auto">
			<div class="row justify-content-center mx-0">
				<div class="col-lg-10">
					<div class="card border-0">
						<div class="card-header bg-dark">
							<div
								class="mx-0 mb-0 row justify-content-sm-center justify-content-start px-1">
								<input type="text" id="dp1" class="datepicker"
									placeholder="Pick Date" name="firstDoseDate" readonly
									required="required" value="${date}" /><span
									class="fa fa-calendar"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br /> <strong style="font-size: 16px; font-family: monospace;">Choose
			your Vaccine Location</strong> <label for="favcity"> <select
			name="vaccineLocation" required>
				<option value="${location}">${location}</option>
				<option value="GUNTUR">GUNTUR</option>
				<option value="KURNOOL">KURNOOL</option>
				<option value="VIJAYAWADA">VIJAYAWADA</option>
				<option value="VISAKHAPATNAM">VISAKHAPATNAM</option>
		</select>
		</label>
		<button>&emsp;&ensp;&emsp;&ensp; Update&emsp;&emsp;</button>
	</form>
	<span style="color: red; font-size: 26; font-weight: bold;">${errormessage}</span>
	<span style="color: green; font-size: 26; font-weight: bold;">${msg}</span>
	<span style="color: green; font-size: 26; font-weight: bold;">${updatemsg}</span>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".datepicker").datepicker({
				format : "dd-mm-yyyy",
				autoclose : true,
				startDate : "0d",
			});

			$(".cell").click(function() {
				$(".cell").removeClass("select");
				$(this).addClass("select");
			});
		});
	</script>
</body>
</html>
