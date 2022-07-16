<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="core"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />
<!DOCTYPE html>
<html>
<head>
    <title>Sporty Shoes Product Management</title>
</head>
<body>
<h2>Welcome to Sporty Shoes Product Management</h2>
<form action="selectProduct" method="get">
    <select name="selectedProduct">
        <core:forEach items="${sessionScope.listOfProducts}" var="product">
            <option value="${product.id}" ${product.id == sessionScope.selectedProduct.id ? 'selected' : ''}>${product.name}</option>
        </core:forEach>
    </select>
    <input type="submit" value="submit">
</form>
<core:if test="${!empty sessionScope.selectedProduct}">
    <h2>Product Details</h2>
    <ul>
        <li>Description: <core:out value="${sessionScope.selectedProduct.description}"/></li>
        <li>Category: <core:out value="${sessionScope.selectedProduct.category.name}"/></li>
        <li>Price: <fmt:formatNumber value="${sessionScope.selectedProduct.price * 0.01}" type="currency"/></li>
    </ul>
    <h2>Change Category</h2>
    <form action="assignCategory" method="post">
        <input type="hidden" name="selectedProduct" value="${sessionScope.selectedProduct.id}">
        <select name="selectedCategory">
            <core:forEach items="${sessionScope.listOfCategories}" var="category">
                <option value="${category.id}" ${category.id == sessionScope.selectedProduct.category.id ? 'selected' : ''} >${category.name}</option>
            </core:forEach>
        </select>
        <input type="submit">
    </form>
</core:if>

</select>
</body>
</html>