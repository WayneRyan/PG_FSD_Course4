<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 7/3/2022
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login Form with Hardcoding email and password</h2>
<form action="checkUser" method="post">
  <label>Email</label>
  <input type="email" name="email"><br>
  <label>Password</label>
  <input type="password" name="password"><br>
  <input type="submit" name="submit">
  <input type="reset" name="reset">
</form>
${requestScope.msg}
<h2>Login Form with Db</h2>
<form action="signIn" method="post">
  <label>Email</label>
  <input type="email" name="email"><br>
  <label>Password</label>
  <input type="password" name="password"><br>
  <input type="submit" name="submit">
  <input type="reset" name="reset">
</form>
<a href="signUp.jsp">signUp</a>
</body>
</html>
