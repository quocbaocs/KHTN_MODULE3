package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/summultinumbers.html")
public class SumMultiNumbers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter pw = response.getWriter()) {
			pw.append("<form method=\"post\">");
			for (int i = 1; i <= 5; i++) {
				pw.format("<p><label>Number %d: </label><input type=\"number\" name=\"arr\"></p>", i);
			}
			pw.append("<p><button>Sum</button><p>");
			pw.append("</form>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] arr = request.getParameterValues("arr");
		int s = 0;
		for (String item : arr) {
			s += Integer.parseInt(item);
		}
		try (PrintWriter pw = response.getWriter()) {
			pw.format("<p>Result: %d</p>", s);
		}
	}
}