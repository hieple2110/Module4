<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/03/2021
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>${message}</h5>
<h5>Validate Email</h5>
<form action="/validate" method="post">
    <input type="email" name="email" placeholder="enter email">
    <input type="submit" value="Validate Email">
</form>
</body>
</html>
