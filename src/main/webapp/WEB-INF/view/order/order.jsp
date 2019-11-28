<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/28/2019
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Order</title>
</head>
<body>

<h2>${order.id}</h2>

<h3><a href="/orders/update/${order.id}">Edit</a> | <a href="/orders/delete/${order.id}">Delete</a></h3>

<table>
    <tr>
        <th>ID</th>
        <th>Ship Date</th>
        <th>Created At</th>
        <th>Complete</th>
        <th>Status</th>
        <th>Username</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty order}">
            <tr>
                <td>${order.id}</td>
                <td>${order.shipDate}</td>
                <td>${order.createdAt}</td>
                <td>${order.complete}</td>
                <td>${order.status}</td>
                <td>${order.user.userName}</td>
                <td>
                    <a href="/orders/update/${order.id}">Edit</a> | <a href="/orders/delete/${order.id}">Delete</a>
                </td>
            </tr>
    </c:if>
</table>

</body>
</html>

