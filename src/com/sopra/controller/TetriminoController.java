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
	
}
