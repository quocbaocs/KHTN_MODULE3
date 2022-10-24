package contronller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.LoaiBL;
import javaBeans.Loai;


@WebServlet("/LoaiServlet")
public class LoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoaiServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Loai> dsLoai = LoaiBL.docTatCa();
		request.setAttribute("dsLoai", dsLoai);
		request.getRequestDispatcher("Views/cuoi-trang.jsp").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
