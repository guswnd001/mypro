package handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.DeleteFailException;
import model.DeleteRequest;
import model.User;
import service.DeleteArticleService;

public class DeleteArticleHandler implements CommandHandler {


	private static final String FORM_VIEW = "/WEB-INF/view/deleteForm.jsp";
	private DeleteArticleService deleteService = new DeleteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception { 
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); 
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		User authUser = (User)req.getSession().getAttribute("authUser");
		String id = authUser.getId();
		String password = trim(req.getParameter("password"));
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		DeleteRequest delReq = new DeleteRequest(id, no);
		
		req.setAttribute("delReq", delReq);
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		req.setAttribute("noVal", noVal);
		
		if (password == null || password.isEmpty()) { errors.put("password", Boolean.TRUE); }
		if (!errors.isEmpty()) { return FORM_VIEW; }
		
		try {
			deleteService.delete(no, delReq);
			return "/WEB-INF/view/deleteSuccess.jsp";
		} catch (DeleteFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
	
	private String trim(String str) {
		return str == null ? null : str.trim();
	}
	
}
