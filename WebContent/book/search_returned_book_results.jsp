<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却資料一覧</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
<h1>返却された資料の一覧</h1>
<hr>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>ISBN番号</th>
			<th>資料名</th>
			<th>分類コード</th>
			<th>著者</th>
			<th>出版社</th>
			<th>出版日</th>
			<th>予約状況</th>
			<th>予約棚に移動</th>
			<th>館内の棚に移動</th>
		</tr>
		<c:forEach items="${returned_books}" var="book">
		<tr>
			<td>${book.id}</td>
			<td>${book.bookIsbn}</td>
			<td>${book.bean.name}</td>
			<td>${book.bean.classId}</td>
			<td>${book.bean.author}</td>
			<td>${book.bean.publisher}</td>
			<td>${book.bean.releaseDate}</td>
			<td>${book.preorderStatus}</td>
			<td>
			<form action="/group-kensyu/BookManageServlet" method="post">
				<input type="hidden" name="book_id" value="${book.id}">
				<input type="hidden" name="action" value="keep">
				<input type="submit" value="予約棚に移動">
			</form>
			</td>
			<td>
			<form action="/group-kensyu/BookManageServlet" method="post">
				<input type="hidden" name="book_id" value="${book.id}">
				<input type="hidden" name="action" value="exist">
				<input type="submit" value="館内の棚に移動">
			</form>
			</td>
		</tr>
		</c:forEach>


	</table>

</body>
</html>