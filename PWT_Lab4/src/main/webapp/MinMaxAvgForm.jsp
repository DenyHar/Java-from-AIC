<%--
  Created by IntelliJ IDEA.
  User: DenysH
  Date: 28.11.2025
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мін/Макс/Середнє</title>
</head>
<body>
    <h1>Введіть три числа та оберіть дію</h1>
<form action="min-max-average-servlet" method="GET">
    Число 1: <input name="number1" />
    Число 2: <input name="number2" />
    Число 3: <input name="number3" />
    <br><br>
    Вибір дії: <input type="radio" name="choice" value="min" checked/>Min
    <input type="radio" name="choice" value="max"/>Max
    <input type="radio" name="choice" value="avg"/>Average
    <input type="submit" name="Submit">
</form>
</body>
</html>
