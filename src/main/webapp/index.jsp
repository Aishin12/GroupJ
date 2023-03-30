<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
%>

	<div class="text-center">
	<h1>ログイン</h1>
	<a href="User_RegisterFormServlet">新規登録はこちら</a>
	<p style="color:red">※入力されたメールアドレス、またはパスワードに誤りがあります。</p>
	<p>メールアドレスとパスワードを入力してください</p>
	<form action="User_LoginServlet" method="post">
		メールアドレス：<input type="email" name="mail"><br>
		パスワード：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="User_ChangePassFormServlet">パスワードを忘れた場合</a><br>
	<%
		} else {
	%>
	<h1>ログイン</h1>
	<a href="User_RegisterFormServlet">新規登録はこちら</a>
	<p>メールアドレスとパスワードを入力してください</p>
	<form action="User_LoginServlet" method="post">
		メールアドレス：<input type="email" name="mail"><br>
		パスワード：<input type="password" name="pw"><br>
		<input type="submit" value="ログイン">
	</form>
	<a href="User_ChangePassFormServlet">パスワードを忘れた場合</a><br>
	<%
		}
	%>
	</div>
</body>
</html>