package org.bookstore.controller.admin.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.controller.BaseServlet;
import org.bookstore.service.CategoryServices;

/**
 * Servlet implementation class ListCategory
 */
@WebServlet("/admin/list_category")
public class ListCategory extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCategory() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Category servlet get method!!");
	CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
	categoryServices.listCategory();
	
	}

}
