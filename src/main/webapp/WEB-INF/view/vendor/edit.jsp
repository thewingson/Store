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
    <title>Edit Vendor</title>
</head>
<body>

<h2>Edit Vendor</h2>
<c:if test="${not empty vendor}">
    <form action="/vendors/update" method="POST">
        <input type="hidden" name="id" value="${vendor.id}"/>
        Name: <input type="text" name="name" placeholder="${vendor.name}">
        <input type="submit" value="Submit"/>
    </form>
</c:if>

</body>
</html>
