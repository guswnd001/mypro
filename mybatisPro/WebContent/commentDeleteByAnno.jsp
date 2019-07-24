<%@page import="java.util.Calendar"%>
<%@page import="session.CommentAnnotationRepository"%>
<%@page import="model.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//인터페이스만으로 매핑구문과 결과매핑 처리
//ldg.mybatis.repository.mapper.CommentMapper.insertComment(Comment)

Long commentNo = Long.parseLong(request.getParameter("commentNo"));
 
CommentAnnotationRepository commentService = new CommentAnnotationRepository();
Integer result = commentService.deleteComment(commentNo);
%>

<%=result %>