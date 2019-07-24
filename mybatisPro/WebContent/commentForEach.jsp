<%@page import="model.Comment"%>
<%@page import="java.util.ArrayList"%>
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
	String[] commentNos = request.getParameterValues("commentNo");
	CommentSessionRepository csr = new CommentSessionRepository();
	Map<String, Object> condition = new HashMap();
	/*
	List<Long> cs = new ArrayList();
	
	for (String commentNo : commentNos) {
		cs.add(Long.parseLong(commentNo));
	}
	*/
	condition.put("commentNos", commentNos);
	
	List<Comment> comments = csr.selectCommentByConditionForeach(condition);
	
	System.out.println(comments);
%>

<% for (Comment c : comments) { %>
	번호: <%= c.getCommentNo() %><br>
	사용자ID: <%= c.getUserId() %><br>
	등록날짜: <%= c.getRegDate() %><br>
	내용: <%= c.getCommentContent() %><br><br>
<% } %>


</body>
</html>