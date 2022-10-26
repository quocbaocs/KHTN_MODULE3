package controller.admin.sua;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.HangSuaBL;
import BusinessLogics.LoaiSuaBL;
import BusinessLogics.SuaBL;
import JavaBeans.HangSua;
import JavaBeans.LoaiSua;
import JavaBeans.Sua;

@WebServlet("/tim-kiem-sua")
public class TimSuaTheoLoaiHangTenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TimSuaTheoLoaiHangTenServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String maLoai, maHang, tenSua;

		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		List<HangSua> dshs = HangSuaBL.docTatCa();
		
		if (request.getParameter("keyword") != null) {
			maLoai = request.getParameter("cboLoai");
			maHang = request.getParameter("cboHang");
			tenSua = request.getParameter("keyword");

			List<Sua> dsSua = SuaBL.timTheoLoaiHangTen(maLoai, maHang, tenSua);

			request.setAttribute("dsSua", dsSua);
			request.setAttribute("soSP", dsSua.size());

		}
		request.setAttribute("dsls", dsls);
		request.setAttribute("dshs", dshs);
		request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

}
