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
<jsp:include page="/body.jsp" />
<form action="/group-kensyu/LoginServlet" method="post">
				<input type="hidden" name="action" value="logout">
				<input type="submit" value="ログアウト">
				</form>

				<form action="/group-kensyu/topPage.jsp" method="post">
				<input type="hidden" name="action" value=>
				<input type="submit" value="トップページに戻る">
				</form>

				<form action="/group-kensyu/member/Login.jsp" method="post">
				<input type="hidden" name="action" value=>
				<input type="submit" value="ログインページに戻る">
				</form>

</body>
</html>