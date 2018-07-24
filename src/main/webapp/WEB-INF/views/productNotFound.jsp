<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product not found</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<section class="jumbotron">
    <div class="container">
        <h1>Product not found:(</h1>
        <p>Sorry but product with given id is not exist</p>
    </div>
</section>
<div class="container">
    <h1 class="alert alert-danger">There is no product with product id = ${invalidProduct}</h1>
</div>
<section>
    <div class="container">
        <p>${url}</p>
        <p>${exception}</p>
        <a href="<spring:url value="/market/products" />"
           class="btn btn-primary"><span class="glyphicon-hand-left glyphicon"></span> products
        </a>
    </div>
</section>
</body>
</html>
