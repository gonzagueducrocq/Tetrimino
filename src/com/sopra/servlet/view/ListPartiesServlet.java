package com.sopra.servlet.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IPartieDAO;
import com.sopra.dao.IScoreDAO;
import com.sopra.model.Partie;
import com.sopra.servlet.action.SpringServlet;

@WebServlet("/admin/listeParties")
public class ListPartiesServlet extends SpringServlet {
	
	private static final String VUE_LISTE	= "/WEB-INF/admin/listerParties.jsp";
	
	@Autowired
	private IPartieDAO partieHibernateDAO;
	
	@Autowired
	private IScoreDAO scoreHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Partie> parties = partieHibernateDAO.findAllWithScores();
		
		req.setAttribute("parties", parties);
		
		this.getServletContext().getRequestDispatcher(VUE_LISTE).forward(req, resp);
	}

}
