<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>口コミ</title>
</head>
<body>

	<h1>口コミ</h1>
		<p>評価</p>
	               
	                   
 	<p> 本のタイトル</p>   
		<form action="" method="post">
			レビュー名：<input type="text" name="" value="<%=request.getParameter("company") %>"><br>
			コメント：<input type="text" name="" " value="<%=request.getParameter("date") %>"><br>
			<textarea name="note" rows="10" cols="50" placeholder="内容を入力"><%=request.getParameter("note") %></textarea><br>
		</form>
		
		
<a href="./">戻る</a>
<input type="submit" value="送信">
</body>
</html>