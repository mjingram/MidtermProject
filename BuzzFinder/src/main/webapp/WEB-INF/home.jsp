<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buzz Finder</title>
<!-- BootStrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Chart.JS  -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/7.0.0/d3.min.js"
	integrity="sha512-0x7/VCkKLLt4wnkFqI8Cgv6no+AaS1TDgmHLOoU3hy/WVtYta2J6gnOIHhYYDJlDxPqEqAYLPS4gzVex4mGJLw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/css/globalStyles.css" />">
<link rel="stylesheet" href="<c:url value="/css/home.css" />">
</head>
<body>
<c:if test="${empty sessionScope.user }">
	<!-- Splash Page  -->
	<div class="splash">
		<h1 class="fade-in splashHead">Welcome to Buzz Finder</h1>

		<!--   <iframe src="https://giphy.com/embed/ju0nZjYgnDgPRrwhrg"  frameBorder="0" class="giphy-embed" allowFullScreen></iframe> -->

	</div>
</c:if>	
	<!-- Header -->
	<div class="headerSection">
		<div class="row headerRow">
			<div class="col col-lg-4 leftDiv">

				<h1 class="title">
					<i class="fas fa-beer"></i>Buzz Finder
				</h1>
			</div>
			<div class="col col-lg-4 middleDiv"></div>
			<div class="col col-lg-4 rightDiv">
			<c:if test="${empty sessionScope.user }">
				<form action="signup.do">
					<button type="submit" class="btn btn-light sign-up-button">Sign
						Up</button>
				</form>
				
					<form action="login.do">
						<button type="submit" class="btn btn-light login-button">Login</button>
					</form>
				</c:if>
				<c:if test="${not empty sessionScope.user }">
					<form action="logout.do">
						<button type="submit" class="btn btn-light login-button">Logout</button>
					</form>
				</c:if>
				<form action="search.do">
					<button type="submit" class="btn btn-light search-button">Search</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Beer Fizz -->
	<div class="fizz f1"></div>
	<div class="fizz f2"></div>
	<div class="fizz f3"></div>
	<div class="fizz f4"></div>
	<div class="fizz f5"></div>
	<div class="fizz f6"></div>
	<div class="fizz f7"></div>
	<div class="fizz f8"></div>
	<div class="fizz f9"></div>
	<div class="fizz f10"></div>
	<div class="fizz f11"></div>
	<div class="fizz f12"></div>
	<div class="fizz f13"></div>
	<div class="fizz f14"></div>
	<div class="fizz f15"></div>
	<div class="fizz f16"></div>
	<div class="fizz f17"></div>
	<div class="fizz f18"></div>
	<div class="fizz f19"></div>
	<div class="fizz f20"></div>
	<div class="fizz f21"></div>
	<div class="fizz f22"></div>
	<div class="fizz f23"></div>
	<div class="fizz f24"></div>
	<div class="fizz f25"></div>
	<div class="fizz f26"></div>
	<div class="fizz f27"></div>
	<div class="fizz f28"></div>
	<div class="fizz f29"></div>
	<div class="fizz f30"></div>
	<div class="fizz f31"></div>
	<div class="fizz f32"></div>
	<div class="fizz f33"></div>
	<div class="fizz f34"></div>
	<div class="fizz f35"></div>
	<div class="fizz f36"></div>
	<div class="fizz f37"></div>
	<div class="fizz f38"></div>
	<div class="fizz f39"></div>
	<div class="fizz f40"></div>
	<div class="fizz f41"></div>
	<div class="fizz f42"></div>
	<div class="fizz f43"></div>
	<div class="fizz f44"></div>
	<div class="fizz f45"></div>
	<div class="fizz f46"></div>
	<div class="fizz f47"></div>
	<div class="fizz f48"></div>
	<!-- Content -->
	<div class="mainContent">
		<div class="innerContent">
			<h1>Buzz Finder Contains Data on 558 Breweries and 2,410 Beers!</h1>
			<h3>Search the database for information on your favorite brews
				and brewerys. Add your favorites to your profile so you won't
				forget. See the charts below for more information on the beers in
				our database.</h3>
			<h5>Breweries by State</h5>
			<canvas id="beerByStateChart"></canvas>
			<h5>Beers by Style</h5>
			<canvas id="beerByStyles"></canvas>
		</div>
	</div>


	<!-- Welcome info, Analytics? -->



	<script src="<c:url value="/js/home.js"/>"></script>
	<script src="<c:url value="/js/beerByState.js"/>"></script>
	<script src="<c:url value="/js/beerByStyle.js"/>"></script>
	<script src="<c:url value="/js/logoutButton.js"/>"></script>
</body>
</html>
