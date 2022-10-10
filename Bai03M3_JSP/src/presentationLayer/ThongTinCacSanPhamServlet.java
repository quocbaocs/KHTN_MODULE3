package presentationLayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamDAO;

@WebServlet("/ThongTinCacSanPhamServlet")
public class ThongTinCacSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThongTinCacSanPhamServlet() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SanPhamDAO dao = new SanPhamDAO();
		request.setAttribute("listSanPham", dao.list());
		RequestDispatcher rd = request.getRequestDispatcher("timkiemthongtinsuatheoten.jsp");
		rd.forward(request, response);

	}

}
