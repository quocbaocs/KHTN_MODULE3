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

@WebServlet("/add-to-cart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int quantity;

		if (request.getParameter("id") != null) {
			if (request.getParameter("quantity") == null) {
				quantity = 1;
			}else {
				quantity = Integer.parseInt(request.getParameter("quantity"));
			}

			int id = Integer.parseInt(request.getParameter("id"));

			SanPham sp = SanPhamBL.docTheoID(id);

			HttpSession session = request.getSession();
			Object cart = session.getAttribute("cart");
			ShoppingCart shoppingCart = null;

			if (cart != null && cart instanceof ShoppingCart) {
				shoppingCart = (ShoppingCart) cart;
				shoppingCart.addCart(sp, quantity);
			} else {
				shoppingCart = new ShoppingCart();
			}
			session.setAttribute("cart", shoppingCart);
		}
		String page = request.getHeader("referer");
		String currentPage = page.substring(page.lastIndexOf("/")+1);
		response.sendRedirect(currentPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		request.setAttribute("dsTim", SanPhamBL.docTheoTen(keyword));
		doGet(request, response);
	}

}
