<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料の追加</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
    <h1>資料の追加</h1>
<hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ISBN　　　　　　：<input type="text" name="isbn" required><br>

      <br><br>
      <input type="submit" value="ISBN検索">
       <input type="hidden" name="action" value="isbn_search">
      <br>
    </form>

</body>
</html>