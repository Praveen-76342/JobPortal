<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RecruiterRegisterProcess" modelAttribute="recruiter" method="post">
username <input type="text" name="username" id="username"/><br><br><br>
password <input type="password" name="password" id="password"/><br><br><br>
Company Name <input type="text" name="cname" id="cname"/><br><br><br>
phonenumber <input type="text" name="number" id="number"/><br><br><br>
email <input type="text" name="email" id="email"/><br><br><br>
<button id="register" name="register">register</button>
</form>
</body>
</html>