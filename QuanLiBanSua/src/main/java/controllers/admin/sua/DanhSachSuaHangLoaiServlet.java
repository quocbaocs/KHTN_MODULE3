package controllers.admin.sua;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SuaBL;

@WebServlet("/admin/danh-sach-san-pham")
public class DanhSachSuaHangLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DanhSachSuaHangLoaiServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("maHang") != null) {
			
			String maHang = request.getParameter("maHang");
			request.setAttribute("dssp", SuaBL.docTheoHang(maHang));
		}
		if (request.getParameter("maLoai") != null) {
			
			String maLoai = request.getParameter("maLoai");
			request.setAttribute("dssp", SuaBL.docTheoLoai(maLoai));
		}

		request.getRequestDispatcher("/views/admin/thong-tin-cac-san-pham.jsp").forward(request, response);
	}

}
