<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>If-else문 예제 - 좋아하는 색 고르기</h2>
<form method="post" action="ifTest.jsp">
	이름 입력: <input type="text" name="name"> <p>
	색    선택: 
		<select name="color">
			<option value="blue" selected>파랑색</option>
			<option value="green">초록색</option>
			<option value="red">빨강색</option>
			<option value="yellow">노란색</option>
		</select> <p>
	<input type="submit" value="확인">
</form>