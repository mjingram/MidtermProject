<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Info</title>
</head>
<body>
<h1>Enter Account Information:</h1>
<form action="sendAccountCreate.do">
<input type="hidden" name="username" value="${user.username }">
<input type="hidden" name="password" value="${user.password }">
<input type="text" name="firstname" placeholder="First Name">
<input type="text" name="lastname" placeholder="Last Name">
<input type="text" name="street" placeholder="Address">
<input type="text" name="city" placeholder="City">
<input type="text" name="state" placeholder="State">
<input type="text" name="zipcode" placeholder="Zip">
<input type="submit" value="Send">

</form>
</body>
</html>