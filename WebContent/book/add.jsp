<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料の追加</title>
<jsp:include page="../image.jsp" />
<jsp:include page="../header.jsp" />
<style>
form {padding: 10px;}
h1 { padding: 10px;}
input{ 10px; margin: 10px}
</style>
<link rel="stylesheet" href="../css/form-button.css" type="text/css">
</head>
<body>
<header></header>
<jsp:include page="../body.jsp" />
    <h1>資料の追加</h1>
<hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ISBN　　　：<input class="col-sm-4 col-form-label" type="text" name="isbn" value="${bookBean.isbn}" required><br>
      資料名　　：<input class="col-sm-4 col-form-label" type="text" name="name" value="${bookBean.name}" required><br>
      分類コード：<input class="col-sm-4 col-form-label" type="text" name="classId" value="${bookBean.classId}" required><br>
      著者　　　：<input class="col-sm-4 col-form-label" type="text" name="author" value="${bookBean.author}" required><br>
      出版社　　：<input class="col-sm-4 col-form-label" type="text" name="publisher" value="${bookBean.publisher}" required><br>
      出版日　　：<input class="col-sm-4 col-form-label" type="text" name="releaseDate" value="${bookBean.releaseDate}" required><br>
      <br><br>
      <input class="btn btn-primary" type="submit" value="追加">
       <input type="hidden" name="action" value="checkAdd">
      <br>
    </form>
</body>
</html>