<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<table border="1">
		<tr>
			<th>ID</th>
			<th>図書名</th>
			<th>カナ図書名</th>
			<th>著者</th>
			<th>出版社</th>
			<th>ISBN</th>
			
		</tr>
	<%
	List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO b : list) {
	%>
	
	<tr>
	<td><%=b.getId()%></td>
	<td><%=b.getTitle()%></td>
	<td><%=b.getKana_title()%></td>
	<td><%=b.getAuthor()%></td>
	<td><%=b.getPublisher()%></td>
	<td><%=b.getIsbn()%></td>
	</tr>
	<%} %>
	
	
	
	</table>
	<form action="BookdeleteactionServlet"method="get">
	

	IDを入力：<input type="text" name="bookid"><br>
		
<input type="submit" value="削除">
	<a href="RootTopmenuBack">メインメニューに戻る</a>
</body>
</html>