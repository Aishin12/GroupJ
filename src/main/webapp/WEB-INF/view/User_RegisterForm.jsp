<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
	String errorCode = request.getParameter("error");
	if(errorCode != null && errorCode.equals("1")){
		UserAccount ac = (UserAccount)session.getAttribute("input_user");
		
		String fullName = ac.getName();
		String[] names = fullName.split(" ");
		
		String birth = ac.getBirth();
		String year = birth.substring(0,4);
		String month = birth.substring(4,6);
		String day = birth.substring(6);
%>
<h1>新規登録</h1>
<p class="" style="color:red">※登録された内容に誤りがあります。</p>
<form action="User_RegisterComfirmServlet" method="post">
<div class="">
	<span>姓</span>
	<span>名</span><br>
	<input type="text" name="last" value=<%=names[0] %>>
	<input type="text" name="first" value=<%=names[1] %>><br>
</div>

<div class="">
	<p>生年月日</p><br>
	<input type="text" maxlength="4" name="year" value=<%=year %>>年
	<input type="text" maxlength="2" name="month" value=<%=month %>>月
	<input type="text" maxlength="2" name="day" value=<%=day %>>日<br>
</div>

<div class="">
	<p >メールアドレス</p><br>	
	<input type="email" name="mail" value=<%=ac.getMail() %>><br>
</div>

<div class="">
	<p>性別</p>
	<% 
	 int num = ac.getGender();
	if(num == 0){ %>
		<input type="radio" name="gender" value="0" checked>男
		<input type="radio" name="gender" value="1">女<br>
	<% }else{ %>
		<input type="radio" name="gender" value="0">男
		<input type="radio" name="gender" value="1" checked>女<br>
	<% } %>
</div>

<div class="">
	<p>パスワード</p><br>
	<input type="password" name="pw">
</div>

<input type="submit" value="アカウント作成">
</form>
<a href="./">戻る</a>
<%
	}else{
%>
<h1>新規登録</h1>
<form action="User_RegisterComfirmServlet" method="post">
<div class="">
	<span>姓</span>
	<span>名</span><br>
	<input type="text" name="last">
	<input type="text" name="first"><br>
</div>

<div class="">
	<p>生年月日</p>
	<input type="text" maxlength="4" name="year">年
	<input type="text" maxlength="2" name="month">月
	<input type="text" maxlength="2" name="day">日<br>
</div>

<div class="">
	<p>メールアドレス</p>
	<input type="email" name="mail"><br>
</div>

<div class="">
	<p>性別</p>
	<input type="radio" name="gender" value="0">男
	<input type="radio" name="gender" value="1">女<br>
</div>

<div class="">
	<p>パスワード</p>
	<input type="password" name="pw">
</div>

<input type="submit" value="アカウント作成">
</form>
<a href="./">戻る</a>
<%} %>
</body>
</html>