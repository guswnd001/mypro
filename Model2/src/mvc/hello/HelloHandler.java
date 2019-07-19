package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;


public class HelloHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("hello", "안녕하다구~");
		return "/WEB-INF/hello.jsp";
	}
	
}
