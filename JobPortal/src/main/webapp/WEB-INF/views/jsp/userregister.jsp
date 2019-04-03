<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
 .registerbox1{
 margin-left:300px;
 margin-top:20px;
     height:450px;
     width:300px;
     background: #808080;
     padding-left: 100px;
     padding-top:50px;}
     </style>
<body>

<div class="registerbox2">
<form action="userregisterProcess" modelAttribute="user" method="post">
<h2>User Register</h2><br>
username <input type="text" name="username" id="username"/><br><br><br>
password <input type="password" name="password" id="password"/><br><br><br>
fullname <input type="text" name="fullname" id="fullname"/><br><br><br>
phonenumber <input type="text" name="number" id="number"/><br><br><br>
email <input type="text" name="email" id="email"/><br><br><br>
<button id="register" name="register">register</button>
</form>
</div>
</body>
</html>