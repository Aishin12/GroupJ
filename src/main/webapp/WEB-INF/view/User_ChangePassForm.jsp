<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワードの変更</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			UserAccount ac = (UserAccount)session.getAttribute("user");
%>
	<h2>パスワードの再設定</h2>
	<p class="" style="color:red">※パスワードが一致しません。</p>
	<form action="User_ChangePassConfirm" method="post">
		<p>メールアドレスをご入力ください。</p>
		<input type="email" name="mail1"><br>
		
		<p>確認のため、再度メールアドレスをご入力ください。</p>
		<input type="email" name="mail2"><br>
	
		<input type="submit" value="変更">
	</form>
	<a href="./">戻る</a>
<%
	}else{
%>
	<h2>パスワードの再設定</h2>
	<form action="User_ChangePassConfirm" method="post">
		<p>メールアドレスをご入力ください。</p>
		<input type="email" name="mail1"><br>
		
		<p>確認のため、再度メールアドレスをご入力ください。</p>
		<input type="email" name="mail2"><br>
		
		<input type="submit" value="変更">
	</form>
	<a href="./">戻る</a>
<%
	}
%>
</body>
</html>