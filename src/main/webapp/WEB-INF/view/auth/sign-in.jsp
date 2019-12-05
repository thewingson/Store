<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 12/3/2019
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h2>Sign In</h2>

<%--<c:url value="/authentication_check" var="loginUrl" />--%>
<%--<form action="/auth/signIn" method="POST">--%>
<form action="/authentication_check" method="POST">
    Username: <input type="text" name="username" /><br>
    Password: <input type="password" name="password" /><br>
    <input type="submit" value="Sign In"/>
</form>

        <%--<input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="colibri">--%>
        <%--<input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">--%>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>--%>

</body>
</html>
