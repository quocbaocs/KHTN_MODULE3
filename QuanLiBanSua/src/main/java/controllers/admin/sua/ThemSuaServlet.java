package controllers.admin.sua;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.HangSua;
import javaBeans.LoaiSua;
import javaBeans.Sua;

@WebServlet("/admin/them-sua")
@MultipartConfig
public class ThemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemSuaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		if (request.getParameter("maSua") != null) {
			String maSua = request.getParameter("maSua");
			String tenSua = request.getParameter("tenSua");

			String maLoai = request.getParameter("cboLoaiSua");
			String maHang = request.getParameter("cboHangSua");

			int trongLuong = Integer.parseInt(request.getParameter("trongLuong"));
			int donGia = Integer.parseInt(request.getParameter("donGia"));

			String tpdd = request.getParameter("tpdd");
			String loiIch = request.getParameter("loiIch");

			String path = getServletContext().getRealPath("/images/upload/");
			Part part = request.getPart("file");
			upload(path, part);
			String tenHinh = part.getSubmittedFileName();

			LoaiSua loaiSua = LoaiSuaBL.getLoaiSua(maLoai);
			HangSua hangSua = HangSuaBL.getHangSua(maHang);

			Sua suaNew = new Sua(maSua, hangSua, loaiSua, tenSua, trongLuong, donGia, tpdd, loiIch, tenHinh);
			boolean result = SuaBL.themSua(suaNew);
			if (result) {
				request.setAttribute("message", "Thêm sữa thành công");
			} else {
				request.setAttribute("message", "Thêm sữa không thành công");
			}
		}

		request.setAttribute("dsls", LoaiSuaBL.getAllLoaiSua());
		request.setAttribute("dshs", HangSuaBL.getAllHangSua());
		
		request.getRequestDispatcher("/views/admin/them-sua-moi.jsp").forward(request, response);

	}

	private void upload(String path, Part part) {
		String tenTapTin = part.getSubmittedFileName();

		try {
			InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(path + tenTapTin);

			int len = 0;
			byte[] mb = new byte[1024];

			while ((len = is.read(mb, 0, 1024)) > 0) {
				os.write(mb, 0, len);
			}
			is.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
