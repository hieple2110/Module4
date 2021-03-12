<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/03/2021
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:choose>
    <c:when test="${b==0}">
        <h4>${mess}</h4>
    </c:when>
    <c:when test="${b!=0}">
        <h4>A: ${a}</h4>
        <h4>Calculator: ${calculator}</h4>
        <h4>B: ${b}</h4>
        <h4>Result: ${result}</h4>
    </c:when>
</c:choose>
</body>
</html>
