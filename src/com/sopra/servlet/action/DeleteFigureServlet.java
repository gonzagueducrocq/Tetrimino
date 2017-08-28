package com.sopra.servlet.action;



import java.io.IOException;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IBlocDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.model.Bloc;
import com.sopra.model.Figure;



@WebServlet("/admin/supprimerFigure")

public class DeleteFigureServlet extends SpringServlet{

	private static final String VUE_GET          = "/tetrimino/admin/modifPiece";

	@Autowired
	private IFigureDAO figureHibernateDAO;
	
	@Autowired
	private IBlocDAO blocHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int idFigure = Integer.parseInt(req.getParameter("id"));

		Figure myFigure = figureHibernateDAO.find(idFigure);

		for(Bloc bloc : myFigure.getBlocs()) {
			
			blocHibernateDAO.delete(bloc);
			
		}
		
		figureHibernateDAO.delete(myFigure);

		resp.sendRedirect(VUE_GET+"?id="+myFigure.getTetrimino().getId());

	}

}