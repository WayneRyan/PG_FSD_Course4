<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sporty Shoes Admin Login</title>
</head>
<body>
<h2>Welcome to Sporty Shoes Administrator Login</h2>
<%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
<form action="checkCredentials" method="post">
    <label>User Name: </label><input type="text" name="user_name"><br>
    <label>Password: </label><input type="password" name="password"><br>
    <input type="submit" name="submit"><input type="reset" name="reset">
</form>
</body>
</html>