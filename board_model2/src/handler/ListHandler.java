package handler;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDBBeanMysql;
import model.BoardDataBean;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		BoardDBBeanMysql dbPro = BoardDBBeanMysql.getInstance();
		HttpSession session = req.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
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

}
