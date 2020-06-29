<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<jsp:include page="/image.jsp" />
<jsp:include page="/header.jsp" />
<style>
form {padding: 10px;}
h1 { padding: 10px;}
input{ 10px; margin: 10px}
</style>
</head>
<body>
<header></header>
<h1>ログアウト確認</h1>
<jsp:include page="/body.jsp" />
<form action="/group-kensyu/LoginServlet" method="post">
				<input type="hidden" name="action" value="logout">
				<input class="btn btn-primary" type="submit" value="ログアウト">
				</form>

</body>
</html>