<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書検索画面</title>
</head>
<body>
<h1>図書検索</h1>
<form action="BooksearchactionServlet" method="post">
        検索したい図書に関するタイトル、カナタイトル、著者を入力してください。
	 	<input type="text" name="keyword" ><br>
		
		<input type="submit" value="検索">
		
	</form>
	<a href="RootTopmenuBackServlt">戻る</a>
</body>
</html>