package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/Vd6Servlet", initParams = { @WebInitParam(name = "TenND", value = "Tran Vi tinh") })

public class Vd6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Vd6Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig sc = getServletConfig();
		String tenND = sc.getInitParameter("tenND");
		ServletContext context = getServletContext();
		String tenDV = context.getInitParameter("TenDV");
		response.getWriter().append("Served at: ").append(request.getContextPath() + "\n").append("\nTen ND : " + tenND)
				.append("\nTen DV :" + tenDV);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
