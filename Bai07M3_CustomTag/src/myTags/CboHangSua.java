package myTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import BusinessLogics.HangSuaBL;
import BusinessLogics.LoaiSuaBL;
import JavaBeans.HangSua;
import JavaBeans.LoaiSua;

public class CboHangSua extends SimpleTagSupport {
	//<mt:cboLoaiSua> Loại sữa</mt:cboLoaiSua> --> Loại sữa : [Combobox LoaiSua]
	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		JspFragment f = getJspBody();// lấy cái phần mai lan
		List<HangSua> dshs = HangSuaBL.docTatCa();
		
		if (f != null)
			f.invoke(out);
		out.print("<select name='cblHangSua'");
		for(HangSua hs : dshs) {
			out.print("<option value'"+hs.getMaHang()+"'>"+hs.getTenHang()+"</option>");
		}
		out.print("</select>");
	}
}
