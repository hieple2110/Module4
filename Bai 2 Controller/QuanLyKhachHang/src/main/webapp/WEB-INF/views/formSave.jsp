<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 12/03/2021
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form Save</title>
</head>
<body>
<div align="center">
    <h4>Form Save Customer</h4>
    <table cellpadding="10">
        <form:form method="post" action="/saveCustomer" modelAttribute="customer">
            <tr>
                <th><label>Id</label></th>
                <th><form:input path="id"/></th>
            </tr>
            <tr>
                <th><label>Name</label></th>
                <th><form:input path="name"/></th>
            </tr>
            <tr>
                <th><label>Email</label></th>
                <th><form:input path="email"/></th>
            </tr>
            <tr>
                <th><label>Address</label></th>
                <th><form:input path="address"/></th>
            </tr>
            <tr>
                <th><label></label></th>
                <th><input type="submit" value="Save"></th>
            </tr>
        </form:form>
    </table>
</div>
</body>
</html>
