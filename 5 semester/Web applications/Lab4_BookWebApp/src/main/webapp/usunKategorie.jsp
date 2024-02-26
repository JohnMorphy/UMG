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
<h2>Formularz usuwania kategorii</h2>
<p>Poniżej znajduje się pole wyboru, gdzie znajduję się tylko takie kategorie, które można usunąć.
<br>(czyli takie, które nie są wykorzystane w żadnej książce)</p>

<c:choose>
	<c:when test="${not empty listaKategoriiDoUsuniecia}">
	<form action="formRemoveKategoria" method="post">
  
		<label for="idk">Kategoria do usunięcia</label><br>
		<select id="idk" name="idk">
		<c:forEach var="el" items="${listaKategoriiDoUsuniecia}">
			<option value=${el.idk}>${el.opis}</option>
		</c:forEach>
		</select>
		<br><br>
		
	  	<input type="submit" value="Wyślij">
 
	</form>
	</c:when>
	<c:otherwise>
	<p>Brak kategorii do usunięcia.</p>
	</c:otherwise>

</c:choose>
</div>


</body>
</html>