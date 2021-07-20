<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brewery Details</title>
</head>
<body>
<ul>
<%-- <li>${brewery.id }</li> --%>

<li>${brewery.name }</li>
<li>${brewery.address }</li>
<form action="breweryFavorites.do">
<input type="hidden" name="id" value="${brewery.id }">
<input type="submit" value="Favorite">
</form>
</ul>



 <!-- Add this to my favorites -->

</body>
</html>