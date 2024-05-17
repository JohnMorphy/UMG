<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/ksiazki.css">
<title>Lista ksiązek</title>
</head>
<body>

<c:import url="/getAllTables?jspFile=menu"/>
<div id="zawartosc">
<p>Liczba książek: ${listaKsiazek.size()}</p>
<h2>Lista książek</h2>
<c:forEach var="el" items="${listaKsiazek}">
<p>${el.tytul}, ${el.wyd.nazwa}</p>
</c:forEach>
</div>


</body>
</html>