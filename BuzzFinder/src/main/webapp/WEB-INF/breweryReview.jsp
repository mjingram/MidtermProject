<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please will you come back?</title>
</head>
<body>
<p><a href="home.do">Home</a></p>
<form action="search.do"> <!--Login Page  -->
<button type="submit">Search</button>
</form><form action="login.do"> <!--Login Page  -->
<button type="submit">Login</button>
</form>

<form action="createBreweryReview.do">
		<label for="name">Brewery Name: </label><input type="text" name="name" value="" id="name"><br>
<label for="favorite">Favorite Beer Here: </label>
			<select id="feel" name="feel">
    			<option value="light">Light Lager</option>
    			<option value="sweet">Sweet Cider</option>
    			<option value="thin">Thin Kolsch</option>
    			<option value="dry">Dry Wheat</option>
    			<option value="full">Full Wit</option>
    			<option value="creamy">Creamy Ale</option>
    			<option value="heavy">Heavy Stout</option>
    			<option value="rich">Rich Porter</option>
    			<option value="thick">Thick IPA</option>
    		</select><br>
		<label for="rating">Overall Rating: (5 is the highest)</label><br>
			<input type="radio" id = "rating" name="rating" value="0"> 0
			<input type="radio" id = "rating" name="rating" value="1"> 1
			<input type="radio" id = "rating" name="rating" value="2"> 2
			<input type="radio" id = "rating" name="rating" value="3"> 3
			<input type="radio" id = "rating" name="rating" value="4"> 4
			<input type="radio" id = "rating" name="rating" value="5"> 5
			
		<label for="again">Would you visit again? </label><br>
		<input type="radio" id = "again" name="again" value="yes"> Yes
			<input type="radio" id = "again" name="again" value="no"> No
			
			
					<input type="radio" value="Add to Favorites" />
					<input type="submit" value="Confirm and Review" />
			
</form>

</body>
</html>