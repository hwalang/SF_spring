<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.mybatis.dto.*"  %>
<%
EmpDto empDto = (EmpDto) request.getAttribute("empDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpDetail</title>
</head>
<body>
	<h1>EmpDetail</h1>
	<p>Emp ID: <%=empDto.getEmployeeId() %></p>
	<p>Emp Name: <%=empDto.getLastName() %> <%= empDto.getFirstName() %></p>
	<p>Emp Email: <%=empDto.getEmail() %></p>
</body>


</html>