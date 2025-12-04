
<%--
  Created by IntelliJ IDEA.
  Buyer: DenysH
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
    <h1>Buyer Management</h1>
    <h2>
        <a href="new">Add New Buyer</a>
        &nbsp;
        <a href="idDel">Delete Buyer</a>
        &nbsp;
        <a href="idEdit">Edit Buyer</a>
        &nbsp;
        <a href="list">List All Buyers</a>
        &nbsp;
        <a href="/PWT_Lab6_war_exploded/index.jsp">Return to index</a>
    </h2>
</center>
<div align="center">

    <form action="${buyer != null ? 'update' : 'insert'}" method="post">

            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        ${buyer != null ? "Edit Buyer" : "Add New Buyer"}
                    </h2>
                </caption>
                <c:if test="${buyer != null}">
                    <input type="hidden" name="id" value="${buyer.getId()}" />
                </c:if>
                <tr>
                    <th>First Name: </th>
                    <td>
                        <input type="text" name="firstName" size="45"
                               value="${buyer.getFirstName()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Last Name: </th>
                    <td>
                        <input type="text" name="lastName" size="45"
                               value="${buyer.getLastName()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email: </th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="${buyer.getEmail()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Phone Number: </th>
                    <td>
                        <input type="text" name="phoneNumber" size="45"
                               value="${buyer.getPhoneNumber()}"
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
