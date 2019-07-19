<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDataBean"%>
<%@page import="java.util.List"%>
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
	BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
	
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null || pageNum == "") {
		pageNum = "1";
	}
	
	session.setAttribute("pageNum", pageNum);
	
	int currentPage = Integer.parseInt(pageNum);
	int pageSize = 3;
	int aCount = dbPro.getArticleCount(boardid); 
	int startRow = (currentPage - 1) * pageSize;
	int endRow = currentPage * pageSize;
	int number = aCount - startRow;
	List articleList = dbPro.getArticles(startRow, pageSize, boardid);
	
	if (aCount < endRow) { endRow = aCount; }
	
%>

<div class="w3-container">
	<span class="w3-center w3-large">
		<h3>(전체 글: <%= aCount %> )</h3>
	</span>
	<p class="w3-right w3-padding-right-large">
		<a href="writeForm.jsp">글쓰기</a>
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
<%
		if (aCount != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");		
			for (int i = 0; i < articleList.size(); i++) {
				BoardDataBean article = (BoardDataBean)articleList.get(i);
%>
		<tr height="30">
			<td><%= (number--) %></td>
			<%-- <td><%= article.getNum() %></td> --%>
			<td>
			<%	if (article.getRe_level() > 0) { %>
				<img src="<%=request.getContextPath()%>/images/level.gif" width="<%=5*article.getRe_level()%>" height="16">
				<img src="<%=request.getContextPath()%>/images/re.gif">
			<% } %>
				<a href="content.jsp?num=<%= article.getNum() %>&pageNum=<%=pageNum%>"><%= article.getSubject() %></a>
			<%	if (article.getReadcount() > 5) { %>
				<img src="<%=request.getContextPath()%>/images/hot.gif" border="0" height="16">
			<% } %>	
				
			</td>
			<td><%= article.getWriter() %></td>
			<td><%= sdf.format(article.getReg_date()) %></td> 
			<td><%= article.getReadcount() %></td>
			<td><%= article.getIp() %></td>
		</tr>
<%
			}
		} else {
%>
		<tr>
			<td colspan="6" style="text-align: center;">게시글이 없습니다.</td>
		</tr>
<%
	}
%>
	</table>
	
<%
	int bottomLine = 3;
	int pageCount = aCount / pageSize + (aCount % pageSize == 0? 0 : 1); //2
	int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine; //1
	int endPage = startPage + bottomLine - 1; //3
	if (pageCount < endPage) endPage = pageCount;
%>
<br>
<div align="center">

<% if (startPage > bottomLine) { %> 
	<a href="list.jsp?pageNum=<%= startPage - bottomLine%>">[이전]</a> 
<% } %>

<% for (int i = startPage; i <= endPage; i++) { %> 
	<a href="list.jsp?pageNum=<%= i %>">[<%= i %>]</a> 
<% } %>
	
<% if (endPage < pageCount) { %> 
	<a href="list.jsp?pageNum=<%= startPage + bottomLine %>">[다음]</a> 
<% } %>

</div>

</div>

</body>
</html>