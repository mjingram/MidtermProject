<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	<!-- TODO: Show Account Info -->
	${accountInfo.firstName}<br>
	${accountInfo.lastName}<br>
	${addressInfo.street}<br>
	${addressInfo.city}<br>
	${addressInfo.state}<br>
	${addressInfo.zipcode}<br>
	
	<!-- Update/Delete Account Buttons -->
	<form action="deleteAccountPage.do" method="GET">
		<input type="hidden" name="id" value="${accountInfo.accountId }" /> <input
			type="submit" value="Delete Account" />
	</form>

	<form action="updateAccountPage.do" method="GET">
		<input type="hidden" name="id" value="${accountInfo.accountId }" /> <input
			type="submit" value="Update Account" />
	</form>
	<!-- Show Favorite Beers/Breweries -->
	<c:forEach var="" items="">
	
	</c:forEach>
	<!-- Add a Beer Review -->
<%-- 	<form action="createBeerReview.do" method="GET">
		<input type="hidden" name="id" value="${ }" /> <input
			type="submit" value="Add Beer Review" />
	</form>
	<!-- Add a Brewery Review -->
	<form action="createBreweryReview.do" method="GET">
		<input type="hidden" name="id" value="${account.id }" /> <input
			type="submit" value="Add Brewery Review" />
	</form> --%>
</body>
</html>