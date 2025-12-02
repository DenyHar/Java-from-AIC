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
    <c:if test="${notepads != null}">
        <c:forEach items="${notepads}" var="notepad">
            <h3>Name: ${notepad.getName()} </h3>
            <p>${notepad.toString()}</p>
        </c:forEach>
    </c:if>

    <c:if test="${production != null}">
        <c:forEach items="${production}" var="production">
            <h3>${command}: ${production[0]} </h3>
            <p>${production[1]}</p>
        </c:forEach>
    </c:if>

    <a href="new">Add New Notepad</a>
    <br>
    <a href="idDel">Delete Notepad</a>
    <br>
    <a href="idEdit">Edit Notepad</a>
    <br>
    <a href="list">List All Notepads</a>
    <br>
    <a href="productionCountry">Production by country</a>
    <br>
    <a href="productionPublisher">Production by publisher</a>
    <br>
    <a href="topProductionCountry">Top productive country</a>
    <br>
    <a href="topProductionPublisher">Top productive publisher</a>
    <br>
    <a href="bottomProductionCountry">Least productive country</a>
    <br>
    <a href="bottomProductionPublisher">Least productive publisher</a>
    <br>
    <a href="hardNotepads">Hard Notepads</a>
    <br>
    <a href="softNotepads">Soft Notepads</a>
    <br>
    <a href="country">Show by country</a>
    <br>
    <a href="filteredByPages">Filtered by Pages</a>
    <br>
    <a href="filteredPageType">Filtered by Page Type</a>
    <br>
    <a href="filteredByCirculation">Filtered by Circulation</a>
</body>
</html>
