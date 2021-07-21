<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please will you come back?</title>

<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- CSS -->
<link rel="stylesheet" href="<c:url value="/css/globalStyles.css" />">
</head>
<body>
<!-- Splash Page  -->
<div class="splashPage"></div>
<!-- Header -->
<div class="headerSection">
<div class="row ">
  <div class="col col-lg-4">
    <h1 class="title"><i class="fas fa-beer"></i>Buzz Finder</h1>
  </div>
  <div class="col col-lg-4">
  </div>
  <div class="col col-lg-4">
    <form action="signup.do">
    <button type="submit" class="btn btn-light sign-up-button">Sign Up</button>
    </form>
    <form action="login.do" >
    <button type="submit" class="btn btn-light login-button" >Login</button>
    </form>
    <form action="search.do">
    <button type="submit" class="btn btn-light search-button">Search</button>
    </form>
  </div>
</div>
</div>
<!-- Beer Fizz -->
<div class="fizz f1"></div>
<div class="fizz f2"></div>
<div class="fizz f3"></div>
<div class="fizz f4"></div>
<div class="fizz f5"></div>
<div class="fizz f6"></div>
<div class="fizz f7"></div>
<div class="fizz f8"></div>
<div class="fizz f9"></div>
<div class="fizz f10"></div>
<div class="fizz f11"></div>
<div class="fizz f12"></div>
<div class="fizz f13"></div>
<div class="fizz f14"></div>
<div class="fizz f15"></div>
<div class="fizz f16"></div>
<div class="fizz f17"></div>
<div class="fizz f18"></div>
<div class="fizz f19"></div>
<div class="fizz f20"></div>
<div class="fizz f21"></div>
<div class="fizz f22"></div>
<div class="fizz f23"></div>
<div class="fizz f24"></div>
<div class="fizz f25"></div>
<div class="fizz f26"></div>
<div class="fizz f27"></div>
<div class="fizz f28"></div>
<div class="fizz f29"></div>
<div class="fizz f30"></div>
<div class="fizz f31"></div>
<div class="fizz f32"></div>
<div class="fizz f33"></div>
<div class="fizz f34"></div>
<div class="fizz f35"></div>
<div class="fizz f36"></div>
<div class="fizz f37"></div>
<div class="fizz f38"></div>
<div class="fizz f39"></div>
<div class="fizz f40"></div>
<div class="fizz f41"></div>
<div class="fizz f42"></div>
<div class="fizz f43"></div>
<div class="fizz f44"></div>
<div class="fizz f45"></div>
<div class="fizz f46"></div>
<div class="fizz f47"></div>
<div class="fizz f48"></div>
<p><a href="home.do">Home</a></p>
<form action="search.do"> <!--Login Page  -->
<button type="submit">Search</button>
</form><form action="login.do"> <!--Login Page  -->
<button type="submit">Login</button>
</form><br>

<form action="createBreweryReview.do">
		<label for="name">Brewery Name: </label><input type="text" name="name" value="${brewery.name}" id="name" readonly><br>
<label for="favorite">Favorite Beer Here: </label>
			<select id="favorite" name="favorite">
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

<label for="feature">Favorite Feature: </label>
			<select id="feature" name="feature">
    			<option value="space">Super Spacious</option>
    			<option value="modern">Fresh and New</option>
    			<option value="clean">Squeaky Clean</option>
    			<option value="outdoor">It's Like We Are Camping</option>
    			<option value="view">I can see downtown from here!</option>
    			<option value="dogs">My dog was right there with me</option>
    			<option value="staff">Friendly Staff</option>
    			<option value="location">It is close to my house</option>
    			<option value="beer">The beer is just good!</option>
    		</select><br>
			
			
					<input type="submit" value="Confirm and Review" />
			
</form>

</body>
</html>