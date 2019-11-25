<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/21/2019
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Categories</title>
</head>
<body>


<ul>
    <li><a href="/products">Products</a></li>
    <li><a href="/categories">Categories</a></li>
    <li><a href="/orders">Orders</a></li>
    <li><a href="/vendors">Vendors</a></li>
    <li><a href="/users">Users</a></li>
</ul>

<h2>Categories</h2>

<a href="/categories/create">Add</a>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:if test="${not empty categories}">
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td><a href="/categories/${category.id}">${category.name}</a> | <a href="/categories/${category.id}/products"> See Products </a></td>
                <td>
                    <a href="/categories/update/${category.id}">Edit</a>
                    <a href="/categories/delete/${category.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>

