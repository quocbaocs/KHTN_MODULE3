package contronller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamBL;
import javaBeans.SanPham;

/**
 * Servlet implementation class SanPhamTrangServlet
 */
@WebServlet("/SanPhamTrangServlet")
public class SanPhamTrangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SanPhamTrangServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trang = 1;
		if(request.getParameter("page")!=null) {
			 trang = Integer.parseInt(request.getParameter("page"));
		}
		
		List<SanPham> dsdp = SanPhamBL.sanPhamTrang(trang, 12);
		request.setAttribute("dssp", dsdp);
		request.setAttribute("tongSoTrang", SanPhamBL.tongSoTrang(12));
		request.getRequestDispatcher("Views/cua-hang.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
