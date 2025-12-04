
<%--
  Created by IntelliJ IDEA.
  Product: DenysH
  Date: 29.11.2025
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Sells Management Application</title>
</head>
<body style="background-color: #d9d3f5;">
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="new">Add New Product</a>
        &nbsp;
        <a href="idDel">Delete Product</a>
        &nbsp;
        <a href="idEdit">Edit Product</a>
        &nbsp;
        <a href="list">List All Products</a>
        &nbsp;
        <a href="/PWT_Lab6_war_exploded/index.jsp">Return to index</a>
    </h2>
</center>
<div align="center">

    <form action="${product != null ? 'update' : 'insert'}" method="post">

            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        ${product != null ? "Edit Product" : "Add New Product"}
                    </h2>
                </caption>
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="${product.getId()}" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="${product.getName()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="number" name="price" size="20"
                               value="${product.getPrice()}"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Sumbit" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
