<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
</head>
<body>
<h1>Update Account</h1>
<form action="sendUpdateAccount.do">
<input type="hidden" name="id" value="${accountInfo.id }" />
<input type="text" name="firstName" value="${accountInfo.firstName }">
<input type="text" name="lastName" value="${accountInfo.lastName }">
<input type="text" name="street" value="${addressInfo.street }">
<input type="text" name="city" value="${addressInfo.city }">
<input type="text" name="state" value="${addressInfo.state }">
<input type="text" name="zipcode" value="${addressInfo.city }">
<input type="submit" value="Send">


</form>

<form action="profile.do">
<button type="submit">Profile</button>
</form>

</body>
</html>