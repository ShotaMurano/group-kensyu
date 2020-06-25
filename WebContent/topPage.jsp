<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>TopPage</title>
<jsp:include page="header.jsp" />
</head>
<body>

<jsp:include page="body.jsp" />


<main role="main" class="container">

<form>
  <div class="form-group">
    <label for="name">名前</label>
    <input type="email" class="form-control" id="name" placeholder="名前">
    <label for="address">住所</label>
    <input type="email" class="form-control" id="address" placeholder="住所">
    <label for="mail">Eメールアドレス</label>
    <input type="email" class="form-control" id="mail" placeholder="Eメールアドレス">
  </div>

      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">検索</button>
</form>

<hr>
<div class="container">
  <div class="row">
    <div class="col-sm">
      3つの列の1列目
    </div>
    <div class="col-sm">
      3つの列の2列目
    </div>
    <div class="col-sm">
      3つの列の3列目
    </div>
    <div class="col-sm">
      3つの列の3列目
    </div>
    <div class="col-sm">
      3つの列の3列目
    </div>
    <div class="col-sm">
      3つの列の3列目
    </div>
  </div>
</div>


</main><!-- /.container -->
</body>
</html>