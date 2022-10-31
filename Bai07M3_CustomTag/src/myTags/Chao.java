package myTags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Chao extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		// <mt:chao> Mai Lan </mt:chao> --> Chào mừng bạn Mai Lan đến với lập trình Custom tag!
		JspWriter out = getJspContext().getOut();
		JspFragment f = getJspBody();// lấy cái phần mai lan
		out.print("Chào mừng bạn ");
		if(f!=null)
			f.invoke(out);
		out.print("đến với custom tag!");
	}

}
