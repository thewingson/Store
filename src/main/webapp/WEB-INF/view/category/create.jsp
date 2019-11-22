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
    <title>Category</title>
</head>
<body>

<h2>Create Category</h2>

<form action="/categories" method="POST">
    Name: <input type="text" name="name">
    <input type="submit" value="Submit"/>
</form>

</body>
</html>

