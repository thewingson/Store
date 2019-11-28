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
    <title>Create Vendor</title>
</head>
<body>

<h2>Create Vendor</h2>

<form action="/vendors" method="POST">
    Name: <input type="text" name="name" /><br>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>
