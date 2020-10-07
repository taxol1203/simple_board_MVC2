<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify post</title>
</head>
<body>
	<form action="modify_ok" method="post">
		<p>
			<label> Index </label> <input type="text" name="bno"
				value="${boardVO.bno }" readonly="readonly">
		</p>
		<p>
			<label> Title </label> <input type="text" name="title"
				style="background-color: #B0E0E6;" value="${boardVO.title }">
		</p>
		<p>
			<label> Writer </label> <input type="text" name="writer" size="15"
				value="${boardVO.writer }">
		</p>

		<label> Content </label>
		<textarea name=content rows="10" cols="70"
			style="background-color: #B0E0E6;">
				${boardVO.content }
		</textarea>
		<br>

		<button type="submit">완료</button>
	</form>
</body>
</html>