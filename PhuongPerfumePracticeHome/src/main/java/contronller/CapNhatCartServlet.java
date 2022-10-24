package contronller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogics.SanPhamBL;
import businessLogics.ShoppingCart;
import javaBeans.SanPham;

@WebServlet("/update-cart")
public class CapNhatCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CapNhatCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println("quantity new : " + quantity);
		SanPham sp = SanPhamBL.docTheoID(id);

		HttpSession session = request.getSession();

		ShoppingCart shopingCart = (ShoppingCart) session.getAttribute("cart");
		shopingCart.updateQuantity(sp, quantity);
		shopingCart.getQuantity(sp);

		response.sendRedirect("trang-gio-hang.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
