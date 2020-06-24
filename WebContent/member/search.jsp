<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>会員検索</title>
  </head>
  <body>
    <h1>会員検索</h1>
    <a href="/topPage.jsp" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

    <hr>

    <form action="/group-kensyu/MemberServlet" method="post">
      <p>
      ID　　　　：<input type="text" name="id" value=""><br>
      苗字：<input type="text" name="lastName" value="">
      名前：<input type="text" name="firstName" value=""><br>
      住所：<input type="text" name="address" value=""><br>
      電話番号：<input type="text" name="tellphone" value=""><br>
      生年月日：<input type="text" name="birthday" value=""><br>
      メールアドレス：<input type="text" name="mail_Address" value=""><br>
      </p>
      会員のステータス：
      <input type="checkbox" name="inout" value="1">会員
      <input type="checkbox" name="inout" value="2">退会済み会員

      <br><br>
      <input type="submit" value="検索"><br>
      <input type="hidden" name="action" value="search">
    </form>
<!--
    <hr>

      <table border="1">
      <tr>
        <th>ID</th>
        <th>苗字</th>
        <th>名前</th>
        <th>住所</th>
        <th>電話番号</th>
        <th>メールアドレス</th>
        <th>生年月日</th>
        <th>身分証</th>
        <th>ステータス</th>
        <th>会員情報の更新</th>
        <th>会員の退会</th>
      </tr>
      <tr>
        <td>001</td>
        <td>山田</td>
        <td>太郎</td>
        <td>東京都新宿区ほげほげ</td>
        <td>080-1111-2222</td>
        <td>aaaa@abc.com</td>
        <td>2000年12月10日</td>
        <td><a href="">身分証の画像</a></td>
        <td>会員</td>
        <td><input type='button' value="会員情報の更新"></td>
        <td><input type='button' value="会員の退会"></td>
      </tr>
      </table>
-->

  </body>
</html>
