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
    <title>Notepad Management Application</title>
</head>
<body style="background-color: #d9d3f5;">
<h1>Enter Notepad Country</h1>
    <form action="countryList" method="post">
        <input type="text" name="country"/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
