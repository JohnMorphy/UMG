<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/ksiazki.css">
<title>Kontakt</title>
</head>
<body>


<c:import url="/getAllTables?jspFile=menu"/>
<div id="zawartosc">
<h2>Dane kontaktowe:</h2>
<p>Nazwa: Księgarenka.pl</p>
<p>Email: 12345@example.com</p>
<h2>Współpraca z wydawnictwami</h2>
<c:forEach var="el" items="${listaWydawnictw}">
<p>${el.nazwa}</p>
</c:forEach>
</div>


</body>
</html>