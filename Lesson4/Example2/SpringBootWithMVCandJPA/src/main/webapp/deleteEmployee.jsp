<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Employee Record</title>
</head>
<body>
<h2>Somebody got canned</h2>
<form action="deleteEmployee" method="post">
    <label>ID: </label><input type="number" name="employee_id"><br>
    <input type="submit" name="submit"><input type="reset" name="reset">
</form>
</body>
</html>