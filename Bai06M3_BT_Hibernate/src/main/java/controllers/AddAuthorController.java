package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.AuthorBL;
import entities.Author;


@WebServlet("/author/add.html")
public class AddAuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddAuthorController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/admin/author/add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Author obj = new Author(request.getParameter("name"));
		AuthorBL.add(obj);
		response.sendRedirect(request.getContextPath()+"/admin/author.html");
	}

}
