package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductRepository;

/**
 * Servlet implementation class HomeSearchController
 */
@WebServlet("/home/search.html")
public class HomeSearchController extends HttpServlet {
	ProductRepository repository = new ProductRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("list", repository.search(request.getParameter("q")));
			request.getRequestDispatcher("/views/home/search.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
