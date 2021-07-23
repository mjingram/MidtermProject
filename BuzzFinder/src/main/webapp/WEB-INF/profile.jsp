<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
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

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Merriweather&family=Otomanopee+One&family=Zen+Loop&display=swap"
	rel="stylesheet">
<!-- CSS -->
<link rel="stylesheet" href='<c:url value="css/globalStyles.css" />'>
<link rel="stylesheet" href='<c:url value="css/profile.css" />'>

</head>
<body>
	<canvas id="canvas1"></canvas>
	<!-- Header -->
	<div class="headerSection">
		<div class="row headerRow">
			<div class="col col-lg-4 leftDiv">
				<h1 class="title">
					<a href="home.do"><i class="fas fa-beer"></i>Buzz Finder </a>
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

			


			
				<h1>Account Information:</h1>
				<!-- TODO: Show Account Info -->
				
				<table>
				<tr>
				<th>First Name</th><th>Last Name</th><th>Street</th><th>City</th><th>State</th><th>Zip</th>
				</tr>
				<tr>
				
				<td>${accountInfo.firstName}</td>
				<td>${accountInfo.lastName}</td>
				<td>${addressInfo.street}</td> 
				<td>${addressInfo.city}</td>
				<td>${addressInfo.state}</td> 
				<td>${addressInfo.zipcode}</td>
				</tr>
				
				
				</table>
				
		
			<!-- Update/Delete Account Buttons -->
			<div class="updateAndDeleteBtn">
				<form action="deleteAccountPage.do" method="GET">
					<input type="hidden" name="id" value="${accountInfo.id }" /> <input
						type="submit" value="Delete Account" class="btn btn-light accountBtnProfile"/>
				</form>
		
				<form action="updateAccountPage.do" method="GET">
					<input type="hidden" name="id" value="${accountInfo.id }" /> <input
						type="submit" value="Update Account" class="btn btn-light accountBtnProfile" />
				</form>
			</div>


			<!-- Show Favorite Beers/Breweries -->
		
		
		
			<c:if test="${not empty faveBeers }">
				<h1 class="favBeerHeader">Favorite Beers</h1>
				</c:if>
				<table class="favoriteBeerTable">
				<c:if test="${not empty faveBeers }">
				<tr>
				<th>Name:</th><th>Brewery</th><th>ABV</th><th>IBU</th><th></th><th></th>
				</tr>
				</c:if>
				<c:forEach var="b" items="${faveBeers}">
				<c:if test="${not empty b.id }">
					
						<tr>
						<td width="20%">${b.name}</td>
						<td width="30%">${b.brewery.name}</td>
						<td width="10%">${b.abv}</td>
						<td width="10%">${b.ibu}</td>
						<td width="15%">
						<form action="removeFavoriteBeer.do" method="GET">
						<input type="hidden" name="id" value="${b.id }" /> <input
							type="submit" value="Remove Beer" class="btn btn-light favBrewTableBtn" />
						</form>
						</td>
						<td width="15%">
						<form action = "beerDetails.do">
			<input type=hidden name="id" value="${b.id}"> 
					<input type="submit" value="Details" class="btn btn-light favBrewTableBtn">
			</form>
						</td>
						</tr>
					
					
						
					
					
					
					</c:if>
				</c:forEach>
			</table>

				
		

			
			<c:if test="${not empty faveBreweries }">
				<h1 class="favBreweryHeader">Favorite Breweries</h1>
				</c:if>
				<table class="favoriteBreweryTable">
				<c:if test="${not empty faveBreweries }">
				<tr>
				<th>Name:</th><th>City</th><th>State</th><th></th><th></th>
				</tr>
				</c:if>
				<c:forEach var="brew" items="${faveBreweries}">
				<c:if test="${not empty brew.id }">
					<tr>
					<td width="30%">${brew.name}</td>
					<td width="25%">${brew.address.city}</td>
					<td width="15%">${brew.address.state}</td>
					<td width="15%">
					<form action="removeFavoriteBrewery.do" method="GET">
						<input type="hidden" name="id" value="${brew.id }" /> <input
							type="submit" value="Remove Brewery" class="btn btn-light favBreweryTableBtn"/>
					</form>
					</td>
					<td width="15%">
					<form action="breweryDetails.do">
					<input type=hidden name="id" value="${brew.id}"> 
					<input type="submit" value="Details" class="btn btn-light favBreweryTableBtn">
					</form>
					</td>
						
						
						
				
					
					
					</tr>
				</c:if>
				</c:forEach>
			
				</table>
				
				

		
		

		</div>
	</div>
	<script src="<c:url value="/js/bubbles.js"/>"></script>
</body>
</html>