<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 12/26/2019
  Time: 5:24 PM
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

    <title>Profile</title>
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
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownMenuButton" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Categories</a>
                <div class="dropdown-menu bg-dark" aria-labelledby="dropdownMenuButton">
                    <c:if test="${not empty categories}">
                        <c:forEach var="category" items="${categories}">
                            <a class="dropdown-item text-light" href="/categories/${category.id}">${category.name}</a>
                        </c:forEach>
                    </c:if>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/orders">Orders</a>
            </li>
        </ul>
        <span class="navbar-text">
            <sec:authorize access="!isAuthenticated()">
                <button class="btn btn-outline-info my-2 my-sm-0" type="submit" onclick="location.href='/auth/signIn'">Sign In</button>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"
                        onclick="location.href='/auth/signUp'">Sign Up</button>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <form method="post" action="/sign-out">
                    <button class="btn btn-outline-warning my-2 my-sm-0" type="submit"
                            onclick="location.href='/sign-out'">Sign Out</button>
                </form>
            </sec:authorize>
        </span>
    </div>
</nav>

<div class="container-fluid mt-md-5" style="background-color: lavender">
    <div class="row">

        <div class="col-md-3"></div>

        <div class="col-md-6">
            <div class="mt-md-2"/>
            <c:if test="${null != user}">
                <div class="card mb-3">
                    <div class="card-body">

                        <form:form modelAttribute="user" action="/users/edit/${user.id}" method="post">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="firstName">First name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" value="${user.firstName}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="lastName">Last name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" value="${user.lastName}">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" id="username" name="username" value="${user.username}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" value="${user.password}">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="phone">Phone</label>
                                    <input type="number" class="form-control" id="phone" name="phone" value="${user.phone}">
                                </div>
                            </div>
                            <button class="btn btn-success" type="submit">Submit</button>
                        </form:form>

                    </div>
                </div>
            </c:if>
        </div>

        <div class="col-md-3"></div>

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
