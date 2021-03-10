<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09/03/2021
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<div align="center">
    <a href="/add"><h3>Add</h3></a>
    <table border="1" cellpadding="10">
        <h3>Customer List</h3>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.email}</td>
                <td>${c.address}</td>
                <td>
                    <a href="/update?id=${c.id}">edit</a>

                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
