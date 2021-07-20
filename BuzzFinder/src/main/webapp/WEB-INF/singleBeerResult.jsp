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
<li><b>Beer Name:</b> ${beer.name }</li>
<li><b>Beer Style:</b> ${beer.beerStyle }</li>
<li><b>Brewery:</b> ${beer.brewery }</li>
<li><b>Beer Abv:</b> ${beer.abv }</li>
<li><b>Beer IBU:</b> ${beer.ibu }</li>
<li><b>Beer Ounces:</b> ${beer.ounces }</li> 
</ul>

<form action="home.do">
	<input type="submit" name ="home" value="Home"/></form>
	
	<form action="search.do"> <!--Login Page  -->
<button type="submit">Search Beers and Breweries</button>
</form>


 <!-- Add this to my favorites -->
</body>
</html>