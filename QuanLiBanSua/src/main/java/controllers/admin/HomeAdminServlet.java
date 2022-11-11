package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;


@WebServlet("/admin/trang-chu")
public class HomeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HomeAdminServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("dsls", LoaiSuaBL.getAllLoaiSua());
		request.setAttribute("dshs", HangSuaBL.getAllHangSua());
		int trang =1;
		if(request.getParameter("trang")!=null) {
			trang = Integer.parseInt(request.getParameter("trang"));
		}
		
		request.setAttribute("dssp", SuaBL.danhSachSuaTrang(trang,6));
		request.setAttribute("tongSoTrang", SuaBL.tongSoTrang(6));
		request.getRequestDispatcher("/views/admin/trang-chu-admin.jsp").forward(request, response);
	}

	

}
