package controller.admin.khachhang;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.KhachHangBL;

@WebServlet("/xoa-khach-hang")
public class DeleteKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteKhachHangServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String maKhachHang = request.getParameter("makh");
		boolean delete = KhachHangBL.xoaKhachHangID(maKhachHang);
		String messsage;
		if (delete) {
			messsage=( "Xóa thành công khách hàng có mã KH: "+maKhachHang);
		} else {
			messsage=("Xóa không thành công vì khách hàng đã mua hàng");
		}
		response.getWriter().write(messsage);
		//request.getRequestDispatcher("trang-khach-hang.jsp").forward(request, response);
	}

}
