<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Are you sure you wish to delete your account?</h1>
<form action="sendAccountDelete.do">
<input type="hidden" name="id" value="${accountInfo.id }" />
<button type="submit">Delete</button>
</form>

<form action="profile.do">
<button type="submit">Back to Profile</button>
</form>
</body>
</html>