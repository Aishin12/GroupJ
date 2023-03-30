<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>利用者情報の変更</title>
</head>
<body>
<%
	UserAccount account = (UserAccount)session.getAttribute("user");

	String fullName = account.getName();
	String[] names = fullName.split(" ");
	
	String birth = account.getBirth();
	String year = birth.substring(0,4);
	String month = birth.substring(4,6);
	String day = birth.substring(6);
%>
<h2>利用者情報の変更</h2>
<form action="User_AccountEditUpdateServlet" method="post">
	<p>姓名</p>
	<input type="text" name="last" value=<%=names[0] %>>
	<input type="text" name="first" value=<%=names[1] %>><br>
	
	<p>生年月日</p>
	<input type="text" name="year" value=<%=year %>>
	<input type="text" name="month" value=<%=month %>>
	<input type="text" name="day" value=<%=day %>><br>
	
	<p>性別</p>
	<% 
	 int num = account.getGender();
	if(num == 0){ %>
		<input type="radio" name="gender" value="0" checked>男
		<input type="radio" name="gender" value="1">女<br>
	<% }else{ %>
		<input type="radio" name="gender" value="0">男
		<input type="radio" name="gender" value="1" checked>女<br>
	<% } %>
	<input type="hidden" name="mail" value=<%=account.getMail() %>>
	<input type="hidden" name="pw" value=<%=account.getPw() %>>
	<input type="submit" value="変更">
</form>
<a href="User_TopServlet">戻る</a>
</body>
</html>