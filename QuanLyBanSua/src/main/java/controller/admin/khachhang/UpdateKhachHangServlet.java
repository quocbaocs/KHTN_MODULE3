package controller.admin.khachhang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.KhachHangBL;
import JavaBeans.KhachHang;

@WebServlet("/UpdateKhachHangServlet")
public class UpdateKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateKhachHangServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String makh = request.getParameter("makh");
		KhachHang kh = KhachHangBL.docKhachHangID(makh);
		request.setAttribute("kh", kh);
		request.getRequestDispatcher("views/update-khach-hang.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String makh = request.getParameter("makh");
		String tenkh = request.getParameter("tenkh");
		boolean phai = request.getParameter("phai").equals("1") ? true : false;
		String dienthoai = request.getParameter("dienthoai");
		String diachi = request.getParameter("diachi");
		String email = request.getParameter("email");
		KhachHang khNew = new KhachHang(makh, tenkh, phai, diachi, dienthoai, email);
		boolean update = KhachHangBL.updateKhachHangID(khNew);
		if (update == true) {
			request.setAttribute("message", "Cập nhật thành công");
			
		} else {
			request.setAttribute("message", "Cập nhật thất bại bạn kiểm tra lại thông tin");
		}
		request.setAttribute("kh", KhachHangBL.docKhachHangID(makh));
		request.getRequestDispatcher("views/update-khach-hang.jsp").include(request, response);
	}

}
