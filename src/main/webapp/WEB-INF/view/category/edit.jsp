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
    <title>Edit Category</title>
</head>
<body>

<h2>Edit Category</h2>
<c:if test="${not empty category}">
    <form action="/categories/update" method="POST">
        <input type="hidden" name="id" value="${category.id}"/>
        Name: <input type="text" name="name" placeholder="${category.name}">
        <input type="submit" value="Submit"/>
    </form>
</c:if>

</body>
</html>
