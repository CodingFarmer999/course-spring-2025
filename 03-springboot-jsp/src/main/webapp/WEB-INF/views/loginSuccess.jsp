<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${user} 你好! 登入成功</h1>
<h2>${company}</h2>
${hobby}

<form action="addToCart" method="GET">
    ProductId: <input type="text" name="productId"/> <br>
    <input type="submit" />
</form>

<a href="/getProducts">取得Session當中的資料</a>
<div>
<ul>
    <c:forEach var="product" items="${products}">
        <li>${product.productId}</li>
    </c:forEach>
</ul>

</div>
</body>
</html>