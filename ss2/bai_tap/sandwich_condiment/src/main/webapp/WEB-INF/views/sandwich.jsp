<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 7/15/2025
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<c:if test="${not empty condiments}">
  <div class="alert alert-success d-flex align-items-center" role="alert">
    <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Success:">
      <div>
        <h2>The condiments you selected are:</h2>
        <c:forEach var="condiment" items="${condiments}">
          <span>${condiment}</span>

        </c:forEach>
      </div>
    </svg>
  </div>
</c:if>
<div class="container mt-5">
  <div class="col-md-4 mx-auto">
    <form method="post" action="/save">
      <legend class="text-center mb-4">Sandwich Condiments</legend>


      <c:forEach items="${sandwichs}" var="sandwich">
      <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" name="condiment" value="${sandwich}" id="${sandwich}">
        <label class="form-check-label" for="${sandwich}">
          ${sandwich}
        </label>
      </div>
      </c:forEach>
      <button type="submit" class="btn btn-primary w-30">Save</button>
    </form>
  </div>
</div>

<p  style="color: red">${mess}</p>
</body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</html>
