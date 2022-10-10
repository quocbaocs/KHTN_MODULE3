package presentationLayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamDAO;

@WebServlet("/ChiTietSanPhamServlet")
public class ChiTietSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO dao;
    public ChiTietSanPhamServlet() {
       dao = new SanPhamDAO();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSua = request.getParameter("id");
		request.setAttribute("spSua", dao.get(maSua));
		RequestDispatcher rd = request.getRequestDispatcher("chitietsua.jsp");
		rd.forward(request, response);
	}

	

}
