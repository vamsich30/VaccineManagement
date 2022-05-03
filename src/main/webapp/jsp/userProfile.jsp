<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="utf-8" />
<title>User Profile</title>
<link rel="stylesheet" type="text/css" href="/css/userstyles.css" />
</head>

<body>
	<div class="login-root">
		<div class="box-root flex-flex flex-direction--column"
			style="min-height: 100vh; flex-grow: 1;">
			<div class="loginbackground box-background--white padding-top--64">
				<div class="loginbackground-gridContainer">
					<div class="box-root flex-flex" style="grid-area: top/start/8/end;">
						<div class="box-root"
							style="background-image: linear-gradient(white 0%, rgb(247, 250, 252) 33%); flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 4/2/auto/5;">
						<div
							class="box-root box-divider--light-all-2 animationLeftRight tans3s"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 6/start/auto/2;">
						<div class="box-root box-background--blue800"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 7/start/auto/4;">
						<div class="box-root box-background--blue animationLeftRight"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 8/4/auto/6;">
						<div
							class="box-root box-background--gray100 animationLeftRight tans3s"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 2/15/auto/end;">
						<div
							class="box-root box-background--cyan200 animationRightLeft tans4s"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 3/14/auto/end;">
						<div class="box-root box-background--blue animationRightLeft"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 4/17/auto/20;">
						<div
							class="box-root box-background--gray100 animationRightLeft tans4s"
							style="flex-grow: 1;"></div>
					</div>
					<div class="box-root flex-flex" style="grid-area: 5/14/auto/17;">
						<div
							class="box-root box-divider--light-all-2 animationRightLeft tans3s"
							style="flex-grow: 1;"></div>
					</div>
				</div>
			</div>
			<div
				class="box-root padding-top--24 flex-flex flex-direction--column"
				style="flex-grow: 1; z-index: 9;">
				<div
					class="box-root padding-top--48 padding-bottom--24 flex-flex flex-justifyContent--center">
				</div>
				<div class="formbg-outer">
					<div class="formbg">
						<div class="formbg-inner padding-horizontal--48">
							<form id="stripe-login">
								<h3 style="text-align: center;">User Profile</h3>
								<br>
								<div class="field padding-bottom--24">
									<label for="username">User Name</label> <input type="text"
										value="${model.username}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<div class="grid--50-50">
										<label for="aadhar">Aadhaar Number</label>
									</div>
									<input type="text" value="${model.aadharNumber}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<label for="age">Age</label> <input type="text"
										value="${model.age}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<label for="vaccineName">Vaccine Name</label> <input
										type="text" value="${model.vaccineName}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<label for="firstDoseDate">First Dose Date</label> <input
										type="text" value="${model.firstDoseDate}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<label for="firstDoseLocation">Dose 1 Location</label> <input
										type="text" value="${model.firstDoseVaccineLocation}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<label for="secondDoseDate">Second Dose Date</label> <input
										type="text" value="${model.secondDoseDate}" readonly />
								</div>
								<div class="field padding-bottom--24">
									<label for="secondDoseLocation">Dose 2 Location</label> <input
										type="text" value="${model.secondDoseVaccineLocation}"
										readonly />
								</div>
								<div class="field"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
