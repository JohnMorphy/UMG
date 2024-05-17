<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Guessing game</title>
</head>
<body>

<h2>Which number did I generate?</h2>

<form method="get" action="guess">
    <input type="number" name="number">
    <input type="submit" value="Send">
    <p style="color:red;">${message}</p>
</form>

<div>
    <h2>Guessing history</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Number</th>
        </tr>
        <%
            ArrayList<Integer> guessingHistory = GuessingGameServlet.guessingHistory;
            for (int i = 0; i < guessingHistory.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + (i + 1) + "</td>");
                out.print("<td>" + guessingHistory.get(i) + "</td>");
                out.print("</tr>");
            }
        %>
    </table>
</div>

</body>
</html>
