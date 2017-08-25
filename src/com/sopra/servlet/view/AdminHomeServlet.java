package com.sopra.servlet.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.servlet.action.SpringServlet;

@WebServlet("/admin/accueilAdmin")
public class AdminHomeServlet extends SpringServlet {
	public static final String VUE_GET		= "/WEB-INF/admin/accueilAdmin.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_GET).forward(req, resp);
	}

}
