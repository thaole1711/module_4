<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 7/14/2025
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
  <th>stt</th>
  <th>tên</th>
  <th>email</th>
  <th>Địa chỉ</th>
  </tr>
<c:forEach var="customer" items="${customers}" varStatus="temp">
  <tr>
    <td>${temp.count}</td>
    <td>${customer.name}</td>
    <td>${customer.email}</td>
    <td>${customer.address}</td>
  </tr>

</c:forEach>


</table>
</body>
</html>
