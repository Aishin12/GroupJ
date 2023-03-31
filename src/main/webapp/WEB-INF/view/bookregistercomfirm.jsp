<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
<p>下記の内容で登録します。よろしいですか？</p>
	<%
	BookDTO bd = (BookDTO)session.getAttribute("input_data");
	%>
	図書名：<%=bd.getTitle() %><br>
	カナ図書名：<%=bd.getKana_title() %><br>
	著者：<%=bd.getAuthor() %><br>
	ISBN：<%=bd.getIsbn() %><br>
	出版社：<%=bd.getPublisher() %><br>
	出版日：<%=bd.getPublication_date() %><br>
	<a href="BookRegisterExecuteServlet">OK</a><br>
	<a href="./">戻る</a>
</body>
</html>