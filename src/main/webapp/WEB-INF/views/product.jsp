<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>

<body>
<br>
<h2>${product.title}</h2>
<br>
<h3>Стоимость: ${product.price} руб.</h3>
<h3>Описание: </h3>
${product.description}
<br>
<br>
<br>
<br>
<br>
<a href="/cart/${product.productID}" >Добавить в корзину</a>
<br>
<br>
<a href="/shop"> Вернуться к списку продуктов </a>
</body>

</html>