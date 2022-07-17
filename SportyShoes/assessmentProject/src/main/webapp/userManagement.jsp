<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sporty Shoes User Management</title>
</head>
<body>
<a href="homeScreen">home</a>
<h2>Welcome to Sporty Shoes User Management</h2>
<form action="searchUsers" method="post">
    <label>Filter by name: </label><input type="text" name="filterText"><input type="submit">
</form>
<table>
    <tr>
        <th>User Name</th>
        <th>Is Admin</th>
    </tr>
    <core:forEach items="${sessionScope.listOfUsers}" var="user">
        <tr>
            <td><core:out value="${user.user_name}"></core:out></td>
            <td><core:out value="${user.is_admin}"></core:out></td>
        </tr>
    </core:forEach>
</table>
</body>
</html>