<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% String job=request.getParameter("job");
 System.out.println(job);
 %>
 <table>
 <tr>
<td> <strong><%=job%></strong></td>
 </tr>
 </table>
 <form action="confirm.jsp">
Why do you select this job?
<input type="text" name="answer1"/><br><br>
What do you know about our company?
<input type="text" name="answer2"/><br><br>
<input type="submit" value="Submit all Answers and Confirm Application"/>
 </form>
</body>
</html>