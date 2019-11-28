<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/28/2019
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create User</title>
</head>
<body>

<h2>Create User</h2>

<form action="/users" method="POST">
    Username: <input type="text" name="username" /><br>
    Firstname: <input type="text" name="firstname" /><br>
    Lastname: <input type="text" name="lastname" /><br>
    Email: <input type="text" name="email" /><br>
    Password: <input type="text" name="password" /><br>
    Phone: <input type="text" name="phone" /><br>
    <input type="submit" value="Submit" /><br>
</form>

</body>
</html>
