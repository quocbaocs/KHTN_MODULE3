package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.LoaiBL;
import businessLogics.QuangCaoBL;
import businessLogics.SanPhamBL;
import businessLogics.ThuongHieuBL;

@WebServlet("")
public class TrangChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiBL loaiBL;
	private QuangCaoBL quangCaoBL;
	private SanPhamBL sanPhamBL;
	private ThuongHieuBL thuongHieuBL;
	public TrangChuServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loaiBL = new LoaiBL();
		quangCaoBL = new QuangCaoBL();
		sanPhamBL = new SanPhamBL();
		thuongHieuBL = new ThuongHieuBL();
		request.setAttribute("listLoai", loaiBL.listAll());
		request.setAttribute("listQC", quangCaoBL.listAll());
		request.setAttribute("listNew",sanPhamBL.listNew());
		request.setAttribute("listGiam",sanPhamBL.listGiamGia());
		request.setAttribute("listTH",thuongHieuBL.listAll());
		request.setAttribute("listBanNhieuNhat",sanPhamBL.listBanNhieuNhat());
		System.out.println("day la trang chu");
		RequestDispatcher dispatcher = request.getRequestDispatcher("trang-chu.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
