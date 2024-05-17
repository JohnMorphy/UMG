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
<h2>Formularz dodawania wydawnictw</h2>

<form action="formAddWydawnictwo" method="post">
  
	<label for="nazwa">Nazwa wydawnictwa</label><br>
	<input type="text" id="nazwa" name="nazwa" placeholder="nazwa..."><br><br>
	
	<label for="adres">Adres wydawnictwa</label><br>
	<input type="text" id="adres" name="adres" placeholder="adres..."><br><br>
	
  <input type="submit" value="Wyślij">
 
</form>
</div>


</body>
</html>