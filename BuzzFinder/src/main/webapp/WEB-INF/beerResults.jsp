<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Beer Results</title>
</head>
<body>
<p><a href="home.do">Home</a></p>
<form action="search.do"> <!--Login Page  -->
<button type="submit">Search</button>
</form><form action="login.do"> <!--Login Page  -->
<button type="submit">Login</button>
</form><br>

	<h1>Your Results are listed below.</h1>
		<h2>Click on a beer to view where
		you can find it, and drink it!</h2>
		
		<c:choose>
		<c:when test="${not empty beers }">
		<c:forEach var = "name" items = "${beers }">
			<ul>
<li>${beer.name }</li>
<li>${beer.beerStyle }</li>
<li>${beer.abv }</li>
<li>${beer.ibu }</li>
<li>${beer.ounces }</li>
</ul>
</c:forEach>
		</c:when>

		 <c:otherwise>
			<p>No beers in database.</p>
		</c:otherwise>
	</c:choose>
		
		



</body>
</html>