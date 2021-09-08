<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>

<body>
<h2>Ваша корзина: </h2>
<c:forEach var="product" items="${cart}">
    <br>
    <li>${product.title} - ${product.price} руб.</li>
    <br>
</c:forEach>
<br>
<br>
<br>
<br>
<br>
<br>
<a href="/shop"> Вернуться к списку продуктов </a>
</body>

</html>