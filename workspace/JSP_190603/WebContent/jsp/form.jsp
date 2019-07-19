<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>폼 생성</title>
</head>
<body>
	<form action="/JSP_190603/JSP/viewParameter.jsp" method="post">
		이름: <input type="text" name="name" size="10"> <br>
		주소: <input type="text" name="address" size="20"> <br>
		가장 많이 조는 애: 
			<input type="checkbox" name="student" value="리승주">리승주
			<input type="checkbox" name="student" value="김주호이">김주호
			<input type="checkbox" name="student" value="봑성범">박성범
		<br>
		<input type="submit" value="전송"> 
	</form>
</body>
</html>