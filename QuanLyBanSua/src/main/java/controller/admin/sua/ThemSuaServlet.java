package controller.admin.sua;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import BusinessLogics.HangSuaBL;
import BusinessLogics.LoaiSuaBL;
import BusinessLogics.SuaBL;
import JavaBeans.HangSua;
import JavaBeans.LoaiSua;
import JavaBeans.Sua;

@WebServlet("/ThemSuaServlet")
@MultipartConfig
public class ThemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemSuaServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String maLoai, maHang;
		try {
			maLoai = request.getParameter("cboLoai");
			maHang = request.getParameter("cboHang");
			
			
			
			if (request.getParameter("maSua") != null) {
				String masua = request.getParameter("maSua");
				String tenSua = request.getParameter("tenSua");
				int trongLuong = Integer.parseInt(request.getParameter("trongLuong"));
				System.out.println(trongLuong);
				int donGia = Integer.parseInt(request.getParameter("donGia"));
				String tpdd = request.getParameter("tpdd");
				String loi_ich = request.getParameter("loiIch");

				String path = getServletContext().getRealPath("/images/");
				Part part = request.getPart("file");
				upload(path, part);
				String hinh = part.getSubmittedFileName();
				Sua suaNew = new Sua(masua, tenSua, maLoai, maHang, trongLuong, donGia, tpdd, loi_ich, hinh);
				int result = SuaBL.themSua(suaNew);
				if (result > 0) {
					request.setAttribute("message", "Thêm sữa thành công");
				} else {
					request.setAttribute("message", "Thêm sữa không thành công");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		request.getRequestDispatcher("trang-them-sua.jsp").forward(request, response);

	}

	private static void upload(String path, Part part) {

		String tenTapTin = part.getSubmittedFileName();
		try {
			InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(path + tenTapTin);

			// Đọc nhanh hơn
			int len = 0;
			byte[] mb = new byte[1024];

			// len so lon nhat cua byte duoc doc
			while ((len = is.read(mb, 0, 1024)) > 0)
				os.write(mb, 0, len);

			is.close();
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Thư mục thực sự tải lên trên web server
			// C:\\Users\\hv\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\WebsiteMilk

	}

}
