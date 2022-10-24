package contronller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SanPhamBL;
import javaBeans.SanPham;


@WebServlet("/SanPhamBanChayYeuThich")
public class SanPhamBanChayYeuThich extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SanPhamBanChayYeuThich() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> listBanChayTop3 = SanPhamBL.banChayNhat(3);
		List<SanPham> listGiamGia = SanPhamBL.giamGiaNhieu(3);
		List<SanPham> listYeuThich = SanPhamBL.sanPhamMoi(3);
		request.setAttribute("dsBanChay", listBanChayTop3);
		request.setAttribute("dsGiamGia", listGiamGia);
		request.setAttribute("dsYeuThich", listYeuThich);
		request.getRequestDispatcher("Views/ban-chay-yeu-thich.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
