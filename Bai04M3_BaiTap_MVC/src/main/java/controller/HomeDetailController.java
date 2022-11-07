package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import model.ProductRepository;

@WebServlet("/home/detail.html")
public class HomeDetailController extends HttpServlet {
	ProductRepository repository = new ProductRepository();

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("o", repository.getProduct(id));
			request.getRequestDispatcher("/views/home/detail.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
