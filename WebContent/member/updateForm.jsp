<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, redhot.tool.MyDBAccess"%>
<!DOCTYPE html>
<%
int id = Integer.parseInt(request.getParameter("member.id"));

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
	if(rs.getDate("out_date")!=null)
	{
	outDate = (rs.getDate("out_date")).toString();
	}

	db.close();
}
%>
<html lang="ja" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>会員情報変更</title>
<jsp:include page="../header.jsp" />
</head>
<body>
<jsp:include page="../body.jsp" />
    <h1>会員情報の更新</h1>
    <hr>
    <form action="/group-kensyu/MemberServlet" method="post">
 	<input type="hidden" name="id" value="<%= String.valueOf(id)%>">
      苗字　　　　　：<input type="text" name="lastName" value="<%= lastName %>"required="">
      名前　　　　　：<input type="text" name="firstName" value="<%= firstName %>"required=""><br>
      住所　　　　　：<input type="text" name="address" value="<%= address %>"required=""><br>
      電話番号　　　：<input type="text" name="tellphone" value="<%= tellphone %>"required=""><br>
      メールアドレス：<input type="text" name="mailAddress" value="<%= mailAddress %>"required=""><br>
      生年月日　　　：<input type="text" name="birthday" value="<%= birthday %>"required=""><br>
      退会年月日　　：<input type="text" name="outDate" value="<%= outDate %>"><br>
     <input type="hidden" name="action" value="updateResults">
      <input type="submit" name="" value="確認画面へ"><br>
    </form>
  </body>
</html>