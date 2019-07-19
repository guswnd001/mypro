<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<div style="border: 1px solid orange;">
name:<%= request.getParameter("name") %><br>
city:<%= request.getParameter("city") %>
<%= request.getParameter("content") %></div>