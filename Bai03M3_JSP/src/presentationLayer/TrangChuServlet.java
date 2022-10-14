package presentationLayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaDAO;
import businessLogics.LoaiSuaDAO;

@WebServlet("/themsua")
public class TrangChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoaiSuaDAO loaiSuaDao;
	private HangSuaDAO hangSuaDao;
	
	public TrangChuServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loaiSuaDao = new LoaiSuaDAO();
		hangSuaDao = new HangSuaDAO();
		
		request.setAttribute("listLoaiSua", loaiSuaDao.list());
		request.setAttribute("listHangSua", hangSuaDao.list());
		RequestDispatcher rd = request.getRequestDispatcher("themSanPham.jsp");
		rd.forward(request, response);
		
	}

}
