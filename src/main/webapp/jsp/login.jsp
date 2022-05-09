<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Log In</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/util.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="/images/img-01.png" alt="IMG">
				</div>

				<form:form class="login100-form validate-form" action="/user/signin"
					method="POST" modelAttribute="userModel">
					<span class="login100-form-title"> Member Login </span>

					<div class="wrap-input100 validate-input"
						data-validate="Aadhar should contain 12 digits only">
						<input class="input100" type="text" name="aadharNumber"
							placeholder="Aadhaar Number"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i> <form:errors
								path="password" cssClass="error"></form:errors>
						</span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<input class="input100" type="password" name="password"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">Login</button>
					</div>
					<br> <span
						style="color: red; font-style: italic; font-weight: bold; font-size: 14px">
						${errormessage}</span>
					<div class="text-center p-t-136">
						<a class="txt2" href="/user/signup"> Create your Account <i
							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script src="/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="/vendor/bootstrap/js/popper.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="/vendor/tilt/tilt.jquery.min.js"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="/js/main.js"></script>

</body>
</html>