<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/27/2019
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Cart</title>
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

<h2>Cart</h2>

<table>
    <tr>
        <th>Product ID</th>
        <th>Quantity</th>
    </tr>
    <c:if test="${not empty sessionScope.cart}">
        <c:forEach var="item" items="${sessionScope.cart}">
            <tr>
                <td>${item.key}</td>
                <td>${item.value}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<br>

<c:if test="${not empty sessionScope.cart}">
    <a href="/orders/purchase">Purchase</a>
</c:if>

</body>
</html>
