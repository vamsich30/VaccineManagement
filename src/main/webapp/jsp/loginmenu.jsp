<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>

<!-- font awesome cdn link  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

<!-- custom css file link  -->
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<!-- header section starts  -->

	<header class="header">
		<a href="/dashboard" class="logo"> <i class="fas fa-heartbeat"></i>
			medcare.
		</a>

		<nav class="navbar">
			<a href="/dashboard">home</a>
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

	<!-- header section ends -->

	<!-- home section starts  -->

	<section class="home" id="home">
		<div class="image">
			<img src="/images/home-img.svg" alt="" />
		</div>

		<div class="content">
			<h3>stay safe, stay healthy</h3>
		</div>
	</section>

	<!-- home section ends -->

	<!-- icons section starts  -->

	<section class="icons-container">
		<div class="icons">
			<i class="fas fa-user-md"></i>
			<h3>140+</h3>
			<p>doctors at work</p>
		</div>

		<div class="icons">
			<i class="fas fa-users"></i>
			<h3>1040+</h3>
			<p>satisfied patients</p>
		</div>

		<div class="icons">
			<i class="fas fa-procedures"></i>
			<h3>500+</h3>
			<p>bed facility</p>
		</div>

		<div class="icons">
			<i class="fas fa-hospital"></i>
			<h3>80+</h3>
			<p>available hospitals</p>
		</div>
	</section>

	<!-- icons section ends -->

	<!-- services section starts  -->

	<section class="services" id="services">
		<h1 class="heading">
			our <span>services</span>
		</h1>

		<div class="box-container">
			<div class="box">
				<i class="fas fa-notes-medical"></i>
				<h3>free checkups</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ad,
					omnis.</p>
				<a href="/check" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>

			<div class="box">
				<i class="fas fa-ambulance"></i>
				<h3>24/7 ambulance</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ad,
					omnis.</p>
				<a href="#" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>

			<div class="box">
				<i class="fas fa-user-md"></i>
				<h3>expert doctors</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ad,
					omnis.</p>
				<a href="#" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>

			<div class="box">
				<i class="fas fa-pills"></i>
				<h3>medicines</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ad,
					omnis.</p>
				<a href="#" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>

			<div class="box">
				<i class="fas fa-procedures"></i>
				<h3>bed facility</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ad,
					omnis.</p>
				<a href="#" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>

			<div class="box">
				<i class="fas fa-heartbeat"></i>
				<h3>total care</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ad,
					omnis.</p>
				<a href="#" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>
		</div>
	</section>

	<!-- services section ends -->

	<!-- about section starts  -->

	<section class="about" id="about">
		<h1 class="heading">
			<span>about</span> us
		</h1>

		<div class="row">
			<div class="image">
				<img src="/images/about-img.svg" alt="" />
			</div>

			<div class="content">
				<h3>we take care of your healthy life</h3>
				<p>Lorem ipsum dolor sit amet consectetur, adipisicing elit.
					Iure ducimus, quod ex cupiditate ullam in assumenda maiores et
					culpa odit tempora ipsam qui, quisquam quis facere iste fuga, minus
					nesciunt.</p>
				<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
					Natus vero ipsam laborum porro voluptates voluptatibus a nihil
					temporibus deserunt vel?</p>
				<a href="#" class="btn"> learn more <span
					class="fas fa-chevron-right"></span>
				</a>
			</div>
		</div>
	</section>

	<!-- about section ends -->

	<section class="blogs" id="blogs">
		<h1 class="heading">
			<span>blogs</span>
		</h1>

		<div class="box-container">
			<div class="box">
				<div class="image">
					<img src="/images/blog-1.jpg" alt="" />
				</div>
				<div class="content">
					<div class="icon">
						<a href="#"> <!-- <i class="fas fa-calendar"></i> --></a> <a
							href="#"> <!-- <i class="fas fa-user"></i> --></a>
					</div>
					<h3>Covid-19 Cases</h3>
					<p>7-day rolling average. Due to varying protocols and
						challenges in the attribution of the cause of death, the number of
						confirmed deaths may not accurately represent the true number of
						deaths caused by COVID-19.</p>
					<a
						href="https://ourworldindata.org/explorers/coronavirus-data-explorer?facet=none&Metric=Confirmed+deaths&Interval=7-day+rolling+average&Relative+to+Population=true&Color+by+test+positivity=false&country=~IND"
						class="btn" target="_blank"> learn
						more <span class="fas fa-chevron-right"></span>
					</a>
				</div>
			</div>

			<div class="box">
				<div class="image">
					<img src="/images/who.png" alt="" />
				</div>
				<div class="content">
					<div class="icon">
						<a href="#"> <!-- <i class="fas fa-calendar"></i> -->
						</a> <a href="#"> <!-- <i class="fas fa-user"></i> --></a>
					</div>
					<h3>World Health Organization</h3>
					<p>WHO latest news about COVID-19</p>
					<a
						href="https://www.who.int/emergencies/diseases/novel-coronavirus-2019"
						class="btn" target="_blank"> learn more <span
						class="fas fa-chevron-right"></span>
					</a>
				</div>
			</div>

			<div class="box">
				<div class="image">
					<img src="/images/child.jpg" alt="" />
				</div>
				<div class="content">
					<div class="icon">
						<a href="#"> <i class="fas fa-calendar"></i> Nov 03, 2021
						</a> <a href="#"> <i class="fas fa-user"></i> by admin
						</a>
					</div>
					<h3>COVID-19 Vaccines for Kids Ages 5 to 11, Here’s What to
						Know</h3>
					<p>Parents have been eagerly awaiting this news, especially
						since many kids are back to in-person learning this past fall.</p>
					<a
						href="https://www.bannerhealth.com/healthcareblog/advise-me/what-to-know-about-covid-19-vaccines-for-kids-5-to-11"
						class="btn" target="_blank"> learn more <span
						class="fas fa-chevron-right"></span>
					</a>
				</div>
			</div>
		</div>
	</section>

	<!-- blogs section ends -->

	<!-- footer section starts  -->

	<section class="footer">
		<div class="box-container">
			<div class="box">
				<h3>quick links</h3>
				<a href="#"> <i class="fas fa-chevron-right"></i> home
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> services
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> about
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> doctors
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> book
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> review
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> blogs
				</a>
			</div>

			<div class="box">
				<h3>our services</h3>
				<a href="#"> <i class="fas fa-chevron-right"></i> dental care
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> message
					therapy
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> cardioloty
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> diagnosis
				</a> <a href="#"> <i class="fas fa-chevron-right"></i> ambulance
					service
				</a>
			</div>

			<div class="box">
				<h3>contact info</h3>
				<a href="#"> <i class="fas fa-phone"></i> 9493538450
				</a> <a href="#"> <i class="fas fa-envelope"></i>
					chintalavamsi123@gmail.com
				</a> <a href="#"> <i class="fas fa-envelope"></i>
					chintalavamsi123@gmail.com
				</a> <a href="#"> <i class="fas fa-map-marker-alt"></i> GUNTUR, AP,
					India - 522001
				</a>
			</div>

		</div>
	</section>

	<!-- footer section ends -->

	<!-- custom js file link  -->
	<script src="/js/script.js"></script>
</body>
</html>
