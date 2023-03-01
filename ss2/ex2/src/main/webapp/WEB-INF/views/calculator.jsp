<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 27/02/2023
  Time: 8:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity
            ="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center" style="color: cornflowerblue">Calculator</h1>
<div class="text-center">
    <form action="/calculator" method="post">
            <p><input type="text" name="firstNumber"></p>
            <p><input type="text" name="secondNumber"></p>
            <select class="form-select" name="method" aria-label="Default select example">
                <option selected>Open this select menu</option>
                <option  value="addition">Addition(+)</option>
                <option value="subtraction">Subtraction(-)</option>
                <option value="multiplication">Multiplication(*)</option>
                <optiqon  value="division">Division(/)</optiqon>
            </select>
            <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <h1>Result: ${result}</h1>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
