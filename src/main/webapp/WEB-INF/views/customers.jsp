<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers of Web Store</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customers panel</h1>
            <p>Customers data</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <div class="col-md-8">
            <table class="table table-striped">
                <tr><td>ID</td><td>Name</td><td>Address</td><td>Makes order</td></tr>
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.name}</td>
                        <td>${customer.address}</td>
                        <td>${customer.orderMakes}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-md-4"></div>
    </div>
</section>
</body>
</html>
