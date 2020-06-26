<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料検索</title>
<jsp:include page="../header.jsp" />
<link rel="stylesheet" href="../css/form-button.css" type="text/css">
</head>
<body>
<jsp:include page="../body.jsp" />

 <h1>資料検索</h1>

    <hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ID　　　　：<input class="col-sm-4 col-form-label" type="text" name="id" value=""><br>
      ISBN　　　：<input class="col-sm-4 col-form-label" type="text" name="isbn" value=""><br>
      資料名　　：<input class="col-sm-4 col-form-label" type="text" name="name" value=""><br>
      分類コード：<input class="col-sm-4 col-form-label" type="text" name="classId" value=""><br>
      著者　　　：<input class="col-sm-4 col-form-label" type="text" name="author" value=""><br>
      出版社　　：<input class="col-sm-4 col-form-label" type="text" name="publisher" value=""><br>
      出版日　　：<input class="col-sm-4 col-form-label" type="text" name="releaseDate" value=""><br>

      <br>
      <input class="btn btn-primary" type="submit" value="検索">
      <input type="hidden" name="action" value="search">
      <br>
    </form>

</body>
</html>