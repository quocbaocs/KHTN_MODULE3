package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import businessLogics.ProductBL;
import form.Pagination;
import javaBeans.Product;


@WebServlet("/ListProductController")
public class ListProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ListProductController() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int p = 1;
		if (request.getParameter("p") != null) {
			p = Integer.parseInt(request.getParameter("p"));
		}
		request.setAttribute("listProduct", ProductBL.sanPhamTrang(p,8));
		request.getRequestDispatcher("views/product.jsp").include(request, response);
	}

	
	
}
