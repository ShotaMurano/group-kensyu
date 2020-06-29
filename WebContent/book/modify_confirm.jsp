<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>情報更新</title>
<jsp:include page="../image.jsp" />
<jsp:include page="../header.jsp" />
</head>
<body>
<header></header>
<jsp:include page="../body.jsp" />
<h1>本の情報更新、完了画面</h1>
<h2>本の情報を以下の通り変更しました</h2>

<table class="table table-hover" border="1">
	<thead class="thead-dark">
	<tr>
		<th>ISBN</th>
		<th>資料名</th>
		<th>分類コード</th>
		<th>著者</th>
		<th>出版社</th>
		<th>出版日</th>
	</tr>

	<tr>
		<td>${isbn}</td>
		<td>${name}</td>
		<td>${classId}</td>
		<td>${author}</td>
		<td>${publisher}</td>
		<td>${releaseDate}</td>
	</tr>

</table>
</body>
</html>