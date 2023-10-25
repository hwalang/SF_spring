<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycom.mybatis.dto.*, java.util.List" %>
<%
List<StudentDto> studentList = (List<StudentDto>) request.getAttribute("studentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpList</title>
</head>
<body>
	<h1>EmpList</h1>
<% for (StudentDto studentDto : studentList) { %>
	<p>student ID: <%=studentDto.getStudentId() %></p>
	<p>student Name: <%=studentDto.getStudentNm() %></p>
	<p>student Email: <%=studentDto.getEmail() %></p>
	<p>student Phone: <%=studentDto.getPhone() %></p>
	<hr>
<% } %>
</body>


</html>