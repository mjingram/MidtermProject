<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>A Beer for your thoughts?</title>
<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- CSS -->
<link rel="stylesheet" href='<c:url value="/css/globalStyles.css" />'>
         <link href ="css/review.css" type ="text/css" rel ="stylesheet"></link>

</head>
<body>
<!-- Splash Page  -->
<div class="splashPage"></div>
<!-- Header -->
<div class="headerSection">
<div class="row ">
  <div class="col col-lg-4">
    <h1 class="title">
    <a href="home.do"><i class="fas fa-beer"></i>Buzz Finder</a></h1>
    
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
<div class="mainContent">

	<div class="innerContent">

<div class = "navigation">
<form action="home.do"> <!--Login Page  -->
<button type="submit">Home</button>
</form> <br>
<form action="search.do"> <!--Login Page  -->
<button type="submit">Search Beers and Breweries</button>
</form> <br>

</div>

<center><h2>Submit this form to post a review, our brewers appreciate hearing from you!</h2></center>


<form action="createBeerReview.do">
<input type = "hidden" name = "beerId" value="${beerId }">
		<label for="name">Beer Name: </label><input type="text" name="name" size = "30" value="${beer.name }" id="name" readonly><br>
		<label for="taste">Taste: </label>
		<select id="taste" name="taste">
		<option value="fruity" >Fruity</option>
		<option value="bitter" >Bitter</option>
		<option value="malty" >Malty</option>
		<option value="dark" >Dark</option>
		<option value="hoppy" >Hoppy</option>
		<option value="crisp" >Crisp</option></select><br>
<label for="body">Body: </label>
			<select id="body" name="body">
    			<option value="light">Light</option>
    			<option value="sweet">Sweet</option>
    			<option value="thin">Thin</option>
    			<option value="dry">Dry</option>
    			<option value="full">Full</option>
    			<option value="creamy">Creamy</option>
    			<option value="heavy">Heavy</option>
    			<option value="rich">Rich</option>
    			<option value="thick">Thick</option>
    		</select><br>
		<label for="rating">Overall Rating: (5 is the highest)</label>
			<input type="radio" id = "rating" name="rating" value="0"> 0
			<input type="radio" id = "rating" name="rating" value="1"> 1
			<input type="radio" id = "rating" name="rating" value="2"> 2
			<input type="radio" id = "rating" name="rating" value="3"> 3
			<input type="radio" id = "rating" name="rating" value="4"> 4
			<input type="radio" id = "rating" name="rating" value="5"> 5
			<br>
		<label for="again">Would you drink it again? </label>
		<input type="radio" id = "again" name="again" value="yes"> 10/10 Yes times two
			<input type="radio" id = "again" name="again" value="no"> 1/10 Heck No techno
			<br>
			
					<input type="submit" value="Add Review" />
			
</form>
</div>
</div>
</body>
</html>