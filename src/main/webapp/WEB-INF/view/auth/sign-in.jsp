<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 12/3/2019
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<head>--%>
<%--<link rel="icon" href="/docs/4.1/assets/img/favicons/favicon.ico">--%>
<%--<title>Sign In</title>--%>
<%--<link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/sign-in/">--%>

<%--<!-- Bootstrap core CSS -->--%>
<%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"--%>
<%--integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>
<%--</head>--%>
<%--<body class="text-center">--%>

<%--<div class="row d-flex justify-content-center">--%>
<%--<div class="col-md-3 ">--%>
<%--<form class="form-signin" action="/sign-in" method="post">--%>
<%--<img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
<%--<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>--%>
<%--<label for="username" class="sr-only">Username</label>--%>
<%--<input type="text" id="username" class="form-control" name="username" placeholder="Username or email address" required autofocus>--%>
<%--<label for="inputPassword" class="sr-only">Password</label>--%>
<%--<input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>--%>
<%--<div class="checkbox mb-3">--%>
<%--<label>--%>
<%--<input type="checkbox" name="rememberMe" value="remember-me"> Remember me--%>
<%--</label>--%>
<%--</div>--%>
<%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
<%--<p class="mt-5 mb-3 text-muted">&copy; Almat Rakhmetolla 2019</p>--%>
<%--</form>--%>
<%--</div>--%>
<%--</div>--%>

<%--</body>--%>

<head>
    <title>Sign In</title>
</head>

<body class="text-center">

<h1>Sign in form</h1>
<form action="/sign-in" method="POST">
    <div>
        Username
        <input type="text" name="username">
        <%--<p>Username required</p>--%>
    </div>
    <div>
        Password
        <input type="password" name="password">
        <%--<p>Password required</p>--%>
    </div>
    <c:if test="${message != null}">
        <p>${message}</p>
    </c:if>
    <button type="submit">Submit</button>
</form>

</body>

</html>
