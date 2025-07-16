<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="col-md-6 mx-auto">
        <div class="card shadow-lg rounded">
            <div class="card-header bg-primary text-white text-center">
                <h4 class="mb-0">Settings</h4>
            </div>
            <div class="card-body">
                <form:form method="post" action="/save" modelAttribute="setting">

                    <!-- Language -->
                    <div class="mb-3">
                        <label for="language" class="form-label"><strong>Language:</strong></label>
                        <form:select path="language" class="form-select" id="language">
                            <form:option value="english">english</form:option>
                            <form:option value="vietnamese">vietnamese</form:option>
                            <form:option value="japanese">japanese</form:option>
                            <form:option value="chinese">chinese</form:option>
                        </form:select>
                    </div>

                    <!-- Page Size -->
                    <div class="mb-3">
                        <label for="pageSize" class="form-label"><strong>Page Size:</strong></label><br>
                        <span>Show</span>
                        <form:select path="pageSize" class="form-select form-select-sm d-inline-block w-auto mx-2" id="pageSize">
                            <form:option value="5">5</form:option>
                            <form:option value="10">10</form:option>
                            <form:option value="15">15</form:option>
                            <form:option value="25">25</form:option>
                            <form:option value="50">50</form:option>
                            <form:option value="100">100</form:option>
                        </form:select>
                        <span>emails per page</span>
                    </div>

                    <!-- Spam Filter -->
                    <div class="mb-3">
                        <label class="form-label"><strong>Spam Filter:</strong></label>
                        <div class="form-check">
                            <form:checkbox path="spam" class="form-check-input" id="checkDefault"/>
                            <label class="form-check-label" for="checkDefault">
                                Enable spam filter
                            </label>
                        </div>
                    </div>

                    <!-- Signature -->
                    <div class="mb-3">
                        <label for="signature" class="form-label"><strong>Signature:</strong></label>
                        <form:textarea path="signature" class="form-control" id="signature" rows="4" placeholder="Nhập chữ ký tại đây..." />
                    </div>

                    <!-- Buttons -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary px-4 me-2">Update</button>
                        <button type="button" class="btn btn-secondary px-4" onclick="window.location.href='/setting'">Cancel</button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
