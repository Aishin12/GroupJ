<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワードの再設定</title>
</head>
<body>
<p>新しいパスワードを入力してください。</p>
<form action="User_AccountPassResetExecuteServlet" method="post">
	<input type="password" name = "pw">
	<input type="submit" value="変更">
</form>
</body>
</html>