<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09/03/2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div align="center">
    <table border="" cellpadding="10">
        <label>
            Customer Update
        </label>

        <form:form method="post" modelAttribute="update">

            <form:hidden path="id"></form:hidden>
            <tr>
                <th><label>Name:</label></th>
                <td><form:input path="name"></form:input></td>
            </tr>
            <tr>
                <th><label>Email:</label></th>
                <td><form:input path="email"></form:input></td>
            </tr>
            <tr>
                <th><label>Address:</label></th>
                <td><form:input path="address"></form:input></td>
            </tr>
            <tr>
                <th><label></label></th>
                <td><input type="submit" value="Update"></td>
            </tr>

        </form:form>
    </table>
</div>
</body>
</html>
