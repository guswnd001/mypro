<%@page import="model.BoardDataBean"%>
<%@page import="dao.BoardDBBeanMysql"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
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
	int pageSize = 2;
	int aCount = dbPro.getArticleCount(boardid); 
	int startRow = (currentPage - 1) * pageSize;
	int endRow = currentPage * pageSize;
	int number = aCount - startRow;
	List articleList = dbPro.getArticles(startRow, pageSize, boardid);
	
	if (aCount < endRow) { endRow = aCount; }
	
%>

<div class="cart-table-area-3 section-padding-100">
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 col-lg-12" style="position: relative;">
				<div class="cart-title mt-50">
				
				<% if (boardid.equals("1")) { %>
					<h2>공지사항</h2>
				<% } else { %>
					<h2>Q & A</h2>
				<% } %>
				</div>
				<div class="cart-table clearfix" style="width: 1000px; position: absolute;">
					<div align="right" class="mb-3">
						<p><a href="b_writeForm.jsp">글쓰기</a></p>
					</div>
					<table class="table">
						<thead style="background-color: F5F7FA;">
							<tr style="font-size: 12px;">
								<th style="border: none;">&nbsp;번호</th>
								<th style="border: none;">&nbsp;제목</th>
								<th style="border: none;">&nbsp;작성자</th>
								<th style="border: none;">&nbsp;작성일</th>
								<th style="border: none; white-space: nowrap;">&nbsp;조회수</th>
								<th style="border: none;">&nbsp;IP</th>
							</tr>
						</thead>
						<tbody>
							<%
							if (aCount != 0) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
								for (int i = 0; i < articleList.size(); i++) {
									BoardDataBean article = (BoardDataBean)articleList.get(i);								
							%>
							<tr>
								<td style="border: none;">&nbsp;<%= (number--) %></td>
								<td style="border: none;">
								
									<%	if (article.getRe_level() > 0) { %>
										&nbsp;<img src="<%=request.getContextPath()%>/images/level.gif" width="<%=5*article.getRe_level()%>" height="16">
										<img src="<%=request.getContextPath()%>/images/re.gif">
									<% } %>
										<a href="b_content.jsp?num=<%= article.getNum() %>&pageNum=<%=pageNum%>&number=<%=number%>">
											<%= article.getSubject() %></a>
									<%	if (article.getReadcount() > 15) { %>
										<img src="<%=request.getContextPath()%>/images/hot.gif" border="0" height="16">
									<% } %>	
									
								</td>
								<td style="border: none;">&nbsp;<%= article.getWriter() %></td> 
								<td style="border: none;">&nbsp;<%= sdf.format(article.getReg_date()) %></td>
								<td style="border: none;">&nbsp;<%= article.getReadcount() %></td>
								<td style="border: none;">&nbsp;<%= article.getIp() %></td>
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
	</tbody>
	</table>
	
<%
	int bottomLine = 3;
	int pageCount = aCount / pageSize + (aCount % pageSize == 0? 0 : 1); //2
	int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine; //1
	int endPage = startPage + bottomLine - 1; //3
	if (pageCount < endPage) endPage = pageCount;
%>
<br>
<div class="row">
	<div class="col-12">
				<nav aria-label="navigation">
					<ul class="pagination justify-content-end mt-10">
<% if (startPage > bottomLine) { %> 
	<%-- <a href="b_list.jsp?pageNum=<%= startPage - bottomLine%>">[이전]</a> --%> 
	<li name="page" class="page-item">
		<a class="page-link" href="b_list.jsp?pageNum=<%= startPage - bottomLine%>">prev.</a>
	</li>
<% } %>

<% for (int i = startPage; i <= endPage; i++) { %> 
	<%-- <a href="b_list.jsp?pageNum=<%= i %>">[<%= i %>]</a> --%>
	<% if ( i < 10) { %>
	<li name="page" class="page-item">
		<a class="page-link" href="b_list.jsp?pageNum=<%= i %>"><%= "0" + i %>.</a>
	</li>
	<% } else { %>
	<li name="page" class="page-item">
		<a class="page-link" href="b_list.jsp?pageNum=<%= i %>"><%= i %>.</a>
	</li>
	<% } %>
<% } %>
	
<% if (endPage < pageCount) { %> 
	<%-- <a href="b_list.jsp?pageNum=<%= startPage + bottomLine %>">[다음]</a> --%> 
	<li name="page" class="page-item">
		<a class="page-link" href="b_list.jsp?pageNum=<%= startPage + bottomLine %>">next.</a>
	</li>
<% } %>

					</ul>
					
<script>
	var liTag = document.getElementsByName("page");
	
	if (<%=currentPage%> == null || <%=currentPage%> == "") {
	   	liTag[0].className += " active";
	} else if (<%=currentPage%> > <%=bottomLine%>) {
	   	liTag[<%=(currentPage - bottomLine)%>].className += " active"; 
	} else {
	   	liTag[<%=(currentPage - 1)%>].className += " active"; 
	}
</script>
					
				</nav>
</div>
</div>
</div>
</div>

		</div>
	</div>
</div>
</div>
</div>
