<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <title>ログイン</title>

  </head>
  <body>
<!--
    <h1>ログインページ</h1>
    <hr>
    <form action="/group-kensyu/LoginServlet" method="post">
    <dl>
     <dt>ID：</dt>
     <dd><input type="number" name="id"></dd>
      <dt>パスワード：</dt>
      <dd><input type="password" name="password"><dd>
      <input type="hidden" name="action" value="login">
      <input type="submit" value="ログイン"><br>
      </dl>
    </form>
    -->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class = "container">
	<div class="wrapper">
		<form action="/group-kensyu/LoginServlet" method="post" name="Login_Form" class="form-signin">
		    <h3 class="form-signin-heading">図書管理システム</h3>
			  <hr class="colorgraph"><br>

			  <input type="text" class="form-control" name="id" placeholder="ID" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="password" required=""/>
 			<input type="hidden" name="action" value="login">
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="login" type="Submit">Login</button>
		</form>
	</div>
</div>

  </body>
</html>