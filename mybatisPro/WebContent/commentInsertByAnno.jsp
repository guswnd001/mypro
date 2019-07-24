<%@page import="session.CommentAnnotationRepository"%>
<%@page import="java.util.Calendar"%>
<%@page import="model.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//인터페이스만으로 매핑구문과 결과매핑 처리
//ldg.mybatis.repository.mapper.CommentMapper.insertComment(Comment)

Long commentNo = Long.parseLong(request.getParameter("commentNo"));
String userId = request.getParameter("userId");
String commentContent = request.getParameter("commentContent");

Comment comment = 
	new Comment(commentNo, userId, Calendar.getInstance().getTime(), commentContent);  
CommentAnnotationRepository commentService = new CommentAnnotationRepository();
Integer result = commentService.insertComment(comment);
%>

<%=result %>