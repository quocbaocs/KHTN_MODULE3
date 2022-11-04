package contronller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaBeans.GioHang;

@WebServlet("/ThemVaoGioServlet")
public class ThemVaoGioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemVaoGioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idsp, slm;
		idsp = Integer.parseInt(request.getParameter("idsp"));
		slm = Integer.parseInt(request.getParameter("slm"));
		HttpSession session = request.getSession();
		GioHang gioHang = (GioHang) session.getAttribute("gioHang");
		if (gioHang == null) {
			gioHang = new GioHang();
			session.setAttribute("gioHang", gioHang);
		}
		gioHang.them(idsp, slm);
		

		response.getWriter().print(String.valueOf(gioHang.tongTien() + ";" + gioHang.soMatHang()));
		// response.sendRedirect("trang-chu.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
