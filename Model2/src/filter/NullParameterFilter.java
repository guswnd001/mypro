package filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NullParameterFilter implements Filter { 

	private String[] parameterNames = null;

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		NullParameterRequestWrapper requestWrapper = new NullParameterRequestWrapper((HttpServletRequest) request);
		requestWrapper.checkNull(parameterNames);
		chain.doFilter(requestWrapper, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String names = filterConfig.getInitParameter("parameterNames");
		StringTokenizer st = new StringTokenizer(names, ", "); //id, name이 들어오지 
		parameterNames = new String[st.countTokens()]; //size는 2가 되지
		
		for (int i = 0; st.hasMoreTokens(); i++) {
			parameterNames[i] = st.nextToken(); //parameterNames에 각각 할당하지
		}
	}
	
	
	
}
