package contronller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamBL;
import businessLogics.ShoppingCart;
import javaBeans.SanPham;

/**
 * Servlet implementation class DeleteSanPhamCartServlet
 */
@WebServlet("/xoa-product")
public class DeleteSanPhamCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSanPhamCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SanPham sp =SanPhamBL.docTheoID(id);
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.deleteItemCart(sp);
		response.sendRedirect("trang-gio-hang.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
