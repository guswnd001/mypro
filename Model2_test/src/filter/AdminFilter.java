package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminFilter implements Filter {
	

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession(true);
		//false는 session이 없을때 
		
		if (session.getAttribute("authUser") != null
				&& session.getAttribute("authUser").equals("admin")) {
			System.out.println(1);
			chain.doFilter(req, resp);
		} else {
			System.out.println(2);
			HttpServletResponse response = (HttpServletResponse)resp;
			response.sendRedirect(request.getContextPath() + "/login.do?msg=no");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException { }

	
	
	
}
