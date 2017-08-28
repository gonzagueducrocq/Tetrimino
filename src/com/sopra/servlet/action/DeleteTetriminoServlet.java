package com.sopra.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IBlocDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Bloc;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@WebServlet("/admin/supprimerPiece")
public class DeleteTetriminoServlet extends SpringServlet {
	private static final String ATT_ID				= "id";
	private static final String VUE_POST			= "/tetrimino/listeTetriminos";

	@Autowired
	private ITetriminoDAO tetriminoHibernateDAO;

	@Autowired
	private IBlocDAO blocHibernateDAO;

	@Autowired
	private IFigureDAO figureHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter(ATT_ID));

		Tetrimino tetrimino = tetriminoHibernateDAO.find(id);

		for(Figure figure : tetrimino.getFigures()) {

			for(Bloc bloc : figure.getBlocs()) {

				blocHibernateDAO.delete(bloc);
			}
			figureHibernateDAO.delete(figure);
		}
		tetriminoHibernateDAO.delete(tetrimino);
		
		resp.sendRedirect(VUE_POST);
	}

}
