package com.sopra.servlet.view;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IJoueurDAO;
import com.sopra.model.Joueur;
import com.sopra.servlet.action.SpringServlet;

@WebServlet("/listeJoueurs")
public class DisplayPlayerServlet extends SpringServlet {
	public static final String VUE_GET		= "/WEB-INF/afficherJoueurs.jsp";
	
	@Autowired
	private IJoueurDAO joueurHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Joueur> joueurs = joueurHibernateDAO.findAll();

		req.setAttribute("joueurs", joueurs);

		this.getServletContext().getRequestDispatcher(VUE_GET).forward(req, resp);
	}

}