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

<a href="/category/create">Add</a>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category</th>
    </tr>
    <c:if test="${not empty products}">
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.category.name}</td>
                <td>
                    <a href="/products/update/${product.id}">Edit</a>
                    <a href="/products/delete/${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>