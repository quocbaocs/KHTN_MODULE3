package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/Vd2Servlet", "/vd2.html" })
public class Vd2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Vd2Servlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='utf-8'/>");
//		out.println("<title>Ví dụ 2</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println(
//				"<h1 style='color:red; text-align:center;'>Chào mùng bạn đến với lập trình Servlet của Java !</h1>");
//
//		out.println("Server port: " + request.getServerPort());
//		out.println("Protocol : " + request.getProtocol());
//		out.println("Content length: " + request.getContentLength());
//		out.println("</body>");
//		out.println("</html>");

		//response.sendRedirect("http://www.nld.com.vn");
		response.sendRedirect("chao.html");
//		request.getRequestDispatcher("chao.html").forward(request, response);
//		request.getRequestDispatcher("chao.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	

}
