<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pl">
<head>
<meta charset="UTF-8">
<title>Guessing Numbers</title>
</head>
<body>
<h2>Congratulations! You won!</h2>
<form method='get' action='finish'>
<p style="color:red;">It took ${message} guesses</p>
<br><br>
<p><a href="index.html">Back to menu...</a></p>
</form>
</body>
</html>