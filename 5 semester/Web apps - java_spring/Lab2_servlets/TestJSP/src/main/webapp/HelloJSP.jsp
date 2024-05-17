<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Java Server Pages</h1>
	<a href="/TestJSP/index.html">link</a>
	<%@ page import="java.util.*" %>
	<h2>Time on server: <%= new Date() %></h2>
</body>
</html>