<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавить покупку</title>
    <style type="text/css">
        body {
            display: flex;
            justify-content: center;
        }
        input {
            float: right;
            margin-left: 10px;
        }
    </style>
</head>
<body>

<c:url value="/add" var="var"/>
<form action="${var}" method="POST">
    <label for="name">Название покупки: </label>
    <input type="text" name="Name" id="name" required>
    <br>
    <br>
    <label for="price">Цена: </label>
    <input type="number" step="0.01" name="Price" id="price" required>
    <br>
    <br>
    <label for="count">Количество: </label>
    <input type="number" name="Count" id="count" required>
    <br>
    <br>
    <input type="submit" value="Добавить покупку">
</form>

</body>
</html>
