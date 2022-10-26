package controller.admin.sua;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.SuaBL;
import JavaBeans.Sua;

@WebServlet("/DanhMucSuaServlet")
public class DanhMucSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DanhMucSuaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int trang = 0;
		if (request.getParameter("trang") == null) {
			trang = 1;
		} else {
			trang = Integer.parseInt(request.getParameter("trang"));
		}
		if (request.getParameter("maLoai") != null) {
			String maLoai = request.getParameter("maLoai");
			request.setAttribute("dssp", SuaBL.docTheoMaLoai(maLoai));

		}
		if (request.getParameter("maHang") != null) {
			String maHang = request.getParameter("maHang");
			request.setAttribute("dssp", SuaBL.docTheoMaHang(maHang));
		}
		if (request.getParameter("maLoai") == null && request.getParameter("maHang") == null) {
			List<Sua> dssp = SuaBL.sanPhamTrang(trang, 8);
			request.setAttribute("dssp", dssp);
			request.setAttribute("tongSoTrang", SuaBL.tongSoTrang(8));
		}

		request.getRequestDispatcher("views/danh-muc-san-pham.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
