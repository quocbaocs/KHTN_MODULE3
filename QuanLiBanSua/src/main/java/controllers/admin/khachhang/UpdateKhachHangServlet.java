package controllers.admin.khachhang;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachHangBL;
import javaBeans.KhachHang;

@WebServlet("/admin/cap-nhat")
public class UpdateKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateKhachHangServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maKH = request.getParameter("makh");
		request.setAttribute("kh", KhachHangBL.getKhachHang(maKH));
		System.out.println(KhachHangBL.getKhachHang(maKH).getTenKhachHang());
		request.getRequestDispatcher("/views/admin/update-khach-hang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String maKH = request.getParameter("makh");
		String tenKH = request.getParameter("tenkh");
		boolean phai = request.getParameter("phai").equals("1") ? true : false;
		System.out.println(phai);
		String diachi = request.getParameter("diachi");
		String dienThoai = request.getParameter("dienthoai");
		String email = request.getParameter("email");

		KhachHang kh = new KhachHang(maKH, tenKH, phai, diachi, dienThoai, email);

		boolean result = KhachHangBL.capNhatKhachHang(kh);
		if (result) {
			StringBuffer url = request.getRequestURL();
			request.setAttribute("message", "Cập nhật thành công");
		} else {
			request.setAttribute("message", "Hãy kiểm tra lại thông tin");
		}
		doGet(request, response);

	}

}
