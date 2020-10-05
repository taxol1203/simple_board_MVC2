<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Write Post</title>
</head>
<body>
	<form action="regist_proc" method="post">
		<p>
			<label>Title</label> <input type="text" name="title">
		</p>
		<p>
			<label>Writer</label> <input type="text" name="writer" size="15">
		</p>
		<label>content</label>
		<p>
			<textarea rows="15" cols="65" name="content"> </textarea>
		</p>
		<button type="submit">Enroll</button>
	</form>
</body>
</html>