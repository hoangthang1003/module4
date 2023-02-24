<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24/02/2023
  Time: 4:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Your dictionary</h1>
<form>
  <p>Enter the word you want to translate:
    <input type="text" name="word" value="${word}">
  </p>
  <input type="submit" value="Translate">
</form>
<p>Translation result : ${trans}</p>
</body>
</html>
