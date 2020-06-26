<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出入力</title>
<jsp:include page="../header.jsp" />
<link rel="stylesheet" href="../css/form-button.css" type="text/css">
</head>
<body>
<jsp:include page="../body.jsp" />
<h1>貸出入力</h1>

    <hr>
    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      会員ID：<input class="col-sm-4 col-form-label" type="text" name="member_id" value=""><br><br>
      本のID：<input class="col-sm-4 col-form-label" type="text" name="book_id_1" value=""><br>
      本のID：<input class="col-sm-4 col-form-label" type="text" name="book_id_2" value=""><br>
      本のID：<input class="col-sm-4 col-form-label" type="text" name="book_id_3" value=""><br>
      本のID：<input class="col-sm-4 col-form-label" type="text" name="book_id_4" value=""><br>
      本のID：<input class="col-sm-4 col-form-label" type="text" name="book_id_5" value=""><br>
      </p>
      <br>
      <input type="hidden" name="action" value="rental">
      <input class="btn btn-primary" type="submit" name="" value="借りる"><br>
    </form><br>
</body>
</html>