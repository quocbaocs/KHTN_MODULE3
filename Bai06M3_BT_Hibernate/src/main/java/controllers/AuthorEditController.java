package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.AuthorBL;
import entities.Author;

@WebServlet("/AuthorEditController")
public class AuthorEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorEditController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("o", AuthorBL.getAuthor(id));
		request.getRequestDispatcher("/views/admin/author/edit.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Author obj = new Author(id, request.getParameter("name"));
		AuthorBL.edit(obj);
		response.sendRedirect(request.getContextPath() + "/admin/author.html");

	}

}
