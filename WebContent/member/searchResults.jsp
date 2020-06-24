<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員検索</title>
</head>
<body>

	<jsp:include page="search.jsp" />
	<hr>
	<table border="1">
		<tr>
			<th>ID</th>
	        <th>苗字</th>
	        <th>名前</th>
	        <th>住所</th>
	        <th>電話番号</th>
	        <th>メールアドレス</th>
	        <th>生年月日</th>
	        <th>会員情報の更新</th>
	        <th>会員の退会</th>
		</tr>
		<c:forEach items="${members}" var="member">
			<tr>
				<td>${member.bean.id}</td>
				<td>${member.bean.lastName}</td>
				<td>${member.bean.firstName}</td>
				<td>${member.bean.address}</td>
				<td>${member.bean.tellphone}</td>
				<td>${member.bean.maiAddress}</td>
				<td>${member.bean.birthday}</td>
				<td>
				<form action="/group-kensyu/MemberServlet" method="post">
				<input type="hidden" name="book_id" value="${book.id}">
				<input type="hidden" name="book_name" value="${book.bean.name}">
				<input type="hidden" name="action" value="delete_check">
				<input type="submit" value="削除">
				</form>
				</td>
				<td>
				<form action="/group-kensyu/BookManageServlet" method="post">
				<input type="hidden" name="book_id" value="${book.id}">
				<input type="hidden" name="action" value="update">
				<input type="submit" value="変更">
				</form>
				</td>
				<td>
				<form action="/group-kensyu/BookManageServlet" method="post">
				<input type="hidden" name="book_id" value="${book.id}">
				<input type="hidden" name="action" value="preorder">
				<input type="submit" value="予約">
				</form>
				</td>
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