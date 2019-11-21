<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/20/2019
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Products</title>
</head>
<body>

<h2>Edit Product</h2>
<c:if test="${not empty product}">
    <form action="/products/update" method="POST">
        <input type="hidden" name="id" value="${product.id}"/>
        Name: <input type="text" name="name" placeholder="${product.name}">
        <br/>
        Price: <input type="number" name="price" placeholder="${product.price}"/>
        <br/>
        Quantity: <input type="number" name="quantity" placeholder="${product.quantity}"/>
        <br/>
        Category ID: <input type="number" name="categoryId" placeholder="${product.categoryId}"/>
        <input type="submit" value="Submit"/>
    </form>
</c:if>

</body>
</html>
