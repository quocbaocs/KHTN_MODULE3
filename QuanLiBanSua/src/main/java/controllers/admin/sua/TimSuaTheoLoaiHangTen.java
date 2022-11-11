package controllers.admin.sua;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.Sua;


@WebServlet("/admin/tim-sua")
public class TimSuaTheoLoaiHangTen extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TimSuaTheoLoaiHangTen() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("dshs", HangSuaBL.getAllHangSua());
		request.setAttribute("dsls", LoaiSuaBL.getAllLoaiSua());
		if(request.getParameter("keyword")!=null) {
			String keyword = request.getParameter("keyword");
			String maHang = request.getParameter("cboHangSua");
			String maLoai = request.getParameter("cboLoaiSua");
			
			
			List<Sua> dssp = SuaBL.timTheoLoaiHangTen(maLoai, maHang, keyword);
			if(dssp.size()>0) {
				request.setAttribute("dssp", dssp);
			}
			request.setAttribute("message", "Có "+dssp.size()+ " được tìm thấy");
		}
		request.getRequestDispatcher("/views/admin/tim-kiem-sua.jsp").forward(request, response);
	}

}
