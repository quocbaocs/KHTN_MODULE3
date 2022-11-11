package a;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import businessLogics.SuaBL;
import javaBeans.Sua;

@WebServlet("/demoServlet")
public class demoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public demoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		int trang =1;
		if(!request.getParameter("id").equals("undefined")) {
			trang = Integer.parseInt(request.getParameter("id"));
		}
        response.setCharacterEncoding("UTF-8");
		response.getWriter().write(updateToJson(SuaBL.danhSachSuaTrang(trang, 8)));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
private static String updateToJson(List<Sua> listSua) {
		
		
		JSONArray jsonArray = new JSONArray();
	
		for(Sua s: listSua) {
			JSONObject jsObj = new JSONObject();
			jsObj.put("masua", s.getMaSua());
			jsObj.put("tensua", s.getTenSua());
			jsObj.put("maHang", s.getHangSua().getTenHangSua());
			jsObj.put("tenLoai", s.getLoaiSua().getTenLoai());
			jsObj.put("trongLuong",s.getTrongLuong());
			jsObj.put("donGia", s.getDonGia());
			jsObj.put("tpdd", s.getTpDinhDuong());
			jsObj.put("loi_ich", s.getLoiIch());
			jsObj.put("hinh", s.getHinh());
			jsonArray.add(jsObj);
		}
		JSONObject jsSua = new JSONObject();
		jsSua.put("sua", jsonArray);
		return jsSua.toJSONString();
		
	}
	

}
