<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>

	<form action="getBreweryByName.do" method="GET">
		Enter Brewery Name Here: <input type="text" name="name" size="25" /> <input
			type="submit" value="Get Brewery" />
	</form>
	<br>
	<form action="getBeerByName.do" method="GET">
		Enter Beer Name Here: <input type="text" name="name" size="25" /> <input
			type="submit" value="Get Beer" />
	</form>
	<br>
	<form action="getBeerByStyle.do" method="GET">
		Beer Style: <input type="text" name="beerStyle" size="25" />
		<input type="submit" value="Get Beers" />
	</form>
	<br>
	<form action="getBreweryByLocation.do" method="GET">
		Enter City Here: <input type="text" name="city" size="15" />
		Enter State Here: <input type="text" name="state" size="10" />
		<input type="submit" value="Find Breweries" />
	</form>

	<form action="login.do">
		<button type="submit">Login</button>
	</form>

</body>
</html>