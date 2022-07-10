<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store an employee object</title>
</head>
<body>
<h2>Can we store an employee now?</h2>
<form action="storeEmployee" method="post">
    <label>ID: </label><input type="number" name="employee_id"><br>
    <label>Name: </label><input type="text" name="employee_name"><br>
    <label>Salary: </label><input type="numer" name="employee_salary"><br>
    <input type="submit" name="submit"><input type="reset" name="reset">
</form>
</body>
</html>