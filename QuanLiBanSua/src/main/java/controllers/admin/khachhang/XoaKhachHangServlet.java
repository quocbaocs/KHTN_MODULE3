package controllers.admin.khachhang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachHangBL;


@WebServlet("/admin/xoa-khach-hang")
public class XoaKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public XoaKhachHangServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String makh = request.getParameter("makh");
		boolean result = KhachHangBL.delete(makh);
		if(result) {
			request.setAttribute("message", "Xóa thành công khách hàng có mã "+makh);
		}else {
			request.setAttribute("message", "Không thể xóa khách hàng đã mua hàng");
			
		}
		
		request.getRequestDispatcher("khach-hang").forward(request, response);
	}


	
}
