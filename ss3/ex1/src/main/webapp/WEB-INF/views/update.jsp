<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 28/02/2023
  Time: 8:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Informatiton</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="email" action="/email/updateEmail" method="post">
  <label>Languages</label>
  <form:select path="languages" items="${languages}"/>
  <label>Page Size : show</label>
  <form:select path="pageSize" items="${pageSize}"/>
  <label for="defaultCheck">Spam Filter</label>
  <form:checkbox path="spamsFilter" value="${email.spamFilter}" id="defaultCheck"/>
  <label>Signature</label>
  <form:textarea path="signature"/>
  <button type="button"><a href="/email">Cancel</a></button>
  <button type="submit"><a href="update.jsp">Update</a></button>
</form:form>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
