<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.mydb.dto.*, java.util.List" %>
<%
List<EmpDto> empList = (List<EmpDto>) request.getAttribute("empList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpList</title>
</head>
<body>
	<h1>EmpList</h1>
<% for (EmpDto empDto : empList) { %>
	<p>Emp ID: <%=empDto.getEmployeeId() %></p>
	<p>Emp Name: <%=empDto.getLastName() %> <%= empDto.getFirstName() %></p>
	<p>Emp Email: <%=empDto.getEmail() %></p>
	<hr>
<% } %>
</body>


</html>