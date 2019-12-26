<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/25/2019
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Orders</title>
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

<h2>Orders</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Created At</th>
        <th>Ship Date</th>
        <th>Status</th>
        <th>Complete</th>
        <th>Username</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty orders}">
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.createdAt}</td>
                <td>${order.shipDate}</td>
                <td>${order.status}</td>
                <td>${order.complete}</td>
                <td>${order.user.username}</td>
                <td>
                    <a href="/orders/${order.id}">See Items</a> |
                    <a href="/orders/update/${order.id}">Edit</a> |
                    <a href="/orders/delete/${order.id}">Delete</a> |
                    <a href="/orders/approve/${order.id}">Approve</a> |
                    <a href="/orders/delivered/${order.id}">Delivered</a> |
                    <a href="/orders/delete/${order.id}">Cancel</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<spring:hasBindErrors name="order">
    <p>has errors</p>
    <c:forEach var="error" items="${errors.allErrors}">
        <b><spring:message message="${error}" /></b>
        <br />
    </c:forEach>
</spring:hasBindErrors>

</body>
</html>
