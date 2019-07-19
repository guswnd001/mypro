package mvc.writeForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class WriteFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("input", "게시판 입력했다구~");
		return "/WEB-INF/writeForm.jsp";
	}
	
}
