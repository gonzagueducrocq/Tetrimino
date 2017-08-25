package com.sopra.servlet.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;
import com.sopra.servlet.action.SpringServlet;

@WebServlet("/listeTetriminos")
public class DisplayTetriminoServlet extends SpringServlet {
	public static final String VUE_GET		= "/WEB-INF/afficherTetriminos.jsp";
	
	@Autowired
	private ITetriminoDAO tetriminoHibernateDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Tetrimino> tetriminos = tetriminoHibernateDAO.findAll();
		
		req.setAttribute("tetriminos", tetriminos);
		
		this.getServletContext().getRequestDispatcher(VUE_GET).forward(req, resp);
	}

}
