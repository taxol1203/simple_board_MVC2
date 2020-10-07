<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Board</title>
</head>
<body>
	<!-- 검색 창 -->
	<select name="searchType">
		<option value="n"
			<c:out value="${cri.searchType == null?'selected':'' }"/>>---</option>
		<option value="t"
			<c:out value="${cri.searchType eq 't'?'selected':''}"/>>제목</option>
		<option value="c"
			<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>내용</option>
		<option value="w"
			<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>작성자</option>
		<option value="tc"
			<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>제목+ 내용</option>
		<option value="cw"
			<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>내용	+ 작성자</option>
		<option value="tcw"
			<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>제목 + 내용 + 작성자</option>
	</select>
	<input type="text" name='keyword' id="keywordInput"	value='${cri.keyword }'>
	<button type="button" id='searchBtn'>검색</button>
	<table border="1" width="880">
		<tr>
			<td width="77">
				<p align="center">글번호</p>
			</td>
			<td width="327">
				<p align="center">제목</p>
			</td>
			<td width="197">
				<p align="center">작성자</p>
			</td>
			<td width="155">
				<p align="center">작성일</p>
			</td>
			<td width="90">
				<p align="center">조회수</p>
			</td>
		</tr>
		
		<c:forEach items="${list }" var = "boardVO">
			<tr>
				<td>${boardVO.bno } </td>
				<td><a href = '/read${pageMaker.makeSearch(pageMaker.cri.page) }&bno=${boardVO.bno}'>
					${boardVO.title }
				</a></td>
				<td>${boardVO.writer}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"	value="${boardVO.regdate}" /></td>
				<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pageMaker.prev}">
		<a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">«</a>
	</c:if>
	<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
		<c:out value="${pageMaker.cri.page == idx?'':''}" />
		<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
	</c:forEach>
	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<a href="list${pageMaker.makeSearch(pageMaker.endPage +1) }"> » </a>
	</c:if>
	<br>
	<button id="newBtn">글쓰기</button>
	
	<script type = "text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(
			function(){
				$('#searchBtn').on(
					"click", function(event){
						str = "list"
						+ '${pageMaker.makeQuery(1)}'
						+ "&searchType="
						+ $("select option:selected").val()
						+ "&keyword=" + encodeURIComponent($('#keywordInput').val());
						console.log(str);
						self.location = str;		
					});
				
				$('#newBtn').on("click", function(evt) {
					self.location = "regist";
					});
				
				
			});
	</script>
	
</body>
</html>