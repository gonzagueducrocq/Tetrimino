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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sopra.dao.IJoueurDAO;
import com.sopra.model.Admin;
import com.sopra.model.Joueur;

@Controller
public class JoueurController {

	@Autowired
	private IJoueurDAO joueurDAO;

	@RequestMapping(value="/joueurs", method=RequestMethod.GET)
	public String getListeJoueurs(Model model) {
		model.addAttribute("joueurs", joueurDAO.findAll());

		return "joueurs";
	}
	
	@RequestMapping(value="/joueur/bannir", method=RequestMethod.GET)
	public String bannir(@RequestParam(value="id", required=true) int id) {
		
		
		Joueur joueur = joueurDAO.find(id);
		
		joueur.setBanni(!joueur.getBanni());
		
		joueur = joueurDAO.save(joueur);
	
		return "redirect:/joueurs";
		
}
}