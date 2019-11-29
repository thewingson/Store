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
    <title>Edit User</title>
</head>
<body>

<h2>Edit User</h2>
<c:if test="${not empty user}">
    <form action="/users/update" method="POST">
        <input type="hidden" name="id" value="${user.id}"/>
        Name: <input type="text" name="name" placeholder="${user.username}">
        Firstname: <input type="text" name="firstname" placeholder="${user.firstName}"/><br>
        Lastname: <input type="text" name="lastname" placeholder="${user.lastName}"/><br>
        Email: <input type="text" name="email" placeholder="${user.email}"/><br>
        Password: <input type="text" name="password" placeholder="${user.password}"/><br>
        Phone: <input type="text" name="phone" placeholder="${user.phone}"/><br>
        <input type="submit" value="Submit"/>
    </form>
</c:if>

</body>
</html>
