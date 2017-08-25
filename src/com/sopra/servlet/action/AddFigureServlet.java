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

@WebServlet("/admin/ajoutFigure")
public class AddFigureServlet extends SpringServlet{
	
	private static final String VUE_GET					= "/tetrimino/admin/modifPiece";
	
	@Autowired
	private IFigureDAO figureHibernateDAO;
	
	@Autowired
	private ITetriminoDAO tetriminoHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int idTetrimino = Integer.parseInt(req.getParameter("id"));
	
	Tetrimino myTetrimino = tetriminoHibernateDAO.find(idTetrimino);
	
	//Creation nouvelle figure
	
	Figure myFigure = new Figure();
	
	myFigure.setOrdre(0);
	
	myFigure.setTetrimino(myTetrimino);
	
	figureHibernateDAO.save(myFigure);
	
	resp.sendRedirect(VUE_GET+"?id="+idTetrimino);
	
	
	
	}



}
