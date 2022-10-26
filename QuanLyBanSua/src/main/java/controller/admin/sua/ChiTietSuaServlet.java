package controller.admin.sua;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.SuaBL;
import JavaBeans.Sua;

@WebServlet("/ChiTietSuaServlet")
public class ChiTietSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChiTietSuaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maSua = request.getParameter("maSua");
		Sua sp =  SuaBL.docTheoMaSua(maSua);
		request.setAttribute("sp", sp);
		request.getRequestDispatcher("views/san-pham.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
