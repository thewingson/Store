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
    <title>Products</title>
</head>
<body>

<h2>Create Product</h2>

<form action="/products" method="POST">
    Name: <input type="text" name="name">
    <br/>
    Price: <input type="number" name="price"/>
    <br/>
    Quantity: <input type="number" name="quantity"/>
    <br/>
    Category ID: <input type="number" name="categoryId"/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>

