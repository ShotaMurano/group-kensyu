<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却処理完了</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
<jsp:include page="7_1_book_return_info_V2.html" />
    <hr>
	<h2>返却処理が完了しました</h2>
	<table border="1">
		<tr>
			<th>資料ID</th>
			<th>ユーザID</th>
			<th>貸出日</th>
			<th>返却予定日</th>
			<th>返却日</th>
		</tr>
		<c:forEach items="${items}" var="returned">
			<tr>
				<td>${returned.stockId}</td>
				<td>${returned.userId}</td>
				<td>${returned.borrowDate}</td>
				<td>${returned.willReturnDate}</td>
				<td>${returned.returnDate}</td>
			</tr>
		</c:forEach>
	</table>
	<p>上記の本の返却処理が完了しました。</p>

</body>
</html>