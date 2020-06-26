<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>新規会員登録</title>
    <jsp:include page="/header.jsp" />
    <style>
	form {padding: 10px;}
	h1 { padding: 10px;}
	input{ 10px; margin: 10px}
	</style>
  </head>
  <body>
  <jsp:include page="/body.jsp" />
    <h1>新規会員登録ページ</h1>


     <hr>
    <form action="/group-kensyu/MemberServlet" method="post">
      苗字　　　　　：<input class="col-sm-4 col-form-label" type="text" name="lastName" value=""required=""><br>
      名前　　　　　：<input class="col-sm-4 col-form-label" type="text" name="firstName" value=""required=""><br>
      住所　　　　　：<input class="col-sm-4 col-form-label" type="text" name="address" value=""required=""><br>
      電話番号　　　：<input class="col-sm-4 col-form-label" type="text" name="tellphone" value=""required=""><br>
      メールアドレス：<input class="col-sm-4 col-form-label" type="text" name="mailAddress" value=""required=""><br>
      生年月日　　　：<input class="col-sm-4 col-form-label" type="text" name="birthday" value=""required=""><br>
     <!--  身分証明書　　：<input type="file" name="" value=""><br><br>-->
     <input type="hidden" name="action" value="addResults">
      <input class="btn btn-primary" type="submit" name="" value="確認画面へ"><br>
    </form>
  </body>
</html>