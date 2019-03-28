<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<form action="userloginProcess" modelAttribute="login" method="post">
username<input type="text" name="username" id="username"/><br>
password<input type="password" name="password" id="password"/><br>
<button id="login" name="login">login</button>
</form>
</body>
</html>