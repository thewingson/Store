<%--
  Created by IntelliJ IDEA.
  User: Almat_Rakhmetolla
  Date: 11/27/2019
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="icon" href="/docs/4.1/assets/img/favicons/favicon.ico">

    <title>Blog Template for Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/blog/">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <link href="blog.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Cloth Shop</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/products">Products</a>
        <a class="p-2 text-dark dropdown-toggle" id="categoryDropdownMenu" data-toggle="dropdown" aria-haspopup="true"
           aria-expanded="false">Categories</a>
        <div class="dropdown-menu" aria-labelledby="categoryDropdownMenu">
            <c:if test="${not empty categories}">
                <c:forEach var="category" items="${categories}">
                    <a class="dropdown-item" type="button" href="/categories/${category.id}">${category.name}</a>
                </c:forEach>
            </c:if>
        </div>
        <a class="p-2 text-dark" href="/orders">Orders</a>

        <c:if test="${null == sessionScope.get(username)}">
            <a class="p-2 text-dark" href="/auth/signIn">Sign In</a>
        </c:if>
    </nav>
    <a class="btn btn-outline-primary" href="/auth/signUp">Sign up</a>
</div>

<main role="main" class="container d-flex justify-content-center">

    <div class="my-3 p-3 bg-white rounded shadow-sm col-md-8  ">
        <h6 class="border-bottom border-gray pb-2 mb-0">Your cart</h6>
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <div class="media text-muted pt-3">
                    <img data-src="#"
                         alt="" class="mr-2 rounded">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        <strong class="d-block text-gray-dark">${product.key.name} ${product.key.vendor.name}</strong> ${product.value}
                    </p>
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                         <strong class="d-block text-gray-dark"> <a class="btn-danger" href="/orders/addToCart/${product.id}">-</a> ${product.value} <a class="btn-success" href="/orders/addToCart/${product.id}">+</a> </strong>
                    </p>
                </div>
            </c:forEach>
        </c:if>
        <small class="d-block text-right mt-3">
            <a href="/orders/purchase">Purchase all</a>
        </small>
    </div>
</main>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<script src="../../assets/js/vendor/holder.min.js"></script>
<script src="offcanvas.js"></script>
</body>

</html>
