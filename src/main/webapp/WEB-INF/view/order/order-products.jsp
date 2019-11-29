<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/28/2019
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order</title>
</head>
<body>

<h2>${order.id}</h2>

<h3><a href="/categories/update/${order.id}">Edit</a> | <a href="/categories/delete/${order.id}">Delete</a></h3>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Vendor</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty order}">
        <c:forEach var="item" items="${order.items}">
            <tr>
                <td>${item.id}</td>
                <td>${item.product.name}</td>
                <td>${item.product.vendor.name}</td>
                <td><a href="/orders//${order.id}/items/${item.id}/decrease">-</a> ${item.quantity} <a href="/orders//${order.id}/items/${item.id}/increase">+</a></td>
                <td>
                    <a href="/orders/${order.id}/items/${item.product.id}">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
