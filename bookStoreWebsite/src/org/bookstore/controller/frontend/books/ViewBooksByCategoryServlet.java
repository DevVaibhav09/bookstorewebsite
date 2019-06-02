package org.bookstore.controller.frontend.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.service.BookService;

/**
 * Servlet implementation class ViewBooksByCategoryServlet
 */
@WebServlet(name = "ViewBooksByCategoryServ", urlPatterns = { "/view_category" })
public class ViewBooksByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewBooksByCategoryServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookServiceByCategory = new BookService(request, response);
		bookServiceByCategory.listBookBYCategory();
	}

}
