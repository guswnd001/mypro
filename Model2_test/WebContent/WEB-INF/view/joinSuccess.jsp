<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 완료</title>
</head>
<body>

${param.name}님, 회원가입에 성공했습니다.<br>
<a href="<%=request.getContextPath()%>/index.jsp">[홈으로 가기]</a>

</body>
</html>