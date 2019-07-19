<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2>While문 예제 - 임의 값을 임의의 횟수로 곱하기</h2>
<%
	int boxNum = Integer.parseInt(request.getParameter("boxNum"));
	String width = request.getParameter("width");
	String height = request.getParameter("height");
%>

box의 개수: <%= boxNum %> <br>
box width: <%= width %> <br>
box height: <%= height %> <p>
	
<%	
	for (int i = 0; i < boxNum; i++) {
		%> <div style="border: 3px solid black; margin: 5px; 
				width:<%= width %>; height:<%= height %>; float: left;"></div> <%
	}
%>