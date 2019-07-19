<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판 예제</title>
</head>
<body>

<%-- <c:if test="${! empty authUser }">
	${authUser.name }님, 안녕하세요.<br>
	<a href="logout.do">[로그아웃]</a>
	<a href="changePwd.do">[암호변경]</a>
</c:if>
<c:if test="${empty authUser }">
	<a href="join.do">[회원가입]</a>
	<a href="login.do">[로그인]</a>
</c:if> --%>

<%-- ${ctxPath = pageContext.request.contextPath; ''} --%>

<u:isLogin>
	CT: ${authUser.name }님, 안녕하세요.<br>
	<a href="logout.do">[로그아웃]</a>
	<a href="changePwd.do">[암호변경]</a>
	<%-- <a href="${ctxPath }/article/write.do">[글쓰기]</a> --%>
	<a href="article/write.do">[글 쓰기]</a>
	<a href="article/list.do">[글 목록 보기]</a>
</u:isLogin>
<u:notLogin>
	CT:
	<a href="join.do">[회원가입]</a>
	<a href="login.do">[로그인]</a>
	<a href="admin.do">[관리자]</a>
</u:notLogin>

</body>
</html>

<!-- 모델2란 뷰와 백단을 명확히 나누는 것 -->
<!-- 모델2는 이제 더이상 퍼포먼스가 좋지 않음, 스프링이 훨씬 좋음 -->



