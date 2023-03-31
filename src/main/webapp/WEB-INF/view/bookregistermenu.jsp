<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書登録画面</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
			String errorCode = request.getParameter("error");
			if(errorCode != null && errorCode.equals("1")){
		BookDTO bd = (BookDTO)session.getAttribute("input_data");
	%>
	<p style="color:red">登録に失敗しました。</p>
		<h1>図書登録</h1>
<form action="BookregisteractionServlet" method="post">
		図書名：<input type="text" name="title" ><br>
		カナ図書名：<input type="text" name="kana_title"><br>
		著者：<input type="text" name="author"><br>
		ISBN：<input type="text" name="isbn"><br>
		出版社：<input type="text" name="publisher"><br>
		出版日：<input type="date" name="publication_date"><br>
		<input type="submit" value="登録">
		
	<a href="./">戻る</a>
	</form>
	<%
		} else {
	%>
<body>
<h1>図書登録</h1>
<form action="BookregisteractionServlet" method="post">
		図書名：<input type="text" name="title" ><br>
		カナ図書名：<input type="text" name="kana_title"><br>
		著者：<input type="text" name="author"><br>
		ISBN：<input type="text" name="isbn"><br>
		出版社：<input type="text" name="publisher"><br>
		出版日：<input type="date" name="publication_date"><br>
		<input type="submit" value="登録">
		
	<a href="./">戻る</a>
	</form>
	<%
		}
	%>
</body>
</html>