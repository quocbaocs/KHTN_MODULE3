package controller.admin.publisher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;
import javaBeans.Publisher;

@WebServlet("/AddNewPublisherServlet")
public class AddNewPublisher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewPublisher() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("views/admin/publisher/add-publisher.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String publisherName = request.getParameter("publisherName");
		Publisher p = new Publisher(publisherName);
		PublisherBL.them(p);
		response.sendRedirect("/Bai04M3_BaiTap/PublisherServlet");

	}

}
