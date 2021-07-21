<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brewery Results</title>
<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/css/globalStyles.css" />">
</head>
<body>
<!-- Header -->
<div class="headerSection">
<div class="row headerRow">
  <div class="col col-lg-4 leftDiv">
    <h1 class="title"><i class="fas fa-beer"></i>Buzz Finder</h1>
  </div>
  <div class="col col-lg-4 middleDiv">
  </div>
  <div class="col col-lg-4 rightDiv">
    <form action="signup.do">
    <button type="submit" class="btn btn-light sign-up-button">Sign Up</button>
    </form>
    <form action="login.do" >
    <button type="submit" class="btn btn-light login-button" >Login</button>
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
<!-- Content -->
<div class="mainContent">
	<div class="innerContent">
	
	<h1>Brewery Search Complete!</h1>
	<br/>
		<h3>Click on a brewery name to view more information, and what to drink there!</h3>
		
		<h2>Brewery Finder Results: </h2>
	<h4>${breweries.size()} Breweries Found</h4>

	<c:choose>
		<c:when test="${!empty breweries}">
			<c:forEach var="brewery" items="${breweries}">
				<ul>
				<form action="breweryDetails.do">
					<li><b></b> ${brewery.logo}
					<li><b>Brewery Name:</b> ${brewery.name}
					<li><b>Address:</b> ${brewery.address}</li>
					<li><b>Id:</b> ${brewery.id}</li>
					<input type=hidden name="id" value="${brewery.id}"> 
					<input type="submit" value="Details">
				</form>
				</ul>
			</c:forEach>
		</c:when>
		<c:otherwise>
		<p>Sorry!</p>
		<p>No breweries found</p>
		</c:otherwise>
	</c:choose>
	<br>
	</div>
</div>

	

</body>
</html>