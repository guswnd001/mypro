package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.ArticleContentNotFoundException;
import exception.ArticleNotFoundException;
import model.ArticleData;
import model.ArticlePage;
import service.ListArticleService;
import service.ReadArticleService;

public class ReadArticleHandler implements CommandHandler {
	
	private ReadArticleService readService = new ReadArticleService(); 

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData); //view로 전달
			return "/WEB-INF/view/readArticle.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	
	
}
