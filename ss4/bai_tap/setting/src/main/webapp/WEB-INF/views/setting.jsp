<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Settings</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="col-md-6 mx-auto">
        <div class="card shadow rounded">
            <div class="card-header bg-primary text-white text-center">
                <h4>Settings</h4>
            </div>
            <div class="card-body">

                <div class="form-group">
                    <label><strong>Language:</strong></label>
                    <p class="form-control-plaintext">${setting.language}</p>
                </div>

                <div class="form-group">
                    <label><strong>Page Size:</strong></label>
                    <p class="form-control-plaintext">
                        Show <strong>${setting.pageSize}</strong> emails per page
                    </p>
                </div>

                <div class="form-group">
                    <label><strong>Spam Filter:</strong></label>
                    <p class="form-control-plaintext">
                        <span class="badge badge-${setting.spam ? 'success' : 'secondary'}">
                            ${setting.spam ? 'On' : 'Off'}
                        </span>
                    </p>
                </div>

                <div class="form-group">
                    <label><strong>Signature:</strong></label>
                    <div class="border p-2 rounded bg-light">
                        <pre class="m-0" style="white-space: pre-wrap;">${setting.signature}</pre>
                    </div>
                </div>

                <div class="text-center mt-4">
                    <button type="button" class="btn btn-secondary" onclick="window.location.href='/setting'">Back</button>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
