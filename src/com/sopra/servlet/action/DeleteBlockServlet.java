package com.sopra.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IBlocDAO;
import com.sopra.model.Bloc;
import com.sopra.model.Figure;

@WebServlet("/admin/suppressionBloc")
public class DeleteBlockServlet extends SpringServlet {

	private static final String VUE_GET					= "/tetrimino/admin/modifPiece";
	
	@Autowired
	private IBlocDAO blocHibernateDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

				
		int idBloc = Integer.parseInt(req.getParameter("id"));
		
		Bloc myBloc = blocHibernateDAO.find(idBloc);
		
		Figure myFigure = myBloc.getFigure();
		
		blocHibernateDAO.delete(myBloc);
		
		resp.sendRedirect(VUE_GET+"?id="+myFigure.getTetrimino().getId());
	}
	
}
