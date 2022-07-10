<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body class="center">
<h2>Login</h2>
<form action="checkUser" method="post">
    <label>Email</label><input type="email" name="email"><br>
    <label>Password</label><input type="password" name="password"><br>
    <input type="submit" name="submit"> <input type="reset" name="reset">
</form>
</body>