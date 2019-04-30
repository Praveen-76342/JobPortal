<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% 
String id = (String)session.getAttribute("id");
%>


<body>
<a href="userhome.jsp">Home</a> | <a href="resume.htm">Upload Resume</a> || <a href="addJobsToSeeker.htm">View Jobs Applied</a> | <a href="addSkill.htm">Add Skills</a> | <a href="viewSkill.htm">View Skills</a> | </font></div>
 <br><a href="search">Search For Jobs</a> 
<a href="logout">Log Out</a>
</body>
</html>