package baiTap.bai2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sumtwonumbers.html")
public class SumTwoNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SumTwoNumbers() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter pw = response.getWriter()) {
			pw.write("<form method=\"post\">");
			pw.write("<p>");
			pw.write("<label>Number a</label>");
			pw.write("<input type=\"number\" name=\"a\">");
			pw.write("</p>");
			pw.write("<p>");
			pw.write("<label>Number b</label>");
			pw.write("<input type=\"number\" name=\"b\">");
			pw.write("</p>");
			pw.write("<p>");
			pw.write("<button>Sum</button>");
			pw.write("</p>");
			pw.write("</form>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		try (PrintWriter pw = response.getWriter()) {
			pw.printf("<p>Sum %d + %d = %d<p>", a, b, a + b);
		}

	}

}
