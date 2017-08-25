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
import com.sopra.model.Tetrimino;

@WebServlet("/admin/ajoutBloc")
public class AddBlockServlet extends SpringServlet {

	private static final String VUE_GET					= "/tetrimino/admin/modifPiece";
	
	@Autowired
	private IBlocDAO blocHibernateDAO;
	
	@Autowired
	private IFigureDAO figureHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int idFigure = Integer.parseInt(req.getParameter("id"));
		
		Figure myFigure = figureHibernateDAO.find(idFigure);
		
		//Creation nouveau bloc
		
		Bloc myBloc = new Bloc();
		
		myBloc.setX(Integer.parseInt(req.getParameter("x")));
		
		myBloc.setY(Integer.parseInt(req.getParameter("y")));
		
		myBloc.setFigure(myFigure);
		
		blocHibernateDAO.save(myBloc);
		
		resp.sendRedirect(VUE_GET+"?id="+myFigure.getTetrimino().getId());
	}
	
	
}
