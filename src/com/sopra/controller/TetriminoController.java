package com.sopra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.dao.IBlocDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.IJoueurDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Bloc;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@Controller
public class TetriminoController {

	@Autowired
	private ITetriminoDAO tetriminoDAO;

	@Autowired
	private IBlocDAO blocDAO;

	@Autowired
	private IFigureDAO figureDAO;

	@RequestMapping(value="/tetrimino/add", method=RequestMethod.GET)
	public String addTetrimino(Model model) {

		return "addTetrimino";
	}

	@ModelAttribute("tetri")
	public Tetrimino initTetrimino() {
		Tetrimino tetrimino = new Tetrimino();
		return tetrimino;
	}

	@RequestMapping(value="/tetriminos", method=RequestMethod.GET)
	public String getListeTetriminos(Model model) {
		model.addAttribute("tetriminos", tetriminoDAO.findAll());

		return "tetriminos";
	}


	@RequestMapping(value="/tetrimino/add", method=RequestMethod.POST)
	public String addTetrimino(@ModelAttribute("tetri") Tetrimino tetrimino, 
			BindingResult result) {

		tetriminoDAO.save(tetrimino);
		return "redirect:/tetriminos";

	}


	@RequestMapping(value="/tetrimino/delete", method=RequestMethod.GET)
	public String deleteTetrimino(@RequestParam(value="id", required=true) int id) {

		Tetrimino tetrimino = tetriminoDAO.find(id);

		for(Figure figure : tetrimino.getFigures()) {

			for(Bloc bloc : figure.getBlocs()) {

				blocDAO.delete(bloc);
			}
			figureDAO.delete(figure);
		}
		tetriminoDAO.delete(tetrimino);


		return "redirect:/tetriminos";
	}

	@RequestMapping(value="/tetrimino/edit", method=RequestMethod.GET)
	public String editTetrimino (@RequestParam(value="id", required=true) int id, Model model) {

		Tetrimino tetrimino = tetriminoDAO.find(id);
		model.addAttribute("tetri", tetrimino);
		return "editTetrimino";
	}


	@RequestMapping(value="/tetrimino/edit", method=RequestMethod.POST)
	public String editTetrimino(@ModelAttribute("tetri") Tetrimino tetrimino, 
			BindingResult result) {

		tetriminoDAO.save(tetrimino);
		return "redirect:/tetrimino/edit?id=" + tetrimino.getId();

	}

	@RequestMapping(value="/tetrimino/ordonner", method=RequestMethod.GET)
	public String ordTetrimino(@RequestParam(value="id", required=true) int idFigure,
			@RequestParam(value="sens", required=true) int sens, Model model) {

		Figure myFigure = figureDAO.find(idFigure);

		Tetrimino myTetrimino = myFigure.getTetrimino();

		int nelOrdre;

		if ( sens == 0 ) {

			nelOrdre = myFigure.getOrdre() - 1;

		}

		else nelOrdre = myFigure.getOrdre() + 1;

		if (nelOrdre < 0 ) {
			nelOrdre = 0;
		}
		else if (nelOrdre > myTetrimino.getFigures().size() - 1 ) {
			nelOrdre = myTetrimino.getFigures().size() - 1 ;
		}

		for (Figure figure : myTetrimino.getFigures()) {

			if ( figure.getOrdre() == nelOrdre) {

				figure.setOrdre(myFigure.getOrdre());

				figureDAO.save(figure);
			}

		}
		myFigure.setOrdre(nelOrdre);

		figureDAO.save(myFigure);


		return "redirect:/tetrimino/edit?id=" + myTetrimino.getId();
	}

	@RequestMapping(value="/tetrimino/deleteFigure", method=RequestMethod.GET)
	public String deleteFigure (@RequestParam(value="id", required=true) int idFigure, Model model) {

		Figure myFigure = figureDAO.find(idFigure);

		for(Bloc bloc : myFigure.getBlocs()) {

			blocDAO.delete(bloc);	
		}

		figureDAO.delete(myFigure);

		return "redirect:/tetrimino/edit?id=" + myFigure.getTetrimino().getId();
	}
	
	@RequestMapping(value="/tetrimino/addFigure", method=RequestMethod.GET)
	public String addFigure (@RequestParam(value="id", required=true) int idTetrimino, Model model) {

		Tetrimino myTetrimino = tetriminoDAO.find(idTetrimino);

		Figure myFigure = new Figure();
		
		myFigure.setOrdre(myTetrimino.getFigures().size());
		
		myFigure.setTetrimino(myTetrimino);
		
		figureDAO.save(myFigure);
		
		
		return "redirect:/tetrimino/edit?id=" + myTetrimino.getId();
	}
	
	@RequestMapping(value="/tetrimino/addBloc", method=RequestMethod.GET)
	public String addBloc (@RequestParam(value="id", required=true) int idFigure,
			@RequestParam(value="x", required=true) int x, 
			@RequestParam(value="y", required=true) int y, Model model) {

		Figure myFigure = figureDAO.find(idFigure);

		Bloc myBloc = new Bloc();
		
		myBloc.setX(x);
		
		myBloc.setY(y);
		
		myBloc.setFigure(myFigure);
		
		blocDAO.save(myBloc);
		
		return "redirect:/tetrimino/edit?id=" + myFigure.getTetrimino().getId();
	}
	
	@RequestMapping(value="/tetrimino/deleteBloc", method=RequestMethod.GET)
	public String deleteBloc (@RequestParam(value="id", required=true) int idBloc,  Model model) {

		Bloc myBloc = blocDAO.find(idBloc);

		Figure myFigure = myBloc.getFigure();
		
		blocDAO.delete(myBloc);
		
		return "redirect:/tetrimino/edit?id=" + myFigure.getTetrimino().getId();
	}
	
	
	

}
