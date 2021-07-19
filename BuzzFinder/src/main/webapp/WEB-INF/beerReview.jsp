<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A Beer for your thoughts?</title>
</head>
<body>
<h1>Fill out this form for valuable feedback, our brewers appreciate hearing from you!</h1>


<form action="createBeerReview.do">
		<label for="name">Beer Name: </label><input type="text" name="name" value="" id="name"><br>
		<label for="taste">Taste: </label><input type="text" name="taste" value="" id="taste"><br>
<label for="feel">Body and Mouthfeel: </label>
			<select id="feel" name="feel">
    			<option value="rich">Rich</option>
    			<option value="full">Full</option>
    			<option value="light">Light</option>
    			<option value="creamy">Creamy</option>
    			<option value="heavy">Heavy</option>
    			<option value="sweet">Sweet</option>
    			<option value="dry">Dry</option>
    			<option value="thick">Thick</option>
    			<option value="thin">Thin</option>
    		</select><br>
		<label for="rating">Overall Rating: (5 is the highest)</label><br>
			<input type="radio" id = "rating" name="rating" value="0"> 0
			<input type="radio" id = "rating" name="rating" value="1"> 1
			<input type="radio" id = "rating" name="rating" value="2"> 2
			<input type="radio" id = "rating" name="rating" value="3"> 3
			<input type="radio" id = "rating" name="rating" value="4"> 4
			<input type="radio" id = "rating" name="rating" value="5"> 5
			
		<label for="again">Would you drink it again? </label><br>
		<input type="radio" id = "again" name="again" value="yes"> Yes
			<input type="radio" id = "again" name="again" value="no"> No
			
			
					<input type="radio" value="Add to Favorites" />
					<input type="submit" value="Confirm and Review" />
			
</form>

</body>
</html>