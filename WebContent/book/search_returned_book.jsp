<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>返却資料検索</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />

 <h1>返却された資料検索</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

    <hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <br><br>
      <input type="submit" value="返却資料検索">
      <input type="hidden" name="action" value="searchReturnedBook">
      <br>
    </form>

</body>
</html>