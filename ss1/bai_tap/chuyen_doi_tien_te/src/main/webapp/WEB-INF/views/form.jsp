<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <legend class="text-center mb-4">CHUYỂN ĐỔI TIỀN</legend>
      <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
      </c:if>

      <div class="mb-3">
        <label for="from" class="form-label">Từ</label>
        <select name="from" id="from" class="form-select">
          <option value="">Đơn vị</option>
          <option value="USD">USD</option>
          <option value="VND">VND</option>
        </select>
      </div>

      <div class="mb-3">
        <label for="to" class="form-label">Sang</label>
        <select name="to" id="to" class="form-select">
          <option value="">Đơn vị</option>
          <option value="USD" >USD</option>
          <option value="VND">VND</option>
        </select>
      </div>

      <div class="mb-3">
        <label for="amount" class="form-label">Số tiền bạn muốn đổi là:</label>
        <input type="text" name="amount" id="amount" class="form-control"
               value="${amount != null ? amount : ''}">
      </div>

      <div class="mb-3">
        <label for="result" class="form-label">Số tiền sau chuyển đổi:</label>
        <input type="text" id="result" class="form-control" readonly
               value="${result != null ? result : ''}">
      </div>

      <button type="submit" class="btn btn-primary w-100">Chuyển đổi</button>
    </form>
  </div>
</div>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</body>
</html>
