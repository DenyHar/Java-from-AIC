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
    <title>Sells Management Application</title>
</head>
<body style="background-color: #d9d3f5;">
    <h1>Buyer Management</h1>
    <c:forEach items="${buyers}" var="buyer">
        <h3>ID.${buyer.getId()} ${buyer.getFirstName()} </h3>
        <p>${buyer.toString()}</p>
    </c:forEach>

    <a href="new">Add New Buyer</a>
    <br>
    <a href="idDel">Delete Buyer</a>
    <br>
    <a href="idEdit">Edit Buyer</a>
    <br>
    <a href="list">List All Buyers</a>
    <br>
    <a href="top">Top Buyer</a>
    <br>
    <a href="/PWT_Lab6_war_exploded/index.jsp">Return to index</a>
</body>
</html>
