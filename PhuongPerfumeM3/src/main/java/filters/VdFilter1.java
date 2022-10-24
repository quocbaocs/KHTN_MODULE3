package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/VdFilter1")
public class VdFilter1 implements Filter {

  
    public VdFilter1() {
      
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//lay pathinfo: request.getPathInfo() khong co
		HttpServletRequest req = (HttpServletRequest) request;
		String pathInfo = req.getPathInfo();
		System.out.println("PathInfo la: " +pathInfo);
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
