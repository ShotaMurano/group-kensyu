<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料の追加</title>
<jsp:include page="../header.jsp" />
<link rel="stylesheet" href="../css/form-button.css" type="text/css">
<style>
form {padding: 10px;}
h1 { padding: 10px;}
input{ 10px; margin: 10px}
</style>
</head>
<body>
<jsp:include page="../body.jsp" />
    <h1>資料の追加</h1>
<hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ISBN　　　：<input class="col-sm-4 col-form-label" type="text" name="isbn" value="${bookBean.isbn}" required><br>
      <input type="hidden">
      資料名　　：<input class="col-sm-4 col-form-label" type="text" name="name" value="${bookBean.name}" required><br>
      <input type="hidden">
      分類コード：<input class="col-sm-4 col-form-label" type="text" name="classId"  value="${bookBean.classId}" required><br>
      <input type="hidden">
      著者　　　：<input class="col-sm-4 col-form-label" type="text" name="author" value="${bookBean.author}" required><br>
      <input type="hidden">
      出版社　　：<input class="col-sm-4 col-form-label" type="text" name="publisher" value="${bookBean.publisher}" required><br>
      <input type="hidden">
      出版日　　：<input class="col-sm-4 col-form-label" type="text" name="releaseDate" value="${bookBean.releaseDate}" required><br>
      <input type="hidden">
      <br><br>
      <h2>以上でよろしいですか？</h2><br>
      <input class="btn btn-primary" type="submit" value="確定">
       <input type="hidden" name="action" value="add">
      <br>
    </form>
</body>
</html>