<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brewery Results</title>
</head>
<body>

<p><a href="home.do">Home</a></p>
<form action="search.do"> <!--Login Page  -->
<button type="submit">Search</button>
</form><form action="login.do"> <!--Login Page  -->
<button type="submit">Login</button>
</form><br>

	<h1>Your Results are listed below.</h1>
		<h2>Click on a brewery name to view more information, and what to drink there!</h2>
		
		<c:choose>
		<c:when test="${true }">
			<table>
				<thead><th><strong>Located at:</strong></th><th><strong>Name:</strong></th></thead>
				<c:forEach items="${brewery.id}" var="brewery">
					<tr>
					<td>${brewery.location}</td>
					<td><a href="SearchByBreweryName.do?id=${brewery.name}"></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>

		 <c:otherwise>
			<p>No breweries in database.</p>
		</c:otherwise>
	</c:choose>

</body>
</html>