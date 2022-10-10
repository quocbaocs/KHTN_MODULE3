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
@WebServlet("/Vd5Servlet")
public class Vd5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vd5Servlet() {
		super();
		
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
		out.println("<form action='TinhtongServlet' method='get'>\r\n" + "  <label for=\"fname\">Số a:</label><br>\r\n"
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
		
		
	}

}
