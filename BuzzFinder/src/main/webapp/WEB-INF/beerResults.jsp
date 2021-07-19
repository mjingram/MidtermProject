<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
</form>

	<h1>Your Results are listed below.</h1>
		<h2>Click on a beer to view where
		you can find it, and drink it!</h2>
		
		<c:choose>
		<c:when test="${true }">
			<table>
				<thead><th><strong>Brewed at:</strong></th><th><strong>Name:</strong></th><th><strong>Style:</strong></th></thead>
				<c:forEach items="${beer }" var="beer">
					<tr>
					<td>${beer.brewery}</td>
					<td><a href="SearchByBeerName.do?id=${beer.name}">${beer.style}</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>

		 <c:otherwise>
			<p>No beers in database.</p>
		</c:otherwise>
	</c:choose>
		
		



</body>
</html>