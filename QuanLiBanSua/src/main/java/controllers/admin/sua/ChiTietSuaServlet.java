package controllers.admin.sua;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SuaBL;


@WebServlet("/admin/san-pham")
public class ChiTietSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChiTietSuaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maSua = request.getParameter("maSua");
		request.setAttribute("sp", SuaBL.getSua(maSua));
		request.getRequestDispatcher("/views/admin/chi-tiet-sua.jsp").forward(request, response);
	}


}
