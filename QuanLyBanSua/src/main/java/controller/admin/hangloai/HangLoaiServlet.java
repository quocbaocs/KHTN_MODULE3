package controller.admin.hangloai;

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

@WebServlet("/HangLoaiServlet")
public class HangLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HangLoaiServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<HangSua> dshs = HangSuaBL.docTatCa();
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		request.setAttribute("dshs", dshs);
		request.setAttribute("dsls", dsls);
		request.getRequestDispatcher("views/menu-trai.jsp").include(request, response);

	}

}
