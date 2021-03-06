<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Admin DashBoard</title>
<!-- plugins:css -->
<link rel="stylesheet" href="/vendors/feather/feather.css" />
<link rel="stylesheet" href="/vendors/ti-icons/css/themify-icons.css" />
<link rel="stylesheet" href="/vendors/css/vendor.bundle.base.css" />
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet"
	href="/vendors/datatables.net-bs4/dataTables.bootstrap4.css" />
<link rel="stylesheet" href="/vendors/ti-icons/css/themify-icons.css" />
<link rel="stylesheet" type="text/css"
	href="/js/select.dataTables.min.css" />
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="/css/vertical-layout-light/style.css" />
<!-- endinject -->
<link rel="shortcut icon" href="/images/favicon.png" />
</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo mr-5" href="/admin/admin-dashboard"><img
					src="/images/logo.png" class="mr-2" alt="logo" /></a> <a
					class="navbar-brand brand-logo-mini" href="/admin/admin-dashboard"><img
					src="images/logo-mini.svg" alt="logo" /></a>
			</div>
			<div
				class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
				<button class="navbar-toggler navbar-toggler align-self-center"
					type="button" data-toggle="minimize">
					<span class="icon-menu"></span>
				</button>
				<ul class="navbar-nav mr-lg-2">
					<li class="nav-item nav-search d-none d-lg-block">
						<div class="input-group">
							<div class="input-group-prepend hover-cursor"
								id="navbar-search-icon">
								<span class="input-group-text" id="search"> <i
									class="icon-search"></i>
								</span>
							</div>
							<input type="text" class="form-control" id="navbar-search-input"
								placeholder="Search now" aria-label="search"
								aria-describedby="search" />
						</div>
					</li>
				</ul>
				<ul class="navbar-nav navbar-nav-right">
					<li class="nav-item dropdown"></li>
					<li class="nav-item nav-profile dropdown"><a
						class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
						id="profileDropdown"> <img src="/images/faces/face28.jpg"
							alt="profile" />
					</a>
						<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
							aria-labelledby="profileDropdown">
							<a class="dropdown-item"> <i class="ti-settings text-primary"></i>
								Settings
							</a> <a class="dropdown-item"> <i
								class="ti-power-off text-primary"></i> Logout
							</a>
						</div></li>
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="icon-menu"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<div class="theme-setting-wrapper">
				<div id="settings-trigger">
					<i class="ti-settings"></i>
				</div>
				<div id="theme-settings" class="settings-panel">
					<i class="settings-close ti-close"></i>
					<p class="settings-heading">SIDEBAR SKINS</p>
					<div class="sidebar-bg-options selected" id="sidebar-light-theme">
						<div class="img-ss rounded-circle bg-light border mr-3"></div>
						Light
					</div>
					<div class="sidebar-bg-options" id="sidebar-dark-theme">
						<div class="img-ss rounded-circle bg-dark border mr-3"></div>
						Dark
					</div>
					<p class="settings-heading mt-2">HEADER SKINS</p>
					<div class="color-tiles mx-0 px-4">
						<div class="tiles success"></div>
						<div class="tiles warning"></div>
						<div class="tiles danger"></div>
						<div class="tiles info"></div>
						<div class="tiles dark"></div>
						<div class="tiles default"></div>
					</div>
				</div>
			</div>
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link"
						href="/admin/admin-dashboard"> <i class="icon-grid menu-icon"></i> <span
							class="menu-title">Dashboard</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/users">
							<i class="icon-head menu-icon"></i> <span class="menu-title">Users</span>
					</a></li>
					<!-- <div class="collapse" id="auth">
                                <ul class="nav flex-column sub-menu">
                                    <li class="nav-item"><a class="nav-link" href="pages/samples/login.html"> Login </a></li>
                                    <li class="nav-item"><a class="nav-link" href="pages/samples/register.html"> Register </a></li>
                                </ul>
                            </div> -->
					</li>

					<li class="nav-item"><a class="nav-link"
						data-toggle="collapse" href="#ui-basic" aria-expanded="false"
						aria-controls="ui-basic"> <i class="icon-layout menu-icon"></i>
							<span class="menu-title">Vaccines</span> <i class="menu-arrow"></i>
					</a>
						<div class="collapse" id="ui-basic">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="/admin/centers/edit/covaxin">Covaxin</a></li>
								<li class="nav-item"><a class="nav-link"
									href="/admin/centers/edit/covishield">Covishield</a></li>
								<!-- <li class="nav-item"><a class="nav-link" href="pages/ui-features/typography.html">Typography</a></li> -->
							</ul>
						</div></li>
				</ul>
			</nav>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-md-12 grid-margin">
							<div class="row">
								<div class="col-12 col-xl-8 mb-4 mb-xl-0">
									<h3 class="font-weight-bold">Welcome ${adminName}</h3>
									<h6 class="font-weight-normal mb-0">All systems are
										running smoothly!</h6>
								</div>
								<div class="col-12 col-xl-4">
									<div class="justify-content-end d-flex">
										<div class="dropdown flex-md-grow-1 flex-xl-grow-0"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card tale-bg">
								<div class="card-people mt-auto">
									<img src="/images/dashboard/people.svg" alt="people" />
									<div class="weather-info">
										<div class="d-flex">
											<div>
												<h2 class="mb-0 font-weight-normal">
													<i class="icon-sun mr-2"></i>40<sup>C</sup>
												</h2>
											</div>
											<div class="ml-2">
												<h4 class="location font-weight-normal">Guntur</h4>
												<h6 class="font-weight-normal">India</h6>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 grid-margin transparent">
							<div class="row">
								<div class="col-md-6 mb-4 stretch-card transparent">
									<div class="card card-tale">
										<div class="card-body">
											<p class="mb-4">Total Doses Available</p>
											<p class="fs-30 mb-2">4006</p>
										</div>
									</div>
								</div>
								<div class="col-md-6 mb-4 stretch-card transparent">
									<div class="card card-dark-blue">
										<div class="card-body">
											<p class="mb-4">Total Bookings</p>
											<p class="fs-30 mb-2">61344</p>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<!-- <div class="col-md-6 mb-4 mb-lg-0 stretch-card transparent">
                                        <div class="card card-light-blue">
                                            <div class="card-body">
                                                <p class="mb-4">Number of Meetings</p>
                                                <p class="fs-30 mb-2">34040</p>
                                                <p>2.00% (30 days)</p>
                                            </div>
                                        </div>
                                    </div> -->
								<div class="col-md-6 stretch-card transparent">
									<div class="card card-light-danger">
										<div class="card-body">
											<p class="mb-4">Number of Clients</p>
											<p class="fs-30 mb-2">47033</p>
											<!-- <p>0.22% (30 days)</p> -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->

	<!-- plugins:js -->
	<script src="/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="/vendors/chart.js/Chart.min.js"></script>
	<script src="/vendors/datatables.net/jquery.dataTables.js"></script>
	<script src="/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
	<script src="/js/dataTables.select.min.js"></script>

	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="/js/off-canvas.js"></script>
	<script src="/js/hoverable-collapse.js"></script>
	<script src="/js/template.js"></script>
	<script src="/js/settings.js"></script>
	<script src="/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="/js/dashboard.js"></script>
	<script src="/js/Chart.roundedBarCharts.js"></script>
	<!-- End custom js for this page-->
</body>
</html>
