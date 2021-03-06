<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<jsp:include page="../image.jsp" />
<jsp:include page="../header.jsp" />
</head>
<body>
<header></header>
<jsp:include page="../body.jsp" />
<h1>本の削除、最終確認画面</h1>

<c:forEach items="${book_id}" var="book_id">
<h2>ID：${book_id}</h2>
</c:forEach>
<c:forEach items="${book_name}" var="book_name">
<h2>資料名：${book_name}</h2>
</c:forEach>

<form action="/group-kensyu/BookManageServlet" method="post">
	上記の本を削除しますか？？
	<input type="hidden" name="book_id" value="${book_id}">
	<input type="hidden" name="book_name" value="${book_name}">
	<input type="hidden" name="action" value="delete">
	<input class="btn btn-primary" type="submit" value="削除を確定する">
</form>
</body>
</html>