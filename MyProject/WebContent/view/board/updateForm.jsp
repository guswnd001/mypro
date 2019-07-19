<%@page import="board.BoardDataBean"%>
<%@page import="board.BoardDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	
	
	BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
	BoardDataBean article =  dbPro.getUpdate(num, boardid);
%>

<div class="w3-container">
	<p>글 수정하기 ></p>
	<form action="updatePro.jsp" method="post" onsubmit="return checkIt()" name="writeForm">
		<input type="hidden" name="num" value="<%=num%>"> <!-- get방식으로 값을 보내기 위해 input type을 hidden으로 준다. -->
		<input type="hidden" name="pageNum" value="<%=pageNum%>">
		<br>
		<table class="w3-table-all w3-center" style="width: 70%; margin: auto;">
			<tr>
				<td>
					<u><b>글 번호 : <%=num%></b></u> 
				</td>
				<td><input type="hidden" name="num"
						   value="<%=article.getNum()%>">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="writer" size="10"
						   value="<%=article.getWriter()%>">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" size="30" style="width: 70%;"
						   value="<%=article.getSubject()%>"> 
				</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" size="30" style="width: 70%;"
						   value="<%=article.getEmail()%>">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" rows="15" 
							  style="width: 70%; height: 100%;"><%=article.getContent() %>
					</textarea>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="passwd" size="10" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="수정할래">
					<input type="reset" value="다시입력">
					<input type="button" value="목록보기"
						   onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>