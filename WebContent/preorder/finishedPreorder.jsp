<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約完了</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
<a href="" align="right">トップへ戻る</a>
<a href="" align="right">ログアウト</a><br>
<hr>

<h2>資料の予約が完了しました。</h2><br>
<%-- <h3>会員ID：${sessionScope.id}</h3><br> --%>
<%-- <h3>書籍名：${requestScope.name}</h3> --%>
<h3>会員ID：${requestScope.id}</h3>
<h3>資料ID：${requestScope.book_id}</h3>
<h3>資料名：${requestScope.book_name}</h3>



</body>
</html>