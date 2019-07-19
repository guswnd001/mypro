<%@page import="board.BoardDataBean"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.Connection"%>
<%@page import="board.BoardDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	request.setCharacterEncoding("utf-8");

	String realFolder = "";
	String encType = "utf-8";
	int maxSize = 5 * 1024 * 1024;
	ServletContext context = request.getServletContext();
	realFolder = context.getRealPath("fileSave");
	
	MultipartRequest multi = null;
	multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	Enumeration files = multi.getFileNames();
	String filename = "";
	File file = null;
	
	while (files.hasMoreElements()) {
		String name = (String)files.nextElement();
		filename = multi.getFilesystemName(name);
		String original = multi.getOriginalFileName(name);
		file = multi.getFile(name);
	}
	
	int num = 0, ref = 1, re_step = 0, re_level = 0;
	
	if (multi.getParameter("num") != null) {
		num = Integer.parseInt(multi.getParameter("num"));
		ref = Integer.parseInt(multi.getParameter("ref"));
		re_step = Integer.parseInt(multi.getParameter("re_step"));
		re_level = Integer.parseInt(multi.getParameter("re_level"));
	}
	
	BoardDataBean article = new BoardDataBean();
	
	article.setNum(num);
	article.setRef(ref);
	article.setRe_step(re_step);
	article.setRe_level(re_level);
	article.setWriter(multi.getParameter("writer"));
	article.setEmail(multi.getParameter("email"));
	article.setSubject(multi.getParameter("subject"));
	article.setPasswd(multi.getParameter("passwd"));
	article.setContent(multi.getParameter("content"));
	article.setBoardid("1");
	
	if (filename != null) article.setFilename(filename); else article.setFilename(" ");
	if (file != null) article.setFilesize((int)file.length()); else article.setFilesize(0);
	
	article.setIp(request.getRemoteAddr());
	
	System.out.println(article);
	
	BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
	dbPro.insertArticle(article, "1");
	
%>

<script>
	alert("파일이 업로드되었습니다.");
	location.href = "<%=request.getContextPath()%>/view/board/list.jsp";
</script>

</body>
</html>