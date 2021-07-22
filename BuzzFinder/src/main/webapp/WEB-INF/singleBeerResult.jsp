<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beer Details</title>
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
<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/css/globalStyles.css" />">
         <link href ="css/singleResult.css" type ="text/css" rel ="stylesheet"></link>

</head>
<body>
	<!-- Splash Page  -->
	<div class="splashPage"></div>
	<!-- Header -->
	<div class="headerSection">
		<div class="row ">
			<div class="col col-lg-4">
				<h1 class="title">
					<a href="home.do"><i class="fas fa-beer"></i>Buzz Finder</a>
				</h1>
			</div>
			<div class="col col-lg-4"></div>
			<div class="col col-lg-4">
				<form action="signup.do">
					<button type="submit" class="btn btn-light sign-up-button">Sign
						Up</button>
				</form>
				<form action="login.do">
					<button type="submit" class="btn btn-light login-button">Login</button>
				</form>
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
	
	<div class="mainContent">
	
	<div class="innerContent">
<div class = "navigation">

	<form action="beerFavorites.do">
		<input type="hidden" name="id" value="${beer.id }"> 
		<input type="hidden" name="userId" value="${user.id }">
		<input type="submit" value="Favorite">
	</form>
	<form action="beerReview.do">
		<input type="hidden" name="beerId" value="${beer.id }"> <input
			type="submit" value="Review">
	</form>
	</div>
	
<h3>Details:</h3>
	<ul>
		<li><b>Beer Name:</b> ${beer.name }</li>
		<li><b>Beer Style:</b> ${beer.beerStyle }</li>
		<li><b>Brewery:</b> ${beer.brewery }</li>
		<li><b>Beer Abv:</b> ${beer.abv }</li>
		<li><b>Beer IBU:</b> ${beer.ibu }</li>
		<li><b>Beer Ounces:</b> ${beer.ounces }</li>
	</ul>


<h3>Reviews:</h3>
	<c:choose>
		<c:when test="${not empty beerReviews}">
			<c:forEach var="beerReview" items="${beerReviews}">
				<ul>
					<li><b>Taste:</b>${beerReview.taste }</li>
					<li><b>Body:</b>${beerReview.body }</li>
					<li><b>Overall Rating:</b>${beerReview.rating }</li>
					<li><b>Would you drink again:</b>${beerReview.again}</li>
				</ul>
			</c:forEach>
		</c:when>
		
		<c:otherwise>
			<p>No Reviews</p>
		</c:otherwise>
	</c:choose>

</div>
</div>
</body>
</html>