<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ page import="com.mycom.myapp.dto.*" %>
<%
String seq = (String) request.getAttribute("seq");
EmpDto empDto = (EmpDto) request.getAttribute("empDto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewTest4</h1>
	<h2>seq: <%= seq %></h2>
	<h2>empDto: <%= empDto %></h2>
</body>
</html>