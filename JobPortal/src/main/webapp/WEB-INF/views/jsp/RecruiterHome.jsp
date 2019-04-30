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
<%=session.getAttribute("id")%>
<a href="CreateJob">Create Job</a><br> <br>
<a href="ViewApplications">View Applications</a><br> <br>

<a href="logout">Log Out</a><br>

</body>
</html>