package controller.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.UserBL;
import javaBeans.User;

@WebServlet("/auth/register.html")
public class AuthRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthRegisterController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/views/auth/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("password");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		byte gender = Byte.parseByte(request.getParameter("gender"));
		UserBL.themUser(new User(username, password, email, fullname, gender));
		response.sendRedirect("/Bai04M3_BaiTap/trang-chu");

	}

}
