<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="height: 90px">

	<a id="skippy" class="sr-only sr-only-focusable" href="#content">
		<div class="container">
			<span class="skiplink-text">Skip to main content</span>
		</div>
	</a>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="/group-kensyu/topPage.jsp">Librarian's Manager</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">会員管理</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/group-kensyu/member/addMember.jsp">新規登録</a>
						<a class="dropdown-item" href="/group-kensyu/member/search.jsp">検索</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">資料管理</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/group-kensyu/book/rental.jsp">貸出</a>
						<a class="dropdown-item" href="/group-kensyu/book/7_1_book_return_info_V2.jsp">返却</a>
						<a class="dropdown-item" href="/group-kensyu/book/add_isbnCheck.jsp">追加</a>
						<a class="dropdown-item" href="/group-kensyu/book/search.jsp">検索</a>
					</div></li>
				<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">予約管理</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/group-kensyu/book/search_returned_book.jsp">返却資料一覧</a>
					</div></li>
			</ul>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">マイメニュー</a>
				<div class="dropdown-menu">
				<a class="dropdown-item" href="/group-kensyu/Logout.jsp">ログアウト</a>
				</form>



				</div></li>
		</div>
	</nav>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script>
  window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="/docs/4.3/assets/js/vendor/anchor.min.js"></script>
<script src="/docs/4.3/assets/js/vendor/clipboard.min.js"></script>
<script src="/docs/4.3/assets/js/vendor/bs-custom-file-input.min.js"></script>
<script src="/docs/4.3/assets/js/src/application.js"></script>
<script src="/docs/4.3/assets/js/src/search.js"></script>
<script src="/docs/4.3/assets/js/src/ie-emulation-modes-warning.js"></script>