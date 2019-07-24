<%@page import="model.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="session.CommentSessionRepository"%>
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
	CommentSessionRepository csr = new CommentSessionRepository();
	//Map<String, Object> map = new HashMap<String, Object>();
	List<Comment> comments = csr.selectCommentByConditionForeach(null);
%>

<form action="commentForEach.jsp" method="post">

<% for (Comment c : comments) { %>
	번호: <input type="checkbox" name="commentNo" value="<%=c.getCommentNo()%>"> 
	<%= c.getCommentNo() %><br>
	사용자ID: <%= c.getUserId() %><br>
	등록날짜: <%= c.getRegDate() %><br>
	내용: <%= c.getCommentContent() %><br><br>
<% } %>

	<input type="submit" value="확인">

</form>

</body>
</html>