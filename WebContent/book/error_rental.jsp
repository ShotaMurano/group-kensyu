<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出エラー</title>
</head>
<body>
<jsp:include page="rental.jsp" />
    <hr>
<h2>会員様の貸出数・予約数が${count}冊となりレンタルができません</h2>
<h2>貸出数・予約数の上限は5冊です</h2>
</body>
</html>