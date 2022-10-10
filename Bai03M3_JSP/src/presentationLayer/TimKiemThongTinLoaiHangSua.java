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
import businessLogics.SanPhamDAO;

@WebServlet("/TimKiemThongTinLoaiHangSua")
public class TimKiemThongTinLoaiHangSua extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO sanPhamDao;
	private LoaiSuaDAO loaiSuaDao;
	private HangSuaDAO hangSuaDao;
	public TimKiemThongTinLoaiHangSua() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sanPhamDao = new SanPhamDAO();
		loaiSuaDao = new LoaiSuaDAO();
		hangSuaDao = new HangSuaDAO();
		
		String keyword = request.getParameter("keyword");
		String tenLoaiSua = request.getParameter("loaiSua");
		String tenhangSua = request.getParameter("hangSua");
		
		if (keyword != null && !keyword.equals("")) {
			request.setAttribute("listSanPham", sanPhamDao.search(keyword, tenLoaiSua, tenhangSua));
		}
		request.setAttribute("listLoai", loaiSuaDao.list());
		request.setAttribute("listHang", hangSuaDao.list());
		RequestDispatcher rd = request.getRequestDispatcher("timkiemthongtinsuatheo_ten_loai_hang.jsp");
		rd.forward(request, response);
	}

}
