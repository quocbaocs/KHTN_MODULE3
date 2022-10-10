package presentationLayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamDAO;

@WebServlet("/TimKiem")
public class TimKiemThongTinSua extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanPhamDAO dao;
       
   
    public TimKiemThongTinSua() {
        super();
       
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 dao = new SanPhamDAO();
		
		String keyword = request.getParameter("keyword");
		if(keyword!=null) {
		request.setAttribute("listSanPham", dao.search(keyword));
		}
		RequestDispatcher rd = request.getRequestDispatcher("timkiemthongtinsuatheoten.jsp");
		rd.forward(request, response);
	}

}
