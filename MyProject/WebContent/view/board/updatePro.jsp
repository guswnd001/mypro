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


<jsp:useBean id="article" class="board.BoardDataBean">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%
	BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
	
	String pageNum = request.getParameter("pageNum");
	int check = dbPro.updateArticle(article, boardid);
	
%>

<%
	if (check == 1) {
%>
	<script>
		alert("게시글이 수정되었습니다.");
		location.href = "<%= request.getContextPath() %>/view/board/list.jsp?pageNum=<%=pageNum%>";
	</script>
	<%-- <meta http-equiv="Refresh" content="0;url=list.jsp?pageNum=<%=pageNum%>">--%>
<%
	} else {
%>
	<script>
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	</script>
<%	} %>

<%-- <script>
	alert("게시글이 수정되었습니다.");
	location.href = "<%= request.getContextPath() %>/view/board/list.jsp";
</script> --%>

</body>
</html>