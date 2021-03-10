<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09/03/2021
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<div align="center">
    <table  cellpadding="10">
        <label>
            Customer Add
        </label>

        <form:form method="post" action="/add" modelAttribute="customer">

            <tr>
                <th><label>Name:</label></th>
                <td><form:input path="name"></form:input></td>
            </tr>

            <tr>
                <th><label></label></th>
                <td><input type="submit" value="Add"></td>
            </tr>
        </form:form>
    </table>
</div>
</body>
</html>
