<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>新規会員登録</title>
  </head>
  <body>
    <h1>新規会員登録ページ</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

     <hr>
    <form action="/group-kensyu/MemberServlet" method="post">
      苗字　　　　　：<input type="text" name="lastName" value="">
      名前　　　　　：<input type="text" name="firstName" value=""><br>
      住所　　　　　：<input type="text" name="address" value=""><br>
      電話番号　　　：<input type="text" name="tellphone" value=""><br>
      メールアドレス：<input type="text" name="mailAddress" value=""><br>
      生年月日　　　：<input type="text" name="birthday" value=""><br>
      退会年月日　　：<input type="text" name="outDate" value=""><br>
     <!--  身分証明書　　：<input type="file" name="" value=""><br><br>-->
     <input type="hidden" name="action" value="add">
      <input type="submit" name="" value="確認画面へ"><br>
    </form>
  </body>
</html>