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

@WebServlet("/SanPhamMoiServlet")
public class SanPhamMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SanPhamMoiServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> dssp = SanPhamBL.sanPhamMoi(10);
		request.setAttribute("dssp", dssp);
		request.getRequestDispatcher("Views/san-pham-moi.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
