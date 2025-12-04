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
<h1>Enter ID</h1>
<c:if test="${command.equals('delete') }">
    <form action="delete" method="post">
</c:if>
<c:if test="${command.equals('edit') }">
    <form action="edit" method="post">
</c:if>
        <input type="number" name="id"/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
