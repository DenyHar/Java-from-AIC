<%--
  Created by IntelliJ IDEA.
  User: DenysH
  Date: 26.11.2025
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Множення</title>
</head>
<body>
<h1>Для якого числа бажаєте отримати таблицю множення?</h1>
<form action="table-servlet" method="POST">
    Number: <select name="number">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
    <option>6</option>
    <option>7</option>
    <option>8</option>
    <option>9</option>
</select>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
