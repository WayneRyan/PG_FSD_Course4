<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update employee salary</title>
</head>
<body>
<h2>This guy is gona get a raise Woot Woot.</h2>
<form action="updateSalary" method="post">
    <label>ID: </label><input type="number" name="employee_id"><br>
    <label>Salary: </label><input type="numer" name="employee_salary"><br>
    <input type="submit" name="submit"><input type="reset" name="reset">
</form>
</body>
</html>