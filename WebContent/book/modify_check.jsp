<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料情報の変更</title>
<jsp:include page="../header.jsp" />
<style>
form {padding: 10px;}
h1 { padding: 10px;}
input{ 10px; margin: 10px}
</style>
</head>
<body>
<jsp:include page="../body.jsp" />
<h1>資料情報の変更</h1>

	<form action="/group-kensyu/BookManageServlet" method="post">
      ISBN　　　：　${bookinfo.isbn}<br>
      資料名　　：<input class="col-sm-4 col-form-label" type="text" name="name" value="${bookinfo.name}"><br>
      分類コード：<input class="col-sm-4 col-form-label" type="text" name="classId" value="${bookinfo.classId}"><br>
      著者　　　：<input class="col-sm-4 col-form-label" type="text" name="author" value="${bookinfo.author}"><br>
      出版社　　：<input class="col-sm-4 col-form-label" type="text" name="publisher" value="${bookinfo.publisher}"><br>
      出版日　　：<input class="col-sm-4 col-form-label" type="text" name="releaseDate" value="${bookinfo.releaseDate}"><br>
      <br><br>
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="isbn" value="${bookinfo.isbn}">
      <input class="btn btn-primary" type="submit" value="登録">
	</form>

</body>
</html>