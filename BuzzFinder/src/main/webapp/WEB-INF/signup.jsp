<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>

<h2><b>Endless Beer and Brewery Knowledge is just Moments Away!</b></h2>

<h3>Enter your Info Here:</h3>
	<form action="createUserProfile.do" method="POST">
	
		<p><label for = "username">Username:</label>
		<input type="text" name="username" size="20"/></p>
		
		<p><label for = "password">Password:</label>
		<input type="text" name="password" size="27"/></p>
		
		
		<p>Select your favorite style of beer: <select name="beerStyle">
          <option value="none">Don't know yet</option>
          <option value="beerStyle1">American Amber Ale</option>
          <option value="beerStyle2">American Amber Lager</option>
          <option value="beerStyle3">American Barley Wine</option>
          <option value="beerStyle4">American Black Ale</option>

        </select>
		
		<p><input type="submit" value = "Create Now!"/></p>
	</form> 
	
	<a href="home">Go Home</a><br/>

</body>
</html>