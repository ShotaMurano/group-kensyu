<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料の追加</title>
<jsp:include page="../header.jsp" />
<style>
form {padding: 10px;}
h1 { padding: 10px;}
input{ 10px; margin: 10px}
</style>
<link rel="stylesheet" href="../css/form-button.css" type="text/css">
</head>
<body>
<jsp:include page="../body.jsp" />
    <h1>資料の追加</h1>
<hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ISBN：<input class="col-sm-4 col-form-label" type="text" name="isbn" required><br>

      <br>
      <input class="btn btn-primary" type="submit" value="ISBN検索">
       <input type="hidden" name="action" value="isbn_search">
      <br>
    </form>

</body>
</html>