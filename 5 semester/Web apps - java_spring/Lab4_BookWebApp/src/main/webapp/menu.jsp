<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="menu">
<ul>
<li><a href="index.jsp">Strona domowa</a></li>
<li><a href="getAllTables?jspFile=listaKsiazek">Wszystkie książki</a></li>
<li class="podmenu">Kategorie
<ul>
<c:forEach var="el" items="${listaKategorii}">
<li><a href="getAllTables?jspFile=listaKsiazek&id=${el.idk}">${el.opis}</a></li>
</c:forEach>
</ul>
</li>
<li><a href="getAllTables?jspFile=kontakt">Kontakt</a></li>

<li><a href="getAllTables?jspFile=dodajKsiazki">Dodaj książki</a></li>
<li><a href="getAllTables?jspFile=usunKsiazki">Usuń książki</a></li>

<li><a href="dodajKategorie.jsp">Dodaj kategorię</a></li>
<li><a href="getAllTables?jspFile=usunKategorie&removeableKategoria=true">Usuń kategorię</a></li>

<li><a href="dodajWydawnictwo.jsp">Dodaj wydawnictwo</a></li>
<li><a href="getAllTables?jspFile=usunWydawnictwo">Usuń wydawnictwo</a></li>
</ul>
</div>
