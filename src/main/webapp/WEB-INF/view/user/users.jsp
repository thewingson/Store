<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/28/2019
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>


<ul>
    <li><a href="/products">Products</a></li>
    <li><a href="/categories">Categories</a></li>
    <li><a href="/orders">Orders</a></li>
    <li><a href="/vendors">Vendors</a></li>
    <li><a href="/users">Users</a></li>
    <li><a href="/orders/cart">Cart</a></li>
</ul>

<h2>Users</h2>

<a href="/users/create">Add</a>

<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
        <th>Password</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty users}">
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.phone}</td>
                <td>
                    <a href="/users/update/${user.id}">Edit</a> | <a href="/users/delete/${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
