package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/admin.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return FORM_VIEW;
	}
	
}
