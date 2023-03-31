<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.BookDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書検索結果</title>
</head>
<body>
<table border="1">
		<tr>
			<th>図書名</th>
			<th>カナ図書名</th>
			<th>著者</th>
			
		</tr>
	<%
	List<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
	for(BookDTO b : list) {
	%>
	
	<tr>
	<td><%=b.getTitle()%></td>
	<td><%=b.getKana_title()%></td>
	<td><%=b.getAuthor()%></td>
	</tr>
	<%} %>
	
	</table>
	<a href="RootTopmenuBack">メインメニューに戻る</a>
</body>
</html>