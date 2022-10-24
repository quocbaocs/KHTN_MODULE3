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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/VdFilter1")
public class VdFilter1 implements Filter {

	public VdFilter1() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// lay pathinfo: request.getPathInfo() khong co
		HttpServletRequest req = (HttpServletRequest) request;
		
		String pathInfo = req.getPathInfo();
		System.out.println("PathInfo la: " + pathInfo);
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();// lay thong tin dang nhap dung session
		
		String uri = req.getRequestURI();
		System.out.println("Trang goi den  : " + uri);
		if(uri.equals("/PhuongPerfumeM3/trang-cua-hang.jsp")) {
			resp.sendRedirect("trang-chu.jsp");
		}else {

		
		chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
