package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Vd3Servlet")
public class Vd3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Vd3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String ten = request.getParameter("ten");
		String lc = "Chào mừng bạn " + ten + " đến với lập trình AJAX (doPost)";
		response.getWriter().print(lc);
	}

}
