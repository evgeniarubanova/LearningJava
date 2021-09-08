<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h1>
    VTBshop
</h1>

<body>
<br>
<br/>
<c:forEach var="product" items="${allProducts}">
    <br>
    <li><a href="product/${product.productID}" >${product.title}</a></li>
    <br>
</c:forEach>
<br>
<br>
<br>
<br>
<br>
<a href="/cart" >Перейти к корзине</a>
</body>

</html>