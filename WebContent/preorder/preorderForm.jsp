<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料の予約</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
<h1>資料を予約したい会員のIDを入力してください</h1>

<hr>

<p>
予約する資料<br>
<c:forEach items="${book_id}" var="book_id">
資料ID：${book_id}<br>
</c:forEach>
<c:forEach items="${book_name}" var="book_name">
資料名：${book_name}<br>
</c:forEach>
</p>
<hr>

<form action="/group-kensyu/BookManageServlet" method="post">
<input type="hidden" name="book_id" value="${book_id}">
<input type="hidden" name="book_name" value="${book_name}">
会員ID 　　　　　：<input type="text" name="id" value="">
<input type="submit" value="入力">
<input type="hidden" name="action" value="preorderCheck">

</form>

</body>
</html>