<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出入力</title>
</head>
<body>
<h1>貸出入力</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

    <hr>
    <form action="/BookManageServlet" method="post">
      <p>
      会員ID：<input type="text" name="member_id" value=""><br>
      本のID：<input type="text" name="book_id_1" value=""><br>
      本のID：<input type="text" name="book_id_2" value=""><br>
      本のID：<input type="text" name="book_id_3" value=""><br>
      本のID：<input type="text" name="book_id_4" value=""><br>
      本のID：<input type="text" name="book_id_5" value=""><br>
      </p>
      <br>
      <input type="submit" name="" value="借りる"><br>
    </form><br>
    <!-- <table border="1">
  </table> -->
</body>
</html>