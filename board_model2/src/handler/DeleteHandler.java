package handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDBBeanMysql;
import model.BoardDataBean;

public class DeleteHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/board/deleteForm.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) 
															throws Exception {
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
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		String passwd = req.getParameter("passwd");
		
		BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
		int check = dbPro.deleteArticle(num, passwd);
		
		req.setAttribute("check", check);
		req.setAttribute("pageNum", pageNum);
		
		return "/view/board/deletePro.jsp";
	}
	
}
