<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料検索</title>
</head>
<body>

<jsp:include page="search.jsp" />
<hr>
    <table border="1">
    	<tr><th>ID</th><th>ISBN番号</th><th>資料名</th><th>分類コード</th><th>著者</th><th>出版社</th><th>出版日</th><th>削除</th><th>変更</th><th>予約</th></tr>
      	<c:forEach books="${books}" var ="book">
      		<tr><td>"${book.id}"</td><td>"${book.isbn}"</td><td>"${book.name}"</td><td>"${book.classId}"</td><td>"${book.author}"</td><td>"${book.publisher}"</td><td>"${book.isbn}"</td><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr>

<!--       <tr><td>1</td><td>97788481642674</td><td>吾輩は猫である</td><td>文学</td><td>夏目漱石</td><td>服部書店</td><td>1905年10月6日</td><th><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr> -->
<!--       <tr><td>2</td><td>97788481642674</td><td>吾輩は猫である</td><td>文学</td><td>夏目漱石</td><td>服部書店</td><td>1905年10月6日</td><th><input type='button' value="削除"></th><th><input type='button' value="変更"></th><th><input type='button' value="予約"></th></tr> -->
    </table>

</body>
</html>