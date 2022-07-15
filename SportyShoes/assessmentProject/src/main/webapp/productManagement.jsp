<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sporty Shoes Product Management</title>
</head>
<body>
<h2>Welcome to Sporty Shoes Product Management</h2>
<form action="selectProduct" method="get">
    <select>
        <core:forEach items="${sessionScope.listOfProducts}" var="product">
            <option value="${product}"
        </core:forEach>
    </select>
</form>

</select>
</body>
</html>