package a;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.HangSua;
import javaBeans.LoaiSua;
import javaBeans.Sua;

public class DemoJson {

	public static void main(String[] args) {
		//JSONParser parser = new JSONParser();
		System.out.println(updateToJson(LoaiSuaBL.getAllLoaiSua()));
	}

	private static String updateToJson(List<LoaiSua> allLoaiSua) {
		
		
		JSONArray jsonArray = new JSONArray();
	
		for(Sua s: SuaBL.danhSachSuaTrang(1, 8)) {
			JSONObject jsObj = new JSONObject();
			jsObj.put("masua", s.getMaSua());
			jsObj.put("ten sua", s.getTenSua());
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
