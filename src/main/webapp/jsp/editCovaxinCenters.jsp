<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Edit Covaxin Page</title>
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
				<a class="navbar-brand brand-logo mr-5"
					href="/admin/admin-dashboard"><img src="/images/logo.png"
					class="mr-2" alt="logo" /></a> <a class="navbar-brand brand-logo-mini"
					href="/admin/admin-dashboard"><img src="images/logo-mini.svg"
					alt="logo" /></a>
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
						href="/admin/admin-dashboard"> <i class="icon-grid menu-icon"></i>
							<span class="menu-title">Dashboard</span>
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
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Edit Covaxin Centers</h4>
									<p class="card-description"></p>
									<form class="forms-sample" action="/admin/centers/edit/covaxin"
										method="post">
										<div class="form-group">
											<label for="exampleSelectGender">Location</label> <select
												class="form-control" id="exampleSelectGender"
												name="location" required>
												<option value="">${city}</option>
												<option value="GUNTUR">GUNTUR</option>
												<option value="KURNOOL">KURNOOL</option>
												<option value="VIJAYAWADA">VIJAYAWADA</option>
												<option value="VISAKHAPATNAM">VISAKHAPATNAM</option>
											</select>
										</div>
										<div class="form-group">
											<label for="exampleInputName1">Count</label> <input
												type="number" class="form-control" id="exampleInputName1"
												min="0" name="vaccineCount" value="${count}" required />
										</div>
										<button type="submit" class="btn btn-primary mr-2">Update</button>
										<span
											style="color: green; font-size: 24px; font-style: italic;">${msg}</span>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
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
</body>
</html>
