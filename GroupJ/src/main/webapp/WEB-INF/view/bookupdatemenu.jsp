<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書編集画面</title>
</head>
<body>
		<form action="BooksearchactionServlet" method="post">
        図書名/ISBN
	 	<input type="text" name="keyword" ><br>
		
		<input type="submit" value="検索">
		
	</form>
	<a href="RootTopmenuBackServlt">戻る</a>
</body>
</html>