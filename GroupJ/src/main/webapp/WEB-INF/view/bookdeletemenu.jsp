<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>図書削除画面</title>
</head>
<body>
<h1>削除する図書のISBNを検索してください。</h1>
<form action="BookdeletesearchServlet" method="post">
		ISBN：<input type="text" name="isbn"><br>
		<input type="submit" value="検索">
		
	</form>
	<a href="Mastermenuback">メインメニューに戻る</a>
</body>
</html>