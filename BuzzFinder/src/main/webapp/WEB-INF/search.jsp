<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>

	<form action="GetBreweryByName.do" method="GET">
		Enter Brewery Name Here: <input type="text" name="id" size="4" /> <input
			type="submit" value="Get Brewery" />
	</form>
	<br>
	<form action="GetBeerByName.do" method="GET">
		Enter Beer Name Here: <input type="text" name="search" size="25" /> <input
			type="submit" value="Get Beer" />
	</form>
	<br>
	<form action="GetBeerByStyle.do" method="GET">
		Beer Style: <input type="text" name="search" size="25" />
		<input type="submit" value="Get Beers" />
	</form>
	<br>
	<form action="GetBreweryByLocation.do" method="GET">
		Enter City Here: <input type="text" name="search" size="25" />
		<input type="submit" value="Find Breweries" />
	</form>

	<form action="login.do">
		<button type="submit">Login</button>
	</form>

</body>
</html>