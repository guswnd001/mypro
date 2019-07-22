<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<%
	request.setCharacterEncoding("utf-8");
	
	if (request.getParameter("boardid") != null) {
		session.setAttribute("boardid", request.getParameter("boardid"));
	}

	String boardid = (String)session.getAttribute("boardid");
	
	if (boardid == null) { boardid = "1"; } 
%>

<script>
	window.onload = function () {
		var atag = document.getElementsByTagName("a");
		var url = document.location.href.split("/");
		console.log(url);
		
		if (url[url.length-2] == "member") { atag[4].className += " w3-white"; }
		else if (url[url.length-2] == "chartjsPro") { atag[5].className += " w3-white"; }
		else if (url[url.length-2] == "awesomePro") { atag[6].className += " w3-white"; }
		else if (url[url.length-2] == "admin") { atag[7].className += " w3-white"; }
		else { atag[<%= boardid %>].className += " w3-white"; }
	}
</script>

<div class="w3-container">

<div class="w3-bar w3-blue-grey w3-large">
  <a href="<%= request.getContextPath() %>/view/member/main.jsp" class="w3-bar-item w3-button">Home</a>
  <a href="<%= request.getContextPath() %>/board/list.do?boardid=1" class="w3-bar-item w3-button">공지사항</a>
  <a href="<%= request.getContextPath() %>/board/list.do?boardid=2" class="w3-bar-item w3-button">자유게시판</a>
  <a href="<%= request.getContextPath() %>/board/list.do?boardid=3" class="w3-bar-item w3-button">Q&A</a>
  <a href="<%= request.getContextPath() %>/member/loginForm.do" class="w3-bar-item w3-button">회원될래</a>
  <a href="<%= request.getContextPath() %>/chartjsPro/bar_sample.do" class="w3-bar-item w3-button">BarGraph</a>
  <a href="<%= request.getContextPath() %>/awesomePro/awesomeCloud.do" class="w3-bar-item w3-button">WordCloud</a>
  
<%
 	String admin = (String)session.getAttribute("memId"); 
 	
 	if (admin != null && admin.equals("admin")) {
%>
		<a href="<%= request.getContextPath() %>/view/admin/memberList.jsp" class="w3-bar-item w3-button">Member List</a>
<%
 	}
%>
</div>

</div>
</body>
</html>
