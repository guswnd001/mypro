<%@page import="board.BoardDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="article" class="board.BoardDataBean">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<!--  -->

<%
	BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
	
	String pageNum = request.getParameter("pageNum");	
	article.setIp(request.getRemoteAddr());
	dbPro.insertArticle(article, boardid);
	//response.sendRedirect("list.jsp");
%>

<script>
	alert("게시글이 작성되었습니다.");
	location.href = "<%=request.getContextPath()%>/view/board/list.jsp?pageNum=<%=pageNum%>";
</script>

</body>
</html>