<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%
	int num = 0, ref = 1, re_step = 0, re_level = 0;

	String pageNum = request.getParameter("pageNum");
	String subject = request.getParameter("subject"); 
	if (pageNum == null || pageNum == "") {
		pageNum = "1";
	}

	if (request.getParameter("num") != null) {
		num = Integer.parseInt(request.getParameter("num"));
		ref = Integer.parseInt(request.getParameter("ref"));
		re_step = Integer.parseInt(request.getParameter("re_step"));
		re_level = Integer.parseInt(request.getParameter("re_level"));
	}
%>

<div class="w3-container">
	<p>글쓰기 ></p>
	<form action="uploadPro.jsp" method="post" name="uploadForm" enctype="multipart/form-data">
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<input type="hidden" name="ref" value="<%=ref%>">
		<input type="hidden" name="re_step" value="<%=re_step%>">
		<input type="hidden" name="re_level" value="<%=re_level%>">
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
			<% if (request.getParameter("num") == null) { %>
				<td><input type="text" name="subject" size="30" style="width: 70%;"></td>
			<% } else { %>
				<td><input type="text" name="subject" value="[답변]<%=subject %>" size="30" style="width: 70%;"></td>
			<% } %>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" size="30" style="width: 70%;"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="15" style="width: 70%; height: 100%;"></textarea></td>
			</tr>
			<tr>
				<td align="center">파일 첨부</td>
				<td>
					<input type="file" size="40" maxlength="30" name="uploadfile">
				</td>
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
						   onclick="javascript:window.location='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>