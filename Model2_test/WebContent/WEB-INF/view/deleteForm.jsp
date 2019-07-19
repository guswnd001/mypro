<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<form action="delete.do" method="post">
	<input type="hidden" name="no" value="${modReq.articleNumber }">
	<c:if test="${errors.idOrPwNotMatch}">
		암호가 일치하지 않습니다.
	</c:if>
<p>
	암호:<br/><input type="password" name="password">
	<c:if test="${errors.password}">암호를 입력하세요.</c:if>
</p>
	<input type="submit" value="삭제">
</form>

</body>
</html>