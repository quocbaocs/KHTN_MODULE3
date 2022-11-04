package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Vd2Servlet")
public class Vd2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public Vd2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String ten = request.getParameter("ten");
		String lc = "Chào mừng bạn " + ten + " đến với lập trình AJAX (doGet)";
		response.getWriter().print(lc);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
