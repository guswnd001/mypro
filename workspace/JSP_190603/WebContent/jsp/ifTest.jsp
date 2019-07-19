<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2>If-else문 예제 - 좋아하는 색 고르기</h2>
<% 
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String selectColor = "";
	
	if (color.equals("blue")) {
		selectColor = "파랑색";
	} else if (color.equals("green")) {
		selectColor = "초록색";
	} else if (color.equals("red")) {
		selectColor = "빨강색";
	} else {
		selectColor = "노란색";
	}
%>

선택한 색: <br>
<div style="border: 3px solid <%= color %>; padding: 3px; width: 50px; height: 50px;">
	<%= name %>님이 선택한 색은 <%= selectColor %>입니다.
</div>