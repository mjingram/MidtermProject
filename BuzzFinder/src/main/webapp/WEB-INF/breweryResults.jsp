<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brewery Results</title>
</head>
<body>

<p><a href="home.do">Home</a></p>
<form action="search.do"> <!--Search Page  -->
<button type="submit">Search</button>
</form><form action="login.do"> <!--Login Page  -->
<button type="submit">Login</button>
</form><br>

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

</body>
</html>