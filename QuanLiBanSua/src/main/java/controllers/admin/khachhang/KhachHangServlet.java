package controllers.admin.khachhang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachHangBL;

@WebServlet("/admin/khach-hang")
public class KhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KhachHangServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int trang = 1;
		if (request.getParameter("trang") != null)
			trang = Integer.parseInt(request.getParameter("trang"));

		request.setAttribute("dskh", KhachHangBL.KhachHangTrang(trang, 5));
		request.setAttribute("tongSoTrang", KhachHangBL.tongSoTrang(5));

		request.getRequestDispatcher("/views/admin/khach-hang.jsp").forward(request, response);
	}

}
