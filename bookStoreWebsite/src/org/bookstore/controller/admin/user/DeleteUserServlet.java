package org.bookstore.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.controller.BaseServlet;
import org.bookstore.service.UserServices;

@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServices userservice = new UserServices(entityManager, request, response);
		userservice.deleteUser();
	}


}
