package handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDBBeanMysql;
import model.BoardDataBean;

public class UpdateHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/view/board/updateForm.jsp";

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
		HttpSession session = req.getSession();
		String boardid = (String)session.getAttribute("boardid");
		if (boardid == null || boardid == "") { boardid = "1"; }
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
		BoardDataBean article =  dbPro.getUpdate(num, boardid);

		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("article", article);
		
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String num = req.getParameter("num");
		String pageNum = req.getParameter("pageNum");
		String boardid = (String)session.getAttribute("boardid");
		if (boardid == null || boardid == "") { boardid = "1"; }
		
		BoardDataBean article = new BoardDataBean();
		article.setNum(Integer.parseInt(num));
		article.setWriter(req.getParameter("writer"));
		article.setEmail(req.getParameter("email"));
		article.setSubject(req.getParameter("subject"));
		article.setPasswd(req.getParameter("passwd"));
		article.setContent(req.getParameter("content"));
		
		
		BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
		int check = dbPro.updateArticle(article, boardid);
		
		req.setAttribute("check", check);
		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		
		return "/view/board/updatePro.jsp";
	}
	
}
