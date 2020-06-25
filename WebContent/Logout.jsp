<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
<jsp:include page="/header.jsp" />
</head>
<body>
<h1>ログアウト確認</h1>
<jsp:include page="/body.jsp" />
<form action="/group-kensyu/LoginServlet" method="post">
				<input type="hidden" name="action" value="logout">
				<input type="submit" value="ログアウト">
				</form>

</body>
</html>