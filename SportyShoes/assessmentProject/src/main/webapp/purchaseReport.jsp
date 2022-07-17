<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sporty Shoes Purchase Report</title>
</head>
<body>
<a href="homeScreen">home</a>
<h2>Welcome to Sporty Shoes Purchase Report</h2>
<form action="purchaseReport" method="post">
    <label>Start Date: </label><input type="date" name="startDate"/><br/>
    <label>End Date: </label><input type="date" name="endDate"/><br/>
    <select name="category">

    </select><br/>
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
</table>
<h2>Summary Statistics</h2>
</body>
</html>