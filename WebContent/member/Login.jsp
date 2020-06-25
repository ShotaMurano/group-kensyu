<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>ログイン</title>
    <jsp:include page="/header.jsp" />
  </head>
  <body>
  <jsp:include page="/body.jsp" />
    <h1>ログインページ</h1>
    <hr>
    <form action="/group-kensyu/LoginServlet" method="post">
      ID　　　　：<input type="number" name="id"><br>
      パスワード：<input type="password" name="password"><br>
      <input type="hidden" name="action" value="login">
      <input type="submit" value="ログイン"><br>
    </form>
  </body>
</html>