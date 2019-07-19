<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<table>
	<tr>
		<td>
			<%=request.getParameter("name") %>
			<font color="red">sample jsp</font>
		</td>
	</tr>
</table>