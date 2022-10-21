package contronller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.ThuongHieuBL;
import javaBeans.ThuongHieu;


@WebServlet("/ThuongHieuServlet")
public class ThuongHieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ThuongHieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ThuongHieu> dsth = ThuongHieuBL.docTatCa();
		request.setAttribute("dsth",dsth);
		request.getRequestDispatcher("Views/thuong-hieu.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
