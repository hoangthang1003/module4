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
<h1 class="mb-3">Setting</h1>
<form:form modelAttribute="email" action="/updateEmail" method="post">
  <div class="form-group">
    <label>Languages</label>
    <form:select path="languages" items="${language}"/>
  </div>
  <div class="form-group mt-2">
    <label>Page Size: show </label>
    <form:select path="pageSize" items="${pageSize}"/>
    <span> emails per page</span>
  </div>
  <div class="form-check mt-2">
    <label class="form-check-label" for="defaultCheck1">
      Spam Filter
    </label>
    <form:checkbox path="spamsFilter" class="form-check-input" value="${email.spamsFilter}"
                   id="defaultCheck1"/>
  </div>
  <div class="form-group mt-3">
    <label>Signature</label>
    <form:textarea path="signature"/>
  </div>
  <button class="btn btn-danger my-3" type="button"><a class="text-white" style="text-decoration: none"
                                                       href="/email">Cancel</a></button>
  <button class="btn btn-primary my-3" type="submit">Update</button>
</form:form>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
