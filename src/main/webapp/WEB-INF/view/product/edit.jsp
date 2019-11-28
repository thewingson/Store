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
    <title>Edit Product</title>
</head>
<body>

<h2>Edit Product</h2>
<c:if test="${not empty product}">
    <form action="/products/update" method="POST">
        <input type="hidden" name="id" value="${product.id}"/>
        Name: <input type="text" name="name" placeholder="${product.name}"><br/>
        Price: <input type="number" name="price" placeholder="${product.price}"/><br/>
        Quantity: <input type="number" name="quantity" placeholder="${product.quantity}"/><br/>
        Category :
        <select name="categoryId">
            <c:if test="${not empty categories}">
                <option selected="selected" value="${product.category.id}">${product.category.name}</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </c:if>
        </select><br>
        <input type="submit" value="Submit"/>
    </form>
</c:if>

</body>
</html>
