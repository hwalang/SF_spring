<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.mybatis.dto.*"  %>
<%
StudentDto studentDto = (StudentDto) request.getAttribute("studentDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Detail</title>
</head>
<body>
	<h1>Student Detail</h1>
	<p>student ID: <%=studentDto.getStudentId() %></p>
	<p>student Name: <%=studentDto.getStudentNm() %></p>
	<p>student Email: <%=studentDto.getEmail() %></p>
	<p>student Phone: <%=studentDto.getPhone() %></p>
</body>


</html>