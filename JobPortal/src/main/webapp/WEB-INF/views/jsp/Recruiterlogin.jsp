<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RecruiterloginProcess" modelAttribute="Recruiterlogin" method="post">
username<input type="text" name="username" id="username"/><br><br><br>
password<input type="password" name="password" id="password"/><br><br><br>
<button id="login" name="login">Recruiter Login</button>
</form>
</body>
</html>