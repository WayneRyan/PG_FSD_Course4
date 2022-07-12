<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display All Employees</title>
</head>
<body>
<h2>These are the dudes you didn't fire</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Salary</th>
    </tr>
    <core:forEach items="${requestScope.allEmployees}" var="emp">
        <tr>
            <td><core:out value="${emp.id}"></core:out></td>
            <td><core:out value="${emp.name}"></core:out></td>
            <td><core:out value="${emp.salary}"></core:out></td>
        </tr>
    </core:forEach>
</table>
</body>
</html>