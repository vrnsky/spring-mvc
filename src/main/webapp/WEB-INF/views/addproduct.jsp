<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class=container">
            <h1>Products</h1>
            <p>Add products</p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form:form method="post" modelAttribute="product" class="form-horizontal">
                <fieldset>
                    <legend>Adding a new product to the web shop</legend>
                    <div class="form-group">
                        <label for="productId">Product ID: </label>
                        <form:input path="productId" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="name">Name: </label>
                        <form:input path="name" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <form:textarea path="description" rows="8" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="unit_price">Unit price: </label>
                        <form:input path="unitPrice" id="unit_price" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="manufacturer">Manufacturer: </label>
                        <form:input path="manufacturer" id="manufacturer" name="manufacturer" class="form-control"
                                    type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="category">Category: </label>
                        <form:input path="category" id="category" name="category" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="condition">Condition: </label>
                        <form:radiobutton path="condition" name="condition" id="new" value="New"/> New
                        <form:radiobutton path="condition" name="condition" id="old" value="Old"/> Old
                        <form:radiobutton path="condition" name="condition" id="refurbished" value="Refurbished"/>
                        Refurbished
                    </div>
                    <div class="form-group">
                        <label for="unitsInStock">Units in stock: </label>
                        <form:input path="unitsInStock" name="unitsInStock" id="unitsInStock" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="unitsInOrder">Units in order: </label>
                        <form:input path="unitsInOrder" name="unitsInOrder" id="unitsInOrder" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="discounted">Discounted: </label>
                        <form:checkbox path="discounted" name="discounted" id="discounted"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-default btn-primary" value = "Add new product"/>
                    </div>
                </fieldset>
            </form:form>
        </div>
        <div class="col-md-4"></div>
    </div>

</section>
</body>
</html>
