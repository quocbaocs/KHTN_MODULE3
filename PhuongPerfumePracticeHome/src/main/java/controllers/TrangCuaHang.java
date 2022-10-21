package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamBL;
import javaBeans.SanPham;


@WebServlet("/cua-hang")
public class TrangCuaHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamBL sanPhamBL;

    public TrangCuaHang() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page =1;
		if(request.getParameter("trang")!=null) {
			page = Integer.parseInt(request.getParameter("trang"));
		}
		sanPhamBL = new SanPhamBL();
		try {
			List<SanPham> listSP= (List<SanPham>) sanPhamBL.listPhanTrang(page).get("listSP");
			request.setAttribute("listSPT", listSP);
			int tongSoTrang = (int) sanPhamBL.listPhanTrang(page).get("tongSoTrang");
			request.setAttribute("tongSoTrang", tongSoTrang);
			System.out.println(tongSoTrang);
			RequestDispatcher rd = request.getRequestDispatcher("trang-cua-hang.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
