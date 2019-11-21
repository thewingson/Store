<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/20/2019
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Product</title>
</head>
<body>

<h2>Product</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category ID</th>
    </tr>
    <c:if test="${not empty product}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>${product.categoryId}</td>
                <td>
                    <a href="/products/update/${product.id}">Edit</a>
                    <a href="/products/delete/${product.id}">Delete</a>
                </td>
            </tr>
    </c:if>
</table>

</body>
</html>
