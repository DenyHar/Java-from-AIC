<%--
  Created by IntelliJ IDEA.
  User: DenysH
  Date: 26.11.2025
  Time: 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Вгадай число</title>
</head>
<body>
<h1>Дайте чесну відповідь</h1>
    <p>${question} ${number} </p>
<form action="guess-servlet" method="GET">
    Answer: <input type="radio" name="answer" value="true" checked />True
    <input type="radio" name="answer" value="false" />False
    <input type="submit" value="Submit" />
</form>
</body>
</html>
