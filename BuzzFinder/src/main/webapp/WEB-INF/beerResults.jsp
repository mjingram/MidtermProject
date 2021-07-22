<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Beer Results</title>
<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Otomanopee+One&family=Zen+Loop&display=swap" rel="stylesheet">
<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/css/globalStyles.css" />">
<link rel="stylesheet" href="<c:url value="/css/beerAndBreweryResults.css" />">
</head>
<body>
<canvas id="canvas1"></canvas>
	<!-- Header -->
	<div class="headerSection">
		<div class="row headerRow">
			<div class="col col-lg-4 leftDiv">

				<h1 class="title">
					<a href="home.do"> <i class="fas fa-beer headerBeerIcon"></i>Buzz Finder
					</a>
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

	<h1>Your Results are listed below.</h1>
		<h2>Click on a beer to view where
		you can find it, and drink it!</h2> <br>
			<h4>${beers.size()} Beers Found</h4>
		
		<c:choose>
		<c:when test="${not empty beers }">
		<c:forEach var = "beer" items = "${beers }">
			
			<table>
			<tr><th width="20%">Beer Name:</th><th width="10%">Beer Style:</th><th width="40%">Brewery:</th><th width="7%">Beer Abv:</th><th width="7%">Beer IBU:</th><th width="8%">Beer Ounces:</th><th width="8%"></th>
			</tr>
			<tr>
			<td>${beer.name }</td><td> ${beer.beerStyle }</td><td>${beer.brewery.name}<br>${ beer.brewery.address.city}, ${ beer.brewery.address.state}</td><td> ${beer.abv }</td><td> ${beer.ibu }</td><td> ${beer.ounces }</td>
			<td class="imageCell"><c:if test="${not empty beer.imageUrl}"> <img src="${beer.imageUrl }"></c:if>
			<c:if test="${empty beer.imageUrl}"><i class="fas fa-beer"></i> </c:if>
			<br>
			<form action = "beerDetails.do">
			<input type=hidden name="id" value="${beer.id}"> 
					<input type="submit" value="Details">
			</form>
			</td>
			</tr>
</table>


</c:forEach>
		</c:when>

		 <c:otherwise>
			<p>No beers in database.</p>
		</c:otherwise>
	</c:choose>
	</div>
</div>

<script src="<c:url value="/js/bubbles.js"/>"></script>
</body>
</html>