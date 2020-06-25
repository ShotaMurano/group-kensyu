<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>返却</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
    <h1>返却入力</h1>

    <hr>
    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      会員ID：<input type="text" name="member_id" value=""><br><br>
      本のID：<input type="text" name="book_id_1" value=""><br>
      本のID：<input type="text" name="book_id_2" value=""><br>
      本のID：<input type="text" name="book_id_3" value=""><br>
      本のID：<input type="text" name="book_id_4" value=""><br>
      本のID：<input type="text" name="book_id_5" value=""><br>
      </p>
      <br>
      <input type="hidden" name="action" value="return">
      <input type="submit" name="" value="返却する"><br>
    </form><br>
  </body>
</html>
