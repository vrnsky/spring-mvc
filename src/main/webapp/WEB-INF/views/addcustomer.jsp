<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Adding a new customer to the web shop</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<section class="jumbotron">
    <div class="container">
        <h1>Add a new</h1>
        <p>Add a new customer to the web shop</p>
    </div>
</section>
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form:form modelAttribute="customer" method="post">
                    <fieldset>
                        <legend>Adding a new customer to the webshop</legend>
                        <div class="form-group">
                            <label for="customerId">Customer ID: </label>
                            <form:input path="id" id="customerId" name="customerId" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label for="name">Name: </label>
                            <form:input path="name" id="name" name="name" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="address">Address: </label>
                            <form:input path="address" id="address" name="address" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label for="orderMakes">Orders makes: </label>
                            <form:input path="orderMakes" id="orderMakes" name="orderMakes" class="form-control" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-default btn-primary" value="Add a new customer"/>
                        </div>
                    </fieldset>
                </form:form>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</section>
</body>
</html>
