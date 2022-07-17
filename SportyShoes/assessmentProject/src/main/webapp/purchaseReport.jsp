<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sporty Shoes Purchase Report</title>
</head>
<body>
<a href="homeScreen">home</a>
<h2>Welcome to Sporty Shoes Purchase Report</h2>
<form action="purchaseReport" method="post">
    <label>Start Date: </label><input type="date" name="startDate" required/><br/>
    <label>End Date: </label><input type="date" name="endDate" required/><br/>
    <select name="selectedCategory">
        <core:forEach items="${sessionScope.listOfCategories}" var="category">
            <option value="${category.id}" ${category.id == sessionScope.selectedProduct.category.id ? 'selected' : ''} >${category.name}</option>
        </core:forEach>
    </select>
    <input type="submit" name="submit"><input type="reset" name="reset">
</form>
<h2>Purchase Table</h2>
<table>
    <tr>
        <td>Purchase Date</td>
        <td>Product</td>
        <td>Price</td>
        <td>User</td>
    </tr>
    <core:forEach items="${sessionScope.filteredPurchases}" var="purchase">
        <tr>
            <td><core:out value="${purchase.date}"/></td>
            <td><core:out value="${purchase.product.name}"/></td>
            <td><fmt:formatNumber value="${purchase.product.price * 0.01}" type="currency"/></td>
            <td><core:out value="${purchase.user.user_name}"/></td>
        </tr>
    </core:forEach>
</table>
<h2>Summary Statistics</h2>
</body>
</html>