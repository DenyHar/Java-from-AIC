<%--
  Created by IntelliJ IDEA.
  User: DenysH
  Date: 30.11.2025
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Sells Management Application</title>
</head>
<body style="background-color: #d9d3f5;">
<h1>Вкажіть інтервал дат</h1>
    <form action="selectByDate" method="post">
        З <input type="date" name="beginDate"/>
        <br>
        По <input type="date" name="endDate" required/>
        <br>
        <input type="radio" name="choice" value = "Exact"/>Exact date (by end date)
        <input type="radio" name="choice" value = "Interval" checked/>Interval
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
