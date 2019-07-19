<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	if (pageNum == null || pageNum == "") {
		pageNum = "1";
	}
	
	BoardDataBean article = dbPro.getArticle(num, boardid);
%>

<br>
<div class="w3-container">
	<table class="w3-table-all w3-center" style="width: 70%; margin: auto;">
		<tr>
			<td>글 번호</td>
			<td><%= article.getNum() %></td>
			<td>조회수</td>
			<td><%= article.getReadcount() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%= article.getWriter() %></td>
			<td>작성일</td>
			<td><%= sdf.format(article.getReg_date()) %></td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td colspan="3"><%= article.getSubject() %></td>
		</tr>
		<tr height="80px">
			<td>글 내용</td>
			<td colspan="3"><%= article.getContent() %></td>
		</tr>
		<tr>
			<td>업로드한 파일이름</td>
			<td><%= article.getFilename() %></td>
			<td>파일 크기</td>
			<td><%= article.getFilesize() %></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center;">
				<input type="button" value="글수정"
					   onclick="document.location.href='updateForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">  
				<input type="button" value="글삭제"
					   onclick="document.location.href='deleteForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>'">
				<input type="button" value="답글쓰기"
					   onclick="document.location.href=
					   'writeForm.jsp?num=<%=num%>&pageNum=<%=pageNum%>&ref=<%=article.getRef()%>&re_step=<%=article.getRe_step()%>&re_level=<%=article.getRe_level()%>&subject=<%=article.getSubject()%>'">
				<input type="button" value="목록보기"
					   onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
				<!-- <input type="button" value="목록보기"
					   onclick="javascript:location.href=document.referrer"> -->
			</td>
		</tr>
	</table>
</body>
</html>