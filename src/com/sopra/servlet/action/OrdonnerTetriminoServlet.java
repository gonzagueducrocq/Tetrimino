package com.sopra.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@WebServlet("/admin/ordonnerFigure")
public class OrdonnerTetriminoServlet extends SpringServlet{

	private static final String VUE_GET					= "/tetrimino/admin/modifPiece";

	@Autowired
	private IFigureDAO figureHibernateDAO;

	@Autowired
	private ITetriminoDAO tetriminoHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int idFigure = Integer.parseInt(req.getParameter("id"));

		Figure myFigure = figureHibernateDAO.find(idFigure);

		Tetrimino myTetrimino = myFigure.getTetrimino();

		int nelOrdre;
		
		if ( req.getParameter("sens").equals("0")) {
			
			nelOrdre = myFigure.getOrdre() - 1;
			
		}
		
		else nelOrdre = myFigure.getOrdre() + 1;

		for (Figure figure : myTetrimino.getFigures()) {

			if ( figure.getOrdre() == nelOrdre) {

				figure.setOrdre(myFigure.getOrdre());

				figureHibernateDAO.save(figure);
			}

		}
		myFigure.setOrdre(nelOrdre);
		figureHibernateDAO.save(myFigure);
	
		resp.sendRedirect(VUE_GET+"?id="+myTetrimino.getId());
		
	}


	
}


