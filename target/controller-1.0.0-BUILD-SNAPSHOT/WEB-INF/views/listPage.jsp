<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Board</title>
</head>

<body>
	<form action="regist" method="get">
		<table border="1" width="880">
			<tr>
				<td width="77">
					<p align="center">Index</p>
				</td>
				<td width="327">
					<p align="center">Title</p>
				</td>
				<td width="197">
					<p align="center">Writer</p>
				</td>
				<td width="155">
					<p align="center">Date</p>
				</td>
				<td width="90">
					<p align="center">ViewCount</p>
				</td>
			</tr>

			<c:forEach items="${list}" var="boardVO">
				<tr>
					<td>${boardVO.bno}</td>
					<td><a href='/read?bno=${boardVO.bno}'> ${boardVO.title} </a></td>
					<td>${boardVO.writer }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardVO.regdate }" /></td>
					<td><span class="badge bg-red"> ${boardVO.viewcnt }</span></td>
				</tr>
			</c:forEach>
		</table>

		<c:if test="${pageMaker.prev }">
			<a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1 }">
				« </a>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="idx">
			<c:out value="${pageMaker.cri.page == idx?'':''}" />
			<a href="listPage${pageMaker.makeQuery(idx)}">${idx}</a>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<a href="listPage${pageMaker.makeQuery(pageMaker.endPage +1) }">
				» </a>
		</c:if>
		<br>

		<button type="submit">Write Post</button>
	</form>
</body>

</html>