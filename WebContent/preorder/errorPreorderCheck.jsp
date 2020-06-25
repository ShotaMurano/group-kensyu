<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力エラー</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />

<h1><font color="red">${message}</font></h1>
<jsp:include page="/preorder/preorderForm.jsp" />


</body>
</html>