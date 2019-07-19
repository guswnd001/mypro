<%@page import="java.text.SimpleDateFormat"%>
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


<br>
<div class="w3-container">
	<table class="w3-table-all w3-center" style="width: 70%; margin: auto;">
		<tr>
			<td>글 번호</td>
			<td>${num }</td>
			<td>조회수</td>
			<td>${article.readcount }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${article.writer }</td>
			<td>작성일</td>
			<td>${sdf.format(article.reg_date) }</td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td colspan="3">${article.subject }</td>
		</tr>
		<tr height="80px">
			<td>글 내용</td>
			<td colspan="3">${article.content }</td>
		</tr>
		<tr>
			<td>업로드한 파일이름</td>
			<td>${article.filename }</td>
			<td>파일 크기</td>
			<td>${article.filesize }</td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<input type="button" value="글수정"
					   onclick="document.location.href=
					   '<%=request.getContextPath() %>/board/update.do?num=${num}&pageNum=${pageNum}'">  
				<input type="button" value="글삭제"
					   onclick="document.location.href=
					   '<%=request.getContextPath() %>/board/delete.do?num=${num}&pageNum=${pageNum}'">
				<input type="button" value="답글쓰기"
					   onclick="document.location.href=
					   '<%=request.getContextPath() %>/board/write.do?num=${num}&pageNum=${pageNum}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}&subject=${article.subject}'">
				<input type="button" value="목록보기"
					   onclick="document.location.href=
					   '<%=request.getContextPath() %>/board/list.do?pageNum=${pageNum}'">
				<!-- <input type="button" value="목록보기"
					   onclick="javascript:location.href=document.referrer"> -->
			</td>
		</tr>
	</table>
</body>
</html>