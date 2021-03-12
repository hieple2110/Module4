<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/03/2021
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h4>List Customer</h4>
    <a href="/saveCustomer"><h4>Add Customer</h4></a>
    <br>
    <table cellpadding="10">
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
            <a href="/updateCustomer?id=${c.id}">Edit</a>
            <a href="/deleteCustomer?id=${c.id}">Delete</a>
        </td>
    </tr>
</c:forEach>

    </table>
</div>
</body>
</html>
