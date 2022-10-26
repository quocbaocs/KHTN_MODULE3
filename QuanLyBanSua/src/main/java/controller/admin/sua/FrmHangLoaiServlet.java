package controller.admin.sua;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.HangSuaBL;
import BusinessLogics.LoaiSuaBL;
import JavaBeans.HangSua;
import JavaBeans.LoaiSua;


@WebServlet("/FrmHangLoaiServlet")
public class FrmHangLoaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrmHangLoaiServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		List<HangSua> dshs = HangSuaBL.docTatCa();
		request.setAttribute("dsls", dsls);
		request.setAttribute("dshs", dshs);

		request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
