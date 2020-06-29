<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約最終確認</title>
<jsp:include page="../image.jsp" />
<jsp:include page="../header.jsp" />
<style>
form {padding: 10px;}
h1 { padding: 10px;}
input{ 10px; margin: 10px}
</style>
</head>
<body>
<header></header>
<jsp:include page="../body.jsp" />

<h1>予約内容の最終確認</h1>
   <hr>

<c:forEach items="${id}" var="id">
<h2>会員ID：${id}</h2>
</c:forEach>
<c:forEach items="${book_id}" var="book_id">
<h2>資料ID：${book_id}</h2>
</c:forEach>

<c:forEach items="${book_name}" var="book_name">
<h2>資料名：${book_name}</h2>
</c:forEach>

<form action="/group-kensyu/BookManageServlet" method="post">
	上記の内容で予約しますか？？
	<input type="hidden" name="book_id" value="${requestScope.book_id}">
	<input type="hidden" name="book_name" value="${book_name}">
	<input type="hidden" name="id" value="${id}">
	<input type="hidden" name="action" value="preorder">
	<input class="btn btn-primary" type="submit" value="予約を確定">
</form>

</body>
</html>