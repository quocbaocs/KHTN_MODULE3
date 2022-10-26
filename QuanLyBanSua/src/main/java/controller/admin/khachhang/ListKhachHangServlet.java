package controller.admin.khachhang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.KhachHangBL;


@WebServlet("/ListKhachHangServlet")
public class ListKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListKhachHangServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trang = 1;
		if(request.getParameter("trang")!=null) {
			trang = Integer.parseInt(request.getParameter("trang"));
		}
		request.setAttribute("tongSoTrang", KhachHangBL.tongSoTrang(6));
		request.setAttribute("dskh", KhachHangBL.khachHangTrang(trang, 6));
		request.getRequestDispatcher("views/khach-hang.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
