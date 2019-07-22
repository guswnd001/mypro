<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 모델 예제</title>
</head>
<body>
http://localhost:7080/board_model2/board/list.do
<% response.sendRedirect(request.getContextPath() + "/board/list.do?boardid=1"); %>

</body>
</html>

<!-- 모델2란 뷰와 백단을 명확히 나누는 것 -->
<!-- 모델2는 이제 더이상 퍼포먼스가 좋지 않음, 스프링이 훨씬 좋음 -->



