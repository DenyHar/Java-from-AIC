
<%--
  Created by IntelliJ IDEA.
  Notepad: DenysH
  Date: 29.11.2025
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Notepad Management Application</title>
</head>
<body style="background-color: #d9d3f5;">
<center>
    <h1>Notepad Management</h1>
    <h2>
        <a href="new">Add New Notepad</a>
        &nbsp;
        <a href="idDel">Delete Notepad</a>
        &nbsp;
        <a href="idEdit">Edit Notepad</a>
        &nbsp;
        <a href="list">List All Notepads</a>

    </h2>
</center>
<div align="center">

    <form action="${notepad != null ? 'update' : 'insert'}" method="post">

            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        ${notepad != null ? "Edit Notepad" : "Add New Notepad"}
                    </h2>
                </caption>
                <c:if test="${notepad != null}">
                    <input type="hidden" name="id" value="${notepad.getId()}" />
                </c:if>
                <tr>
                    <th>Notepad Publisher: </th>
                    <td>
                        <input type="text" name="publisher" size="45"
                               value="${notepad.getPublisher()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Notepad Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="${notepad.getName()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Notepad Pages: </th>
                    <td>
                        <input type="number" name="pages" size="45"
                               value="${notepad.getPages()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Notepad Cover Type: </th>
                    <td>
                        <select name="cover">
                            <option>HARD</option>
                            <option>SOFT</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Country: </th>
                    <td>
                        <input type="text" name="country" size="15"
                               value="${notepad.getCountry()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Circulation: </th>
                    <td>
                        <input type="number" name="circulation" size="15"
                               value="${notepad.getCirculation()}"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Notepad Page Type: </th>
                    <td>
                        <select name="page">
                            <option>BLANK</option>
                            <option>LINE</option>
                            <option>CELL</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
