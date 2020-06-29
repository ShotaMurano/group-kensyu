<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員更新</title>
<jsp:include page="../image.jsp" />
<jsp:include page="/header.jsp" />
</head>
<body>
<header></header>
<jsp:include page="/body.jsp" />
<hr>
	<table class="table table-hover" border="1">
	<thead class="thead-dark">
		<tr>
			<th>ID</th>
	        <th>苗字</th>
	        <th>名前</th>
	        <th>住所</th>
	        <th>電話番号</th>
	        <th>メールアドレス</th>
	        <th>生年月日</th>
	        <th>入会年月日</th>
	        <th>退会年月日</th>
		</tr>
		<c:forEach items="${updates}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.lastName}</td>
				<td>${member.firstName}</td>
				<td>${member.address}</td>
				<td>${member.tellphone}</td>
				<td>${member.mailAddress}</td>
				<td>${member.birthday}</td>
				<td>${member.inDate}</td>
				<td>${member.outDate}</td>
			</tr>
		</c:forEach>
		<!--       <tr><td>1</td><td>97788481642674</td><td>吾輩は猫である</td><td>文学</td><td>夏目漱石</td><td>服部書店</td><td>1905年10月6日</td><th><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr> -->
		<!--       <tr><td>2</td><td>97788481642674</td><td>吾輩は猫である</td><td>文学</td><td>夏目漱石</td><td>服部書店</td><td>1905年10月6日</td><th><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr> -->
	</table>

</body>
</html>

<!-- <td>${book.isbn}</td>
				<td>${book.name}</td>
				<td>${book.classId}</td>
				<td>${book.author}</td>
				<td>${book.publisher}</td>
				<td>${book.releaseDate}</td>
				<td>${book.inDate}</td>
				<td>${book.outDate}</td>
				<td>${book.status}</td> -->