<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/21/2019
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Category</title>
</head>
<body>

<h2>${category.name}</h2>

<h3><a href="/categories/update/${category.id}">Edit</a> | <a href="/categories/delete/${category.id}">Delete</a></h3>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty category.products}">
        <c:forEach var="product" items="${category.products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>
                    <a href="/products/update/${product.id}">Edit</a> | <a href="/products/delete/${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
