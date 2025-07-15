<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="col-md-4 mx-auto">
        <form method="post" action="/calculator">
            <legend class="text-center mb-4">Simple Calculator</legend>

            <input type="text" name="first" class="form-control mb-3" placeholder="Enter first number" required
                   value="${first}">
            <input type="text" name="second" class="form-control mb-3" placeholder="Enter second number" required
                   value="${second}">

            <div class="d-flex justify-content-between">
                <button type="submit" name="operator" value="+" class="btn btn-secondary">+</button>
                <button type="submit" name="operator" value="-" class="btn btn-secondary">−</button>
                <button type="submit" name="operator" value="*" class="btn btn-secondary">×</button>
                <button type="submit" name="operator" value="/" class="btn btn-secondary">÷</button>
            </div>

        </form>

        <c:if test="${not empty result}">
            <div class="alert alert-success mt-4">
                Result: ${first} ${operator} ${second} = ${result}
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger mt-4">
                    ${error}
            </div>
        </c:if>
    </div>
</div>

</body>
</html>
