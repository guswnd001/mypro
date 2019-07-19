<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="w3-container">
	<span class="w3-center w3-large">
		<h3>(전체 글: ${aCount })</h3>
	</span>
	<p class="w3-right w3-padding-right-large">
		<a href="<%=request.getContextPath() %>/board/write.do">글쓰기</a>
	</p>
	<table class="w3-table-all">
		<tr class="w3-grey">
			<td align="center" width="50">번호</td>
			<td align="center" width="250">제목</td>
			<td align="center" width="100">작성자</td>
			<td align="center" width="150">작성일</td>
			<td align="center" width="50">조회수</td>
			<td align="center" width="100">IP</td>
		</tr>
		<c:if test="${aCount > 0 }">
		<c:forEach var="article" items="${articleList }">
		<tr height="30" align="center">
			<c:set var="number" value="${number-1 }"></c:set>
			<td><c:out value="${number }">${number }</c:out></td>
			<td>
			<c:if test="${ article.re_level > 0 }">
				<img src="<%=request.getContextPath()%>/images/level.gif" width="${ article.re_level * 5 }" height="16">
				<img src="<%=request.getContextPath()%>/images/re.gif">
			</c:if>
				<%-- <a href="<%=request.getContextPath()%>/board/content.do?num=${article.num }&pageNum=${pageNum}">${ article.subject }</a> --%>
				<a href="<%=request.getContextPath()%>/board/content.do?num=${article.num }&pageNum=${pageNum}">${ article.subject }</a>
			<c:if test="${ article.readcount >= 5 }">
				<img src="<%=request.getContextPath()%>/images/hot.gif" border="0" height="16">
			</c:if>
				
			</td>
			<td>${ article.writer }</td>
			<td>${ sdf.format(article.reg_date) }</td> 
			<td>${ article.readcount }</td>
			<td>${ article.ip }</td>
		</tr>
		</c:forEach>
		</c:if>
		
		<c:if test="${aCount == 0 }">
		<tr>
			<td colspan="6" style="text-align: center;">게시글이 없습니다.</td>
		</tr>
		</c:if>
	</table>
	

<br>
<div align="center">

<c:if test="${startPage > bottomLine }">
	<a href="<%=request.getContextPath() %>/board/list.do?pageNum=${startPage - bottomLine }">[이전]</a> 
</c:if>

<c:forEach var="i" begin="${startPage }" end="${endPage }">
	<a href="<%=request.getContextPath() %>/board/list.do?pageNum=${i }">[${i }]</a> 
</c:forEach>

<c:if test="${endPage < pageCount }">	
	<a href="<%=request.getContextPath() %>/board/list.do?pageNum=${startPage + bottomLine }">[다음]</a> 
</c:if>

</div>

</div>

</body>
</html>