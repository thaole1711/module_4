<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chuyển đổi tiền tệ</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <div class="col-md-4 mx-auto">
    <form method="post">
      <legend class="text-center mb-4">TRA TỪ ĐIỂN</legend>




      <div class="mb-3">
        <label for="word" class="form-label"> Nhập từ cần tra:</label>
        <input type="text" name="word" id="word" class="form-control"
               value="${word != null ? word : ''}">
      </div>

      <div class="mb-3">
        <label for="result" class="form-label">tiếng việt:</label>
        <input type="text" id="result" class="form-control" readonly
               value="${result}">
      </div>

      <button type="submit" class="btn btn-primary w-100">tìm kiếm</button>
    </form>
  </div>
</div>

</body>
</html>
