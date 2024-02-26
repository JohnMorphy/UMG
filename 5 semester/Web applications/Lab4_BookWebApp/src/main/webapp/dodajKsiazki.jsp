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
<h2>Formularz dodawania książek</h2>

<form action="formAddKsiazka" method="post">
  
	<label for="tytul">Nazwa książki</label><br>
	<input type="text" id="tytul" name="tytul" placeholder="tytuł..."><br><br>
	
	<label for="idwyd">Wydawnictwo</label><br>
	<select id="idwyd" name="idwyd">
	<c:forEach var="el" items="${listaWydawnictw}">
		<option value=${el.idw}>${el.nazwa} ${el.adres}</option>
	</c:forEach>
	</select>
	<br><br>
	
	<label for="idkat">Kategoria</label><br>
	<select id="idkat" name="idkat">
	<c:forEach var="el" items="${listaKategorii}">
		<option value=${el.idk}>${el.opis}</option>
	</c:forEach>
	</select><br><br>

  <input type="submit" value="Wyślij">
 
</form>
</div>


</body>
</html>