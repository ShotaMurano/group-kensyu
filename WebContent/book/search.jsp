<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料検索</title>
</head>
<body>

 <h1>資料検索</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

    <hr>

    <form action="/group-kensyu/BookManageServlet" method="post">
      <p>
      ID 　　　　　　　：<input type="text" name="id" value=""><br>
      ISBN　　　　　　：<input type="text" name="isbn" value=""><br>
      資料名 　　　　　：<input type="text" name="name" value=""><br>
      分類コード　　　 ：<input type="text" name="classId" value=""><br>
      著者　　　　　　 ：<input type="text" name="author" value=""><br>
      出版社　　　　　 ：<input type="text" name="publisher" value=""><br>
      出版日　　　　　 ：<input type="text" name="releaseDate" value=""><br>

      <br><br>
      <input type="submit" value="検索">
       <input type="hidden" name="action" value="search">
      <br>
    </form>

</body>
</html>