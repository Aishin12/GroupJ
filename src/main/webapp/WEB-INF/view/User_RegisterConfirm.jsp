<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserAccount" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>
<h2 class="register-confirm-title">下記の内容で登録します。</h2>
<%
	UserAccount ua = (UserAccount)session.getAttribute("input_user");
%>
	名前:<%=ua.getName() %><br>
	生年月日:<%=ua.getYear() %>年<%=ua.getMonth() %>月<%=ua.getDay() %>日<br>
	性別:<% int genNum = ua.getGender();
			if(genNum == 0){
		 %>
		 男
		<% }else{ %>
		女
		<%} %><br>
	メールアドレス:<%=ua.getMail() %><br>
	パスワード:********<br>
	<a href= "User_RegisterExecuteServlet">OK</a><br>
	<a href= "User_RegisterFormServlet">戻る</a>	
</body>
</html>