<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/03/2021
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwich Condiment</h3>
<form method="post" action="/save">
    <input type="checkbox" id="vehicle1" name="condiments" value="Tomato">
    <label for="vehicle1">Tomato</label><br>
    <input type="checkbox" id="vehicle2" name="condiments" value="Sprouts">
    <label for="vehicle2">Sprouts</label><br>
    <input type="checkbox" id="vehicle3" name="condiments" value="Lettuce">
    <label for="vehicle3">Lettuce</label><br>
    <input type="checkbox" id="vehicle4" name="condiments" value="Mustard">
    <label for="vehicle4">Mustard</label><br><br>
    <input type="submit"  value="Save">
</form>
</body>
</html>
