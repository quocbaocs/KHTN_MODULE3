package controller.admin.publisher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;
import javaBeans.Publisher;

@WebServlet("/EditPublisherServlet")
public class EditPublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EditPublisherServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("p", PublisherBL.getPublisher(id));
		request.getRequestDispatcher("views/admin/publisher/edit-publisher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String publisherName = request.getParameter("publisherName");
		Publisher p = PublisherBL.getPublisher(id);
		p.setPublisherName(publisherName);
		PublisherBL.sua(p);
		response.sendRedirect("/Bai04M3_BaiTap/PublisherServlet");
	}

}
