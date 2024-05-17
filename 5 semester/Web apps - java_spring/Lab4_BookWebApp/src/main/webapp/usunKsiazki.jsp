<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/ksiazki.css">
<title>Książki</title>
</head>
<body>

<c:import url="/getAllTables?jspFile=menu"/>
<div id="zawartosc">
<h2>Formularz uswania książek</h2>

<form action="formRemoveKsiazka" method="post">
  
	<label for="idk">Książka do usunięcia</label><br>
	<select id="idk" name="idk">
	<c:forEach var="el" items="${listaKsiazek}">
		<option value=${el.idk}>${el.tytul}, ${el.wyd.nazwa}</option>
	</c:forEach>
	</select>
	<br><br>
	
  <input type="submit" value="Wyślij">
 
</form>
</div>


</body>
</html>