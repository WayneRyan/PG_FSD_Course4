<%--
  Created by IntelliJ IDEA.
  User: wryan
  Date: 7/9/2022
  Time: 9:29 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<h1>Edit User</h1>
<form action="editUser" method="post" >
    <input type="hidden" name="user_id" value="${requestScope.user.user_id}">
    <label>User ID: </label>${requestScope.user.user_id}<br />
    <label>Name: </label><input type="text" name="name" value="${requestScope.user.name}"><br />
    <label>Password: </label><input type="password" name="password" value="${requestScope.user.password}"><br />
    <input type="submit" name="submit">
</form>
</body>
</html>
