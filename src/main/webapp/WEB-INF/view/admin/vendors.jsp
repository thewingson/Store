<%--
  Created by IntelliJ IDEA.
  User: Almat
  Date: 19.12.2019
  Time: 15:53
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

    <title>Vendors</title>
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

<div class="mt-md-2"/>

<div class="container-fluid mt-md-5" style="background-color: lavender">
    <div class="row">
        <div class="col-md-3">
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">Models</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><a class="nav-link" href="/admin/products">Products</a></td>
                </tr>
                <tr>
                    <td><a class="nav-link" href="/admin/categories">Categories</a></td>
                </tr>
                <tr>
                    <td><a class="nav-link" href="/admin/users">Users</a></td>
                </tr>
                <tr>
                    <td><a class="nav-link" href="/admin/vendors">Vendors</a></td>
                </tr>
                <tr>
                    <td><a class="nav-link" href="/admin/orders">Orders</a></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="col-md-9">

            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <c:if test="${not empty vendors}">
                    <tbody>
                    <c:forEach var="vendor" items="${vendors}">
                        <tr>
                            <th scope="row">${vendor.id}</th>
                            <td>${vendor.name}</td>
                            <td>
                                <a class="text-danger" href="/products/delete/${product.id}"><i class="fa fa-trash-alt"></i></a> <a class="text-info" href="/products/update/${product.id}"><i class="fa fa-edit"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </c:if>
            </table>

        </div>
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


