<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.List"%>
   <%@page import ="javax.servlet.http.HttpSession" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String id = (String)session.getAttribute("id");
session.setAttribute("id",id);
%>
<table>
<tr>
<th>S.No</th>
<th>Company Name</th>
<th>Job Name</th>
<th>Job Description</th>
<th>Skills Required</th>
<th>Click to Apply</th>
<c:forEach var="job" items="${listJob}" varStatus="status">
<tr>
<td>${status.index + 1}</td>
<td>${job.cname}
<td>${job.name}</td>
<td>${job.description}</td>
<td>${job.skills}</td>
<td> <form action="applyjob" ><input type="submit" name="job" value="${job.name}"></form></td>
</tr>
</c:forEach>
</tr>
</table>

</body>
</html>