package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.ProductBL;
import javaBeans.Product;


@WebServlet("/ListProductController")
public class ListProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ListProductController() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> dspd = ProductBL.getAllProduct();
		request.setAttribute("listProduct", dspd);
		request.getRequestDispatcher("views/product.jsp").include(request, response);
	}

	
	
}
