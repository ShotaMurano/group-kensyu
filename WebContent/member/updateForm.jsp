<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, redhot.tool.MyDBAccess"%>
<!DOCTYPE html>
<%
int id = Integer.parseInt(request.getParameter("id"));

String lastName = "";
String firstName = "";
String address = "";
String tellphone = "";
String birthday = "";
String mailAddress = "";
String outDate = "";


if (id != 0){
	MyDBAccess db = new MyDBAccess();
	db.open();

	String sql = "select * from users where id=" + id;
	ResultSet rs = db.getResultSet(sql);

	rs.next();
	lastName = rs.getString("last_name");
	firstName = rs.getString("first_name");
	address = rs.getString("address");
	tellphone = rs.getString("tellphone");
	birthday = (rs.getDate("birthday")).toString();
	mailAddress = rs.getString("mail_address");
	outDate = (rs.getDate("out_date")).toString();

	db.close();
}
%>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>会員情報変更</title>
  </head>
  <body>
    <h1>会員情報の更新</h1>
    <a href="" align="right">トップへ戻る</a>
    <a href="" align="right">ログアウト</a><br>

    <hr>
    <form action="/group-kensyu/MemberServlet" method="post">
      苗字　　　　　：<input type="text" name="lastName" value="<%= lastName %>">
      名前　　　　　：<input type="text" name="firstName" value="<%= firstName %>"><br>
      住所　　　　　：<input type="text" name="address" value="<%= address %>"><br>
      電話番号　　　：<input type="text" name="tellphone" value="<%= tellphone %>"><br>
      メールアドレス：<input type="text" name="mailAddress" value="<%= mailAddress %>"><br>
      生年月日　　　：<input type="text" name="birthday" value="<%= birthday %>"><br>
      退会年月日　　：<input type="text" name="outDate" value="<%= outDate %>"><br>
     <!--  身分証明書　　：<input type="file" name="" value=""><br><br>-->
     <input type="hidden" name="action" value="updateResult">
      <input type="submit" name="" value="確認画面へ"><br>
    </form>
  </body>
</html>