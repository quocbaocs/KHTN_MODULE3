package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SuaBL;
import entities.Sua;

@WebServlet("/SuaServlet")
public class SuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SuaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		List<Sua> dsSua = SuaBL.docTatCa();
		// List<Sua> dsSua = SuaBL.docTheoMaHang("DL");
		// List<Sua> dsSua = docTheoLoaiHangTen("SB","DL", "Cô gái");
		List<Sua> dsSua = SuaBL.suaGiaCao(5);
		request.setAttribute("dsSua", dsSua);
		request.getRequestDispatcher("sua.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
