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

	<!-- Update/Delete Account Buttons -->
	<form action="deleteAccount.do" method="GET">
		<input type="hidden" name="id" value="${Account.id }" /> <input
			type="submit" value="Delete Account" />
	</form>

	<form action="updateAccount.do" method="GET">
		<input type="hidden" name="id" value="${Account.id }" /> <input
			type="submit" value="Update Account" />
	</form>
	<!-- Show Favorite Beers/Breweries -->
	<c:forEach var="" items="">
	
	</c:forEach>
	<!-- Add a Beer Review -->
	<form action="addBeerRev.do" method="GET">
		<input type="hidden" name="id" value="${Account.id }" /> <input
			type="submit" value="Add Beer Review" />
	</form>
	<!-- Add a Brewery Review -->
	<form action="addBrewRev.do" method="GET">
		<input type="hidden" name="id" value="${Account.id }" /> <input
			type="submit" value="Add Brewery Review" />
	</form>
</body>
</html>