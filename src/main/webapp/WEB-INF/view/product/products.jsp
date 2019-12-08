<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/18/2019
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Products</title>
    <%--    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Company name</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/products">Products</a>
        <a class="p-2 text-dark" href="/categories">Categories</a>
        <a class="p-2 text-dark" href="/orders">Orders</a>
        <a class="p-2 text-dark" href="/vendors">Vendors</a>
        <a class="p-2 text-dark" href="/users">Users</a>

        <a class="p-2 text-dark" href="/login">Sign In</a>
    </nav>
    <a class="btn btn-outline-primary" href="#">Sign up</a>
</div>

<div class="container-fluid">
    <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>Cloth Shop</h2>
        <p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group
            has a validation state that can be triggered by attempting to submit the form without completing it.</p>
    </div>

    <div class="row container-fluid">
        <div class="col-md-3 order-md-1 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Filter</span>
            </h4>
            <ul class="list-group mb-3">
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Product name</h6>
                        <small class="text-muted">Brief description</small>
                    </div>
                    <span class="text-muted">$12</span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Second product</h6>
                        <small class="text-muted">Brief description</small>
                    </div>
                    <span class="text-muted">$8</span>
                </li>
                <li class="list-group-item d-flex justify-content-between lh-condensed">
                    <div>
                        <h6 class="my-0">Third item</h6>
                        <small class="text-muted">Brief description</small>
                    </div>
                    <span class="text-muted">$5</span>
                </li>
                <li class="list-group-item d-flex justify-content-between bg-light">
                    <div class="text-success">
                        <h6 class="my-0">Promo code</h6>
                        <small>EXAMPLECODE</small>
                    </div>
                    <span class="text-success">-$5</span>
                </li>
                <li class="list-group-item d-flex justify-content-between">
                    <span>Total (USD)</span>
                    <strong>$20</strong>
                </li>
            </ul>

            <form class="card p-2">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Promo code">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary">Redeem</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-8 order-md-2">
            <form class="card p-2">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Product name...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary">Search</button>
                    </div>
                </div>
            </form>
            <c:if test="${not empty products}">
                <c:forEach var="product" items="${products}">
                    <div class="card-deck mb-2 text-center">
                        <div class="card mb-2 shadow-sm">
                            <div class="card-header">
                                <h4 class="my-0 font-weight-normal">${product.name}</h4>
                            </div>
                            <div class="card-body">
                                <h1 class="card-title pricing-card-title">$${product.price}</h1>
                                <ul class="list-unstyled mt-3 mb-4">
                                    <li>${product.vendor.name}</li>
                                    <li>${product.category.name}</li>
                                    <li>$Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                                        tempor incididunt ut labore et dolore magna aliqua.
                                    </li>

                                </ul>
                                <button type="button"
                                        class="btn btn-lg btn-block btn-outline-primary"
                                        onclick="location.href='/orders/addToCart/${product.id}'">Add to cart
                                </button>
                                <button type="button"
                                        class="btn btn-lg btn-block btn-outline-primary"
                                        onclick="location.href='/products/${product.id}'">Read more
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        <div class="col-md-1 order-md-3 mb-4">
            <h6 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted"><a class="text-dark" href="/orders/cart">Your cart</a></span>
                <span class="badge badge-secondary badge-pill">3</span>
            </h6>
        </div>
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>

<%--    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
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
