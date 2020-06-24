<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約完了</title>
</head>
<body>
<h2>書籍の予約が完了しました。</h2><br>
<h3>会員ID：${sessionScope.id}</h3><br>
<h3>書籍名：${requestScope.name}</h3>
</body>
</html>