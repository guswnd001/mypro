<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/plain; charset=UTF-8"%>
<% request.setCharacterEncoding("utf-8"); 
   String keyword = request.getParameter("keyword");
   List<String> keywords = new ArrayList<String>();
   keywords.add("AJAX");
   keywords.add("AJAX실전프로그래밍");
   keywords.add("자라");
   keywords.add("자바프로그래밍");
   keywords.add("자바서버페이지");
   keywords.add("자바스터디");
   keywords.add("자바서비스");
   keywords.add("자바캔");
   keywords.add("자바를 잡으라구~");
   keywords.add("자바초코칩프라푸치노");
   keywords.add("자바 그녀의 마음을");
   
   keyword = keyword.replaceAll(" ", "");
   String line = "";
   
   for (String str : keywords) {
	   if (str.contains(keyword))
		   line += "<p onclick=\"submitOk('" + str + "');\">" + str + "</p>";
   }
%><%=line%>