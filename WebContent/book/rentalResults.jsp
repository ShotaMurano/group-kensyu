<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出入力</title>
</head>
<body>
<jsp:include page="rental.jsp" />
	<hr>
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
		<!--       <tr><td>1</td><td>97788481642674</td><td>吾輩は猫である</td><td>文学</td><td>夏目漱石</td><td>服部書店</td><td>1905年10月6日</td><th><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr> -->
		<!--       <tr><td>2</td><td>97788481642674</td><td>吾輩は猫である</td><td>文学</td><td>夏目漱石</td><td>服部書店</td><td>1905年10月6日</td><th><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr> -->
	</table>

</body>
</html>