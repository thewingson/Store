<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/20/2019
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Create Product</title>
</head>
<body>

<h2>Create Product</h2>

<form action="/products" method="POST">
    Name: <input type="text" name="name" /><br/>
    Price: <input type="number" name="price"/><br/>
    Quantity: <input type="number" name="quantity"/><br/>
    Category:
    <select name="categoryId">
        <c:if test="${not empty categories}">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </c:if>
    </select><br/>
    Vendor:
    <select name="vendorId">
        <c:if test="${not empty vendors}">
            <c:forEach var="vendor" items="${vendors}">
                <option value="${vendor.id}">${vendor.name}</option>
            </c:forEach>
        </c:if>
    </select><br/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>

