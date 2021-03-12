<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/03/2021
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="number" name="first">
    <input type="number" name="second">
    <select name="calculation">
        <option>Select Calculation</option>
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
    </select>
    <input type="submit" value="Calculation">
</form>
</body>
</html>
