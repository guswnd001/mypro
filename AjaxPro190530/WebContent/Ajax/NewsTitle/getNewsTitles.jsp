<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String[] titles = {
		"서재웅 완벽투구.. 게레로 3구 삼진",
		"리승주 이북자, 파리바게트에서 빵 훔치자 걸려..",
		"빵도둑으로 연행되던 리승주, 탈출 감행.."
	};
	for (int i = 0; i < titles.length; i++) {
%>		
<%	if (i == 0) { %><strong><% } %>
<%= titles[i] %>
<% if (i == 0) { %></strong><% } %>
<br/>
<%
	}
%>