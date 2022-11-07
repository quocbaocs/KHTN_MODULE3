package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PublisherRepository;

/**
 * Servlet implementation class PublisherDelController
 */
@WebServlet("/admin/publisher/del.html")
public class PublisherDelController extends HttpServlet {
	private PublisherRepository repository = new PublisherRepository();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				repository.delete(id);
				response.sendRedirect(request.getContextPath() + "/admin/publisher.html");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
