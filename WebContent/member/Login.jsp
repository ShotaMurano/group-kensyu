<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>ログイン</title>
  </head>
  <body>
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