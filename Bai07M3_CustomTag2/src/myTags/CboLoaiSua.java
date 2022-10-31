package myTags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import BusinessLogics.LoaiSuaBL;
import JavaBeans.LoaiSua;

public class CboLoaiSua extends SimpleTagSupport {
	//<mt:cboLoaiSua> Loại sữa</mt:cboLoaiSua> --> Loại sữa : [Combobox LoaiSua]
	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		JspFragment f = getJspBody();// lấy cái phần mai lan
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		
		if (f != null)
			f.invoke(out);
		out.print("<select name='cblLoaiSua'");
		for(LoaiSua ls : dsls) {
			out.print("<option value'"+ls.getMaLoai()+"'>"+ls.getTenLoai()+"</option>");
		}
		out.print("</select>");
	}
}
