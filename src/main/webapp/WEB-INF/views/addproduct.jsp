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
<section class="jumbotron">
    <div class="container">
        <h1>Products</h1>
        <p>Add products</p>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form:form method="post" modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">
                <fieldset>
                    <legend>Adding a new product to the web shop</legend>
                    <div class="form-group">
                        <label for="productId"><spring:message code="addProduct.form.productId.label"/></label>
                        <form:input path="productId" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="name"><spring:message code="addProduct.form.productName.label"/></label>
                        <form:input path="name" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="description"><spring:message code="addProduct.form.productDescription.label" /></label>
                        <form:textarea path="description" rows="8" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="unit_price"><spring:message code="addProduct.form.productUnitPrice.label"/></label>
                        <form:input path="unitPrice" id="unit_price" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="manufacturer"><spring:message code="addProduct.form.productManufacturer.label"/></label>
                        <form:input path="manufacturer" id="manufacturer" name="manufacturer" class="form-control"
                                    type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="category"><spring:message code="addProduct.form.productCategory.label"/></label>
                        <form:input path="category" id="category" name="category" class="form-control" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="condition"><spring:message code="addProduct.form.productCondition.label"/></label>
                        <form:radiobutton path="condition" name="condition" id="new" value="New"/> New
                        <form:radiobutton path="condition" name="condition" id="old" value="Old"/> Old
                        <form:radiobutton path="condition" name="condition" id="refurbished" value="Refurbished"/>
                        Refurbished
                    </div>
                    <div class="form-group">
                        <label for="unitsInStock"><spring:message code="addProduct.form.unitsInStock.label"/></label>
                        <form:input path="unitsInStock" name="unitsInStock" id="unitsInStock" type="text"/>
                    </div>
                    <div class="form-group">
                        <label for="productImage"><spring:message code="addProduct.form.productImage.label"/></label>
                        <form:input path="image" type="file" class="form-control" id="productImage" name="productImage"/>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-default btn-primary" value="Add new product"/>
                    </div>
                </fieldset>
            </form:form>
        </div>
        <div class="col-md-4"></div>
    </div>

</section>
</body>
</html>
