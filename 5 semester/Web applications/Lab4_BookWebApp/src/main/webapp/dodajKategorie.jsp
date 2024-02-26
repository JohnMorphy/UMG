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
<h2>Formularz dodawania kategorii</h2>

<form action="formAddKategoria" method="post">
  
	<label for="opis">Opis kategorii</label><br>
	<input type="text" id="opis" name="opis" placeholder="opis..."><br><br>
	
  <input type="submit" value="Wyślij">
 
</form>
</div>


</body>
</html>