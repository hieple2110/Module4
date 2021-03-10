<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<div align="center">
    <table cellpadding="10">
        <label>
            Convert Money
        </label>

        <form method="post" action="/dictionary">
            <tr>
                <th><label>Vocabulary:</label></th>
                <td><input  name="name" type="text" placeholder="Enter the word"/></td>
            </tr>
            <tr>
                <th><label></label></th>
                <td><input type="submit" value="Dictionary"></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
