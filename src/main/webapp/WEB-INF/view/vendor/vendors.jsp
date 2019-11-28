<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/28/2019
  Time: 12:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Vendors</title>
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

<h2>Vendors</h2>

<a href="/vendors/create">Add</a>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty vendors}">
        <c:forEach var="vendor" items="${vendors}">
            <tr>
                <td>${vendor.id}</td>
                <td>
                    <a href="/vendors/${vendor.id}">${vendor.name}</a> | <a href="/vendors/${vendor.id}/products"> See Products </a>
                </td>
                <td>
                    <a href="/vendors/update/${vendor.id}">Edit</a> | <a href="/vendors/delete/${vendor.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>


