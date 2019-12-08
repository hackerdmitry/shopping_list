<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Покупки</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            display: flex;
            justify-content: center;
        }

        th, td {
            text-align: center;
            padding: 10px;
            border: 1px solid black;
        }

        .delete-button {
            padding: 0 0 0 10px;
            border: 0;
        }
    </style>
</head>
<body>

<button onclick="location.href='/add'">Добавить</button>
<table>
    <tr>
        <th>ID</th>
        <th>Имя покупки</th>
        <th>Цена</th>
        <th>Кол-во</th>
        <th>Куплена</th>
    </tr>
    <c:forEach var="purchase" items="${purchasesList}">
        <tr>
            <td>${purchase.id}</td>
            <td>${purchase.name}</td>
            <td>${purchase.price}</td>
            <td>${purchase.count}</td>
            <td onclick="location.href='/isBought/${purchase.id}'">
                <input type="checkbox" <c:if test="${purchase.isBought}">checked</c:if>/>
            </td>
            <td class="delete-button">
                <button onclick="location.href='/delete/${purchase.id}'">Удалить</button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>