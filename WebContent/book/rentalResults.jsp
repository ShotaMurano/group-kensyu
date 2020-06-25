<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出処理完了</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
<jsp:include page="rental.jsp" />
	<hr>
	<h2>貸出処理が完了しました</h2>
	<table border="1">
		<tr>
			<th>貸出ID</th>
			<th>資料ID</th>
			<th>ユーザID</th>
			<th>貸出日</th>
			<th>返却日</th>

		</tr>
		<c:forEach items="${items}" var="borrow">
			<tr>
				<td>${borrow.id}</td>
				<td>${borrow.stockId}</td>
				<td>${borrow.userId}</td>
				<td>${borrow.borrowDate}</td>
				<td>${borrow.willReturnDate}</td>
			</tr>
		</c:forEach>
	</table>
	<p>*貸出IDが「0」の資料は既に貸し出されています。<br>入力した資料IDに間違いがないか確認してください。</p>

</body>
</html>