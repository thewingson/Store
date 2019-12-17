<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 12/3/2019
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/WEB-INF/view/style/styles.css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

    <title>Sign In</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Shop Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/products">Home</a>
            </li>
        </ul>
        <span class="navbar-text">
            <sec:authorize access="!isAuthenticated()">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"
                        onclick="location.href='/auth/signUp'">Sign Up</button>
            </sec:authorize>
        </span>
    </div>
</nav>

<div class="container-fluid mt-md-5" style="background-color: lavender">
    <div class="row">

        <div class="col-md-4"></div>

        <div class="col-md-4">
            <div class="mt-md-2"/>


            <div class="card">
                <article class="card-body">
                    <h4 class="card-title text-center mb-4 mt-1">Sign in</h4>
                    <hr>
                    <p>
                        <a href="" class="btn btn-block btn-outline-info"> <i class="fab fa-google"></i> Login via
                            Google</a>
                        <a href="" class="btn btn-block btn-outline-primary"> <i class="fab fa-facebook-f"></i> Login
                            via facebook</a>
                    </p>
                    <hr>
                    <form action="/sign-in" method="post">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                                </div>
                                <input name="username" class="form-control" placeholder="Email or username"
                                       type="text">
                            </div> <!-- input-group.// -->
                        </div> <!-- form-group// -->
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                                </div>
                                <input name="password" class="form-control" placeholder="******" type="password">
                            </div> <!-- input-group.// -->
                        </div> <!-- form-group// -->
                        <c:if test="${message != null}">
                            <div class="checkbox text-danger">
                                <label> ${message} </label>
                            </div>
                            <!-- checkbox .// -->
                        </c:if>
                        <div class="checkbox">
                            <label> <input name="rememberMe" type="checkbox"> Remember me </label>
                        </div> <!-- checkbox .// -->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block"> Sign in</button>
                        </div> <!-- form-group// -->
                        <p class="text-center"><a href="#" class="btn">Forgot password?</a></p>
                    </form>
                </article>
            </div>

        </div>

        <div class="col-md-4"></div>

    </div>
</div>

<div class="mt-md-5"/>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>

