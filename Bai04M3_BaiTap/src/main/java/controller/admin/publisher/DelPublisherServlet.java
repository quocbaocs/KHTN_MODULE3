package controller.admin.publisher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.PublisherBL;


@WebServlet("/DelPublisherServlet")
public class DelPublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DelPublisherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		PublisherBL.xoa(id);
		response.sendRedirect("PublisherServlet");
		
	}

	

}
