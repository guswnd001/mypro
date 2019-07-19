<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function checkIt() {
		var userInput = eval("document.writeForm");
		
		if(!userInput.writer.value) { alert("이름을 입력하세요."); return false; }
		if(!userInput.subject.value) { alert("제목을 입력하세요."); return false; }
		if(!userInput.email.value) { alert("E-mail을 입력하세요."); return false; }
		if(!userInput.content.value) { alert("내용을 입력하세요."); return false; }
		if(!userInput.passwd.value) { alert("비밀번호를 입력하세요."); return false; }
	}
	
</script>
</head>
<body>

<div class="w3-container">
	<p>글쓰기 ></p>
	<form action="<%=request.getContextPath() %>/board/write.do" method="post" onsubmit="return checkIt()" name="writeForm">
		<!-- el앞뒤 밖에 띄어쓰기(' ')가 들어가면 안된다. -->
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="ref" value="${ref }">
		<input type="hidden" name="re_step" value="${re_step }">
		<input type="hidden" name="re_level" value="${re_level }">
		<br>
		<table class="w3-table-all w3-center" style="width: 70%; margin: auto;">
			<tr>
				<td colspan="2" style="text-align: center;">
					<u><b>글쓰기</b></u>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" size="10"></td>
			</tr>
			<tr>
				<td>제목</td>
				<!-- num이 이미 채워져 오기 때문에 null이 아닌 0으로 비교를 한다. -->
			<c:if test="${num == 0 }">
				<td><input type="text" name="subject" size="30" style="width: 70%;"></td>
			</c:if>
			<c:if test="${num > 0 }">
				<td><input type="text" name="subject" value="[답변]${subject}" 
					size="30" style="width: 70%;"></td>
			</c:if>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" size="30" style="width: 70%;"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="15" style="width: 70%; height: 100%;">
					</textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" size="10"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="글쓸래">
					<input type="reset" value="다시입력">
					<input type="button" value="목록보기"
						   onclick="window.location='<%=request.getContextPath()%>/board/list.do?pageNum=${pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>