<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 12/3/2019
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h2>Sign In</h2>

<form action="/auth/signIn" method="POST">
    Username: <input type="text" name="username" /><br>
    Password: <input type="password" name="password" /><br>
    <input type="submit" value="Sign In"/>
</form>
</body>
</html>
