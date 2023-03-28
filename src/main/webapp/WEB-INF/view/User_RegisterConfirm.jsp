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
	UserAccount account = (UserAccount)session.getAttribute("input_user");
	String fullName = account.getName();
	String[] names = fullName.split(" ");

	String birth = account.getBirth();
	String year = birth.substring(0,4);
	String month = birth.substring(4,6);
	String day = birth.substring(6);
%>
	名前:<%=names[0] %> <%=names[1] %><br>
	生年月日:<%=year %>年<%=month %>月<%=day %>日<br>
	性別:<% int genNum = account.getGender();
			if(genNum == 0){
		 %>
		 男
		<% }else{ %>
		女
		<%} %><br>
	メールアドレス:<%=account.getMail() %><br>
	パスワード:********<br>
	<a href= "User_RegisterExecuteServlet">OK</a><br>
	<a href= "User_RegisterFormServlet">戻る</a>	
</body>
</html>