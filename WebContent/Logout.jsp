<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<form action="/group-kensyu/LoginServlet" method="post">
				<input type="hidden" name="action" value="logout">
				<input type="submit" value="ログアウト">
				</form>

				<form action="/group-kensyu/topPage.jsp" method="post">
				<input type="hidden" name="action" value=>
				<input type="submit" value="トップページに戻る">
				</form>

</body>
</html>