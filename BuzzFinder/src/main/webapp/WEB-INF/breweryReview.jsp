<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please will you come back?</title>

<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Otomanopee+One&family=Zen+Loop&display=swap" rel="stylesheet"> 
<!-- CSS -->
<link rel="stylesheet" href='<c:url value="css/globalStyles.css" />'>
<link rel="stylesheet" href='<c:url value="css/review.css" />'>

</head>
<body>
<canvas id="canvas1"></canvas>
	<!-- Header -->
	<div class="headerSection">
		<div class="row headerRow">
			<div class="col col-lg-4 leftDiv">

				<h1 class="title">
					<a href="home.do"> <i class="fas fa-beer"></i>Buzz Finder
					</a>
				</h1>
			</div>
			<div class="col col-lg-4 middleDiv"></div>
			<div class="col col-lg-4 rightDiv">
				<c:if test="${empty sessionScope.user }">
					<form action="signup.do">
						<button type="submit" class="btn btn-light sign-up-button">Sign
							Up</button>
					</form>

					<form action="login.do">
						<button type="submit" class="btn btn-light login-button">Login</button>
					</form>
				</c:if>
				<c:if test="${not empty sessionScope.user }">
					<form action="logout.do">
						<button type="submit" class="btn btn-light login-button">Logout</button>
					</form>
				</c:if>
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
	<h1 class="reviewMainHeader">Submit this form to post a review, our brewers appreciate hearing from you!</h1>
		<form action="createBreweryReview.do">
		<input type = "hidden" name = "breweryId" value = "${brewery.id }">
		<label class="headerLabel">Brewery Name: </label>
		<input class="form-control" type="text" name="name" size = "30" value="${brewery.name}" id="name" readonly>
		<label class="headerLabel">Favorite Beer I had: </label>
			<select id="favorite" name="favorite" class="form-control">
    			<option value="Light Lager">Light Lager</option>
    			<option value="Sweet Cider">Sweet Cider</option>
    			<option value="Thin Kolsch">Thin Kolsch</option>
    			<option value="Dry Wheat">Dry Wheat</option>
    			<option value="Full Wit">Full Wit</option>
    			<option value="Creamy Ale">Creamy Ale</option>
    			<option value="Heavy Stout">Heavy Stout</option>
    			<option value="Rich Porter">Rich Porter</option>
    			<option value="Thick IPA">Thick IPA</option>
    		</select>
		<!-- <label for="rating">Overall Rating: (5 is the highest)</label>
			<input type="radio" id = "rating" name="rating" value="0"> 0
			<input type="radio" id = "rating" name="rating" value="1"> 1
			<input type="radio" id = "rating" name="rating" value="2"> 2
			<input type="radio" id = "rating" name="rating" value="3"> 3
			<input type="radio" id = "rating" name="rating" value="4"> 4
			<input type="radio" id = "rating" name="rating" value="5"> 5
			<br>
		<label for="again">Would you visit again? </label>
		<input type="radio" id = "again" name="again" value="yes"> Yes
			<input type="radio" id = "again" name="again" value="no"> No -->
			
			<div class="rating">
		<label class="headerLabel">Overall Rating: (5 is the highest)</label><br>
			<input type="radio" id = "rating1" name="rating" value="0" class="form-check-input" checked>  <label class="form-check-label" for="rating1">0</label>
			<input type="radio" id = "rating2" name="rating" value="1" class="form-check-input"> <label class="form-check-label" for="rating2">1</label>
			<input type="radio" id = "rating3" name="rating" value="2" class="form-check-input"> <label class="form-check-label" for="rating3">2</label>
			<input type="radio" id = "rating4" name="rating" value="3" class="form-check-input"> <label class="form-check-label" for="rating4">3</label>
			<input type="radio" id = "rating5" name="rating" value="4" class="form-check-input"> <label class="form-check-label" for="rating5">4</label>
			<input type="radio" id = "rating6" name="rating" value="5" class="form-check-input"> <label class="form-check-label" for="rating6">5</label>
		</div>
		<div class="again">
		<label >Would you visit again? </label><br>
		<input type="radio" id = "again1" name="again" value="yes" class="form-check-input"><label class="form-check-label" for="again1">Yes</label>
			<input type="radio" id = "again2" name="again" value="no" class="form-check-input" checked> <label class="form-check-label" for="again2">No</label>
		</div>

		<label class="headerLabel">Favorite Feature: </label>
			<select id="feature" name="feature" class="form-control">
    			<option value="The beer is just good!">The beer is just good!</option>
    			<option value="Super Spacious">Super Spacious</option>
    			<option value="Fresh and New">Fresh and New</option>
    			<option value="Squeaky Clean">Squeaky Clean</option>
    			<option value="It's Like We Are Camping">It's Like We Are Camping</option>
    			<option value="I can see downtown from here!">I can see downtown from here!</option>
    			<option value="My dog was right there with me">My dog was right there with me</option>
    			<option value="Friendly Staff">Friendly Staff</option>
    			<option value="It is close to my house">It is close to my house</option>
    			<option value="Didn't like a dang thing">Didn't like a dang thing</option>
    		</select>
			
			
			<input type="submit" value="Add Review" class="btn btn-light reviewBtn"/>
			
</form>
</div>
</div>
<script src="<c:url value="/js/bubbles.js"/>"></script>
</body>
</html>