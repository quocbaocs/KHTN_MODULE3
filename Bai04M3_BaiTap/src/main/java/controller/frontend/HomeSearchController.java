package controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.ProductBL;
import javaBeans.Product;

@WebServlet("/home/search.html")
public class HomeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeSearchController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Product> dssp = ProductBL.search(keyword);
		request.setAttribute("dssp", dssp);
		request.getRequestDispatcher("/views/frontend/search.jsp").forward(request, response);
	}

}
