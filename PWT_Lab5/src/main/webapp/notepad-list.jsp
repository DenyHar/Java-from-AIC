<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: DenysH
  Date: 29.11.2025
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Notepad Management Application</title>
</head>
<body style="background-color: #d9d3f5;">
    <h1>Notepad Management</h1>

    <c:forEach items="${notepads}" var="notepad">
        <h3>Name: ${notepad.getName()} </h3>
        <p>${notepad.toString()}</p>
    </c:forEach>


    <a href="new">Add New Notepad</a>
    &nbsp;
    <a href="idDel">Delete Notepad</a>
    &nbsp;
    <a href="idEdit">Edit Notepad</a>
</body>
</html>
