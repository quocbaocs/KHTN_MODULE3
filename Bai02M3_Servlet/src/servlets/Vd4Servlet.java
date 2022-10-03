package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vd4Servlet
 */
@WebServlet("/Vd4Servlet")
public class Vd4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vd4Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'/>");
		out.println("<title>Ví dụ 2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='' method='post'>\r\n" + "  <label for=\"fname\">Số a:</label><br>\r\n"
				+ "  <input type=\"text\" name=\"txtA\"><br>\r\n" + "  <label for=\"lname\">Số b:</label><br>\r\n"
				+ "  <input type=\"text\" name=\"txtB\">\r\n" + "<input type='submit' value='Cộng'/>" + "</form>");
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		out.println("<h1>Kết quả: "+String.format("%.2f + %.2f = %.2f", a, b, kq)+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
