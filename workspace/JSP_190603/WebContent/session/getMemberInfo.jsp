<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 정보 조회</title>
</head>
<body>

아이디: <%= session.getAttribute("MEMBER_ID2") %> <br>
이름: <%= session.getAttribute("NAME2") %>

</body>
</html>