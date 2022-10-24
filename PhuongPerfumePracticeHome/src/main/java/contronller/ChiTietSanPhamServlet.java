package contronller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamBL;
import javaBeans.SanPham;


@WebServlet("/chi-tiet-san-pham")
public class ChiTietSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ChiTietSanPhamServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("sp", SanPhamBL.docTheoID(id));
		request.setAttribute("dssplq", SanPhamBL.docTheoThuongHieu(SanPhamBL.docTheoID(id).getId_thuongHieu()));
		request.getRequestDispatcher("Views/san-pham.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenSanPham = request.getParameter("keyword");
		request.setAttribute("dsTim", SanPhamBL.docTheoTen(tenSanPham));
		doGet(request, response);
	}

}
