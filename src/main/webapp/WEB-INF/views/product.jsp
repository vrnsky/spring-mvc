<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product.name}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-4">
             <img src="<c:url value="/img/${product.productId}.jpg"></c:url>" alt="image" style="width:100%"/>
        </div>
                <div class="col-md-8">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>
                        <strong>Item Code: </strong><span class="label label-warning">${product.productId}</span>
                    </p>
                    <p>
                        <strong>Manufacturer: </strong><span class="label label-warning">
                        ${product.manufacturer}
                    </span>
                    </p>
                    <p>
                        <strong>Category: </strong> ${product.category}
                    </p>
                    <p>
                        <strong>Available units in stock:</strong> ${product.unitsInStock}
                    </p>
                    <h4>${product.unitPrice} USD </h4>
                    <p>
                        <a href="#" class="btn btn-warning btn-large">
                            <span class="glyphicon-shopping-cart glyphicon"></span>
                            Order Now!
                        </a>
                        <a href="<spring:url value="/market/products" />" class="btn btn-default">
                            <span class="glyphicon-hand-left glyphicon"></span>Back
                        </a>
                        <a href="<c:url value="/manuals/${product.productId}.pdf"></c:url>">
                            <span class="glyphicon glyphicon-book"></span>Manual
                        </a>
                    </p>
                </div>
        </div>
</section>
</body>
</html>
