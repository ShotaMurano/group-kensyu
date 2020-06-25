<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料情報の変更</title>
</head>
<body>
<h1>資料情報の変更</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

	<form action="/group-kensyu/BookManageServlet" method="post">
      ISBN　　　　　　：${bookinfo.isbn}<br>
      資料名 　　　　　：<input type="text" name="name" value="${bookinfo.name}"><br>
      分類コード　　　 ：<input type="text" name="classId" value="${bookinfo.classId}"><br>
      著者　　　　　　 ：<input type="text" name="author" value="${bookinfo.author}"><br>
      出版社　　　　　 ：<input type="text" name="publisher" value="${bookinfo.publisher}"><br>
      出版日　　　　　 ：<input type="text" name="releaseDate" value="${bookinfo.releaseDate}"><br>
      <br><br>
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="isbn" value="${bookinfo.isbn}">
      <input type="submit" value="登録">
	</form>

</body>
</html>