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
	        <th>入会年月日</th>
	        <th>会員の更新</th>
	        <th>会員の退会</th>
		</tr>
		<c:forEach items="${members}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.lastName}</td>
				<td>${member.firstName}</td>
				<td>${member.address}</td>
				<td>${member.tellphone}</td>
				<td>${member.mailAddress}</td>
				<td>${member.birthday}</td>
				<td>${member.inDate}</td>

				<td>
				<form action="/group-kensyu/MemberServlet" method="post">
				<input type="hidden" name="member.id" value="${member.id}">
				<input type="hidden" name="member.lastName" value="${member.lastName}">
				<input type="hidden" name="member.firstName" value="${member.firstName}">
				<input type="hidden" name="member.address" value="${member.address}">
				<input type="hidden" name="member.tellphone" value="${member.tellphone}">
				<input type="hidden" name="member.mailAddress" value="${member.mailAddress}">
				<input type="hidden" name="member.birthday" value="${member.birthday}">
				<input type="hidden" name="member.inDate" value="${member.inDate}">
				<input type="hidden" name="member.outDate" value="${member.outDate}">
				<input type="hidden" name="action" value="update">
				<input type="submit" value="更新">
				</form>
				</td>

				<td>
				<form action="/group-kensyu/MemberServlet" method="post">
				<input type="hidden" name="member.id" value="${member.id}">
				<input type="hidden" name="member.lastName" value="${member.lastName}">
				<input type="hidden" name="member.firstName" value="${member.firstName}">
				<input type="hidden" name="action" value="update">
				<input type="submit" value="退会">
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