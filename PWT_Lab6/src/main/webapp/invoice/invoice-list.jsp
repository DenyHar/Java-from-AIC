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
    <h1>Invoice Management</h1>
    <c:forEach items="${invoices}" var="invoice">
        <h3>ID.${invoice.getId()} </h3>
        <p>${invoice.toString()}</p>
    </c:forEach>

    <a href="new">Add New Invoice</a>
    <br>
    <a href="idDel">Delete Invoice</a>
    <br>
    <a href="idEdit">Edit Invoice</a>
    <br>
    <a href="list">List All Invoices</a>
    <br>
    <a href="date">List By Date</a>
    <br>
    <a href="idSeller">List By Seller</a>
    <br>
    <a href="idBuyer">List By Buyer</a>
    <br>
    <a href="/PWT_Lab6_war_exploded/index.jsp">Return to index</a>
</body>
</html>
