<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 12/3/2019
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h2>Sign Up</h2>

<form action="/auth/signUp" method="POST">
    Username: <input type="text" name="username" /><br>
    Password: <input type="password" name="password" /><br>
    Confirm Password: <input type="password" name="confirmPassword" /><br>
    First Name: <input type="text" name="firstName" /><br>
    Last Name: <input type="text" name="lastName" /><br>
    Email: <input type="text" name="email" /><br>
    Phone: <input type="text" name="phone" /><br>
    <input type="submit" value="Sign Up"/>
</form>
</body>
</html>
