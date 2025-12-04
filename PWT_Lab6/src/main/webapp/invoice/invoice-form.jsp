
<%--
  Created by IntelliJ IDEA.
  Invoice: DenysH
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
    <h1>Invoice Management</h1>
    <h2>
        <a href="new">Add New Invoice</a>
        &nbsp;
        <a href="idDel">Delete Invoice</a>
        &nbsp;
        <a href="idEdit">Edit Invoice</a>
        &nbsp;
        <a href="list">List All Invoices</a>
        &nbsp;
        <a href="/PWT_Lab6_war_exploded/index.jsp">Return to index</a>
    </h2>
</center>
<div align="center">

    <form action="${invoice != null ? 'update' : 'insert'}" method="post">

            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        ${invoice != null ? "Edit Invoice" : "Add New Invoice"}
                    </h2>
                </caption>
                <c:if test="${invoice != null}">
                    <input type="hidden" name="id" value="${invoice.getId()}" />
                </c:if>
                <tr>
                    <th>Product ID: </th>
                    <td>
                        <input type="number" name="product_id" size="40"
                               value="${invoice.getProduct().getId()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Seller ID: </th>
                    <td>
                        <input type="number" name="seller_id" size="40"
                               value="${invoice.getSeller().getId()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Buyer ID: </th>
                    <td>
                        <input type="number" name="buyer_id" size="40"
                               value="${invoice.getBuyer().getId()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Date: </th>
                    <td>
                        <input type="date" name="date" size="20"
                               value="${invoice.getDate()}"
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
