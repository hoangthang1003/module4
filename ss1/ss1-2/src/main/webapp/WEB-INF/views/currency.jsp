<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24/02/2023
  Time: 4:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency</title>
</head>
<body>
<h1>Ứng dụng chuyển đổi tiền tệ</h1>
<form>
    <p>USD</p>
    <input type="text" name="usd" value="${usd}">
    <input type="submit" value="Kiểm tra">
</form>

<p>${usd} usd = ${vnd} vnd </p>
</body>
</html>
