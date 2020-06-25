<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料の追加</title>
</head>
<body>
    <h1>資料の追加</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>
<hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ISBN　　　　　　：<input type="text" name="isbn" value="${bookBean.isbn}" required><br>
      <input type="hidden">
      資料名 　　　　　：<input type="text" name="name" value="${bookBean.name}" required><br>
      <input type="hidden">
      分類コード　　　 ：<input type="text" name="classId"  value="${bookBean.classId}" required><br>
      <input type="hidden">
      著者　　　　　　 ：<input type="text" name="author" value="${bookBean.author}" required><br>
      <input type="hidden">
      出版社　　　　　 ：<input type="text" name="publisher" value="${bookBean.publisher}" required><br>
      <input type="hidden">
      出版日　　　　　 ：<input type="text" name="releaseDate" value="${bookBean.releaseDate}" required><br>
      <input type="hidden">
      <br><br>
      <h2>以上でよろしいですか？</h2><br>
      <input type="submit" value="確定">
       <input type="hidden" name="action" value="add">
      <br>
    </form>
</body>
</html>