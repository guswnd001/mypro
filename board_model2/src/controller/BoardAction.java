package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.msk.Action;

import dao.BoardDBBeanMybatis;
import dao.BoardDBBeanMysql;
import model.BoardDataBean;

public class BoardAction extends Action{

	public String listGET(HttpServletRequest req, HttpServletResponse res)  throws Exception { 
		System.out.println("===================================");
		BoardDBBeanMybatis dbPro = BoardDBBeanMybatis.getInstance();
		HttpSession session = req.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if (req.getParameter("boardid") != null) {
			session.setAttribute("boardid", req.getParameter("boardid"));
		}
		
		String boardid = (String)session.getAttribute("boardid");
		if (boardid == null || boardid == "") {
			boardid = "1";
		}
		
		String pageNum = req.getParameter("pageNum");
		if (pageNum == null || pageNum == "") {
			pageNum = "1";
		}
		
		session.setAttribute("pageNum", pageNum);
		
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 3;
		int aCount = dbPro.getArticleCount(boardid); 
		int startRow = (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		int number = aCount - startRow;
		List<BoardDataBean> articleList = dbPro.getArticles(startRow, pageSize, boardid);
		
		if (aCount < endRow) { endRow = aCount; }
		
		int bottomLine = 3;
		int pageCount = aCount / pageSize + (aCount % pageSize == 0? 0 : 1); //2
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine; //1
		int endPage = startPage + bottomLine - 1; //3
		if (pageCount < endPage) endPage = pageCount;
		
		req.setAttribute("aCount", aCount);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("number", number + 1);
		req.setAttribute("articleList", articleList); 
		req.setAttribute("startPage", startPage);
		req.setAttribute("bottomLine", bottomLine);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("endPage", endPage);
		req.setAttribute("sdf", sdf);
		
		return "/view/board/list.jsp";
	} 
	
	public String writeGET(HttpServletRequest req, HttpServletResponse res)  throws Exception { 
		int num = 0, ref = 1, re_step = 0, re_level = 0;

		String pageNum = req.getParameter("pageNum");
		String subject = req.getParameter("subject"); 
		if (pageNum == null || pageNum == "") { pageNum = "1"; }

		if (req.getParameter("num") != null) {
			num = Integer.parseInt(req.getParameter("num"));
			ref = Integer.parseInt(req.getParameter("ref"));
			re_step = Integer.parseInt(req.getParameter("re_step"));
			re_level = Integer.parseInt(req.getParameter("re_level"));
		}
		
		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("ref", ref);
		req.setAttribute("re_step", re_step);
		req.setAttribute("re_level", re_level);
		req.setAttribute("subject", subject);
		
		return "/view/board/writeForm.jsp";
	} 
	
	public String writePOST(HttpServletRequest req, HttpServletResponse res)  throws Exception { 
		BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
		BoardDataBean article = new BoardDataBean();
		
		HttpSession session = req.getSession();
		String pageNum = req.getParameter("pageNum");	
		String boardid = (String)session.getAttribute("boardid");
		if (boardid == null || boardid == "") {
			boardid = "1";
		}
		
		article.setNum(Integer.parseInt(req.getParameter("num")));
		article.setWriter(req.getParameter("writer"));
		article.setSubject(req.getParameter("subject"));
		article.setEmail(req.getParameter("email"));
		article.setPasswd(req.getParameter("passwd"));
		article.setContent(req.getParameter("content").trim());
		article.setRef(Integer.parseInt(req.getParameter("ref")));
		article.setRe_level(Integer.parseInt(req.getParameter("re_level")));
		article.setRe_step(Integer.parseInt(req.getParameter("re_step")));
		article.setIp(req.getRemoteAddr());
		
		dbPro.insertArticle(article, boardid);
		
		try {
			res.sendRedirect(req.getContextPath() + "/board/list.do?pageNum=" + pageNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String contentGET(HttpServletRequest req, HttpServletResponse res)  throws Exception { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
		
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		if (pageNum == null || pageNum == "") { pageNum = "1"; }
		
		HttpSession session = req.getSession();
		String boardid = (String)session.getAttribute("boardid");
		if (boardid == null || boardid == "") { boardid = "1"; }
		
		BoardDataBean article = dbPro.getArticle(num, boardid);
		
		req.setAttribute("num", num);
		req.setAttribute("article", article);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("sdf", sdf);
		
		return "/view/board/content.jsp";
	} 
	
	public String updateGET(HttpServletRequest req, HttpServletResponse res) throws Exception { 
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
		
		return "/view/board/updateForm.jsp";
	}
	
	public String updatePOST(HttpServletRequest req, HttpServletResponse res) throws Exception { 
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
	
	public String deleteGET(HttpServletRequest req, HttpServletResponse res) throws Exception { 
		int num = Integer.parseInt(req.getParameter("num"));
		String pageNum = req.getParameter("pageNum");
		
		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		
		return "/view/board/deleteForm.jsp";
	} 
	
	public String deletePOST(HttpServletRequest req, HttpServletResponse res) throws Exception { 
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
