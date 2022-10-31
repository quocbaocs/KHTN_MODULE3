package myTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Cong extends SimpleTagSupport {

	// <mt:cong a="2" b="3">Tong : </mt:cong>--> Tổng : + 3 = 5;

	private int a;
	private int b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		JspFragment f = getJspBody();// lấy cái phần mai lan
		if (f != null)
			f.invoke(out);
		out.print(String.format("%d + %d = %d", a, b, a + b));

	}

}
