package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TinhtongServlet")
public class V5bServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public V5bServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double a, b, kq;
		a = Double.parseDouble(request.getParameter("txtA"));
		b = Double.parseDouble(request.getParameter("txtB"));
		kq = a + b;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'/>");
		out.println("<title>Kết quả</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Kết quả: " + String.format("%.2f + %.2f = %.2f", a, b, kq) + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
