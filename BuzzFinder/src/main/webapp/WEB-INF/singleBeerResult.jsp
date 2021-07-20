<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Beer is all it takes</title>
</head>
<body>
<ul>
<li>${beer.name }</li>
<li>${beer.beerStyle }</li>
<li>${beer.brewery }</li>
<li>${beer.abv }</li>
<li>${beer.ibu }</li>
<li>${beer.ounces }</li>
</ul>

<form action="home.do">
	<input type="submit" name ="home" value="Home"/></form>
	
	<form action="search.do"> <!--Login Page  -->
<button type="submit">Search Beers and Breweries</button>
</form>


 <!-- Add this to my favorites -->
 	<form action="beerFavorites.do">
<input type="hidden" name="id" value="${beer.id }">
<input type="submit" value="Favorite">
</form>
</body>
</html>