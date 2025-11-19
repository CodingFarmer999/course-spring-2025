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
<h1>購物車</h1>

<table border="1">
	<tr>
		<td>編號</td>
		<td>商品名稱</td>
		<td>操作</td>
	</tr>
    <c:forEach var="product" items="${productList}">
	<tr>
		<td>${product.id}</td>
		<td>${product.name}</td>
		<td><a href="#">刪除</a></td>
	</tr>
    </c:forEach>
</table>
</body>
</html>