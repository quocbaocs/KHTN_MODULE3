package controller.frontend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.ProductBL;

@WebServlet(urlPatterns = {"/trang-chu",""})
public class HomeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeControllerServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int trang = 1;
		if (request.getParameter("trang") != null) {
			trang = Integer.parseInt(request.getParameter("trang"));
		}
		request.setAttribute("tongSoTrang", ProductBL.tongSoTrang(8));
		request.setAttribute("dssp", ProductBL.sanPhamTrang(trang, 8));
		request.getRequestDispatcher("views/frontend/home.jsp").forward(request, response);
	}

}
