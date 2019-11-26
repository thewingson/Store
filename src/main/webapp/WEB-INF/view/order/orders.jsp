<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/25/2019
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
</ul>

<h2>Orders</h2>

    <c:if test="${not empty orders}">
        <c:forEach var="order" items="${orders}">
            <mark>${order.id} / ${order.status} / ${order.complete} / ${order.createdAt} / ${order.shipDate}</mark>
            <c:forEach var="item" items="${order.items}">
                <i>${item.product.name}</i> / <i>${item.quantity}</i>
            </c:forEach>
            <br>
        </c:forEach>
    </c:if>

</body>
</html>
