<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="userregisterProcess" modelAttribute="user" method="post">
username<input type="text" name="username" id="username"/><br>
password<input type="password" name="password" id="password"/><br>
fullname<input type="text" name="fullname" id="fullname"/><br>
phonenumber<input type="text" name="number" id="number"/><br>
email<input type="text" name="email" id="email"/><br>
<button id="register" name="register">register</button>
</form>
</body>
</html>