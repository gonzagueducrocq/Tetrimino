package com.sopra.restcontroller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IJoueurDAO;
import com.sopra.model.Joueur;

@RestController
@RequestMapping("/joueur")
public class JoueurRestController
{
	@Autowired
	private IJoueurDAO joueurDAO;
	
	
	@RequestMapping(value="/inscription", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Joueur> inscrire(@RequestBody Joueur joueur) {
		joueur = joueurDAO.save(joueur);
		
		return new ResponseEntity<Joueur>(joueur, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Joueur> editer(@PathVariable int id, @RequestBody Joueur joueur) {
		joueur.setId(id);
		joueur = joueurDAO.save(joueur);
		
		return new ResponseEntity<Joueur>(joueur, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Joueur>> getAll() {
		return new ResponseEntity<List<Joueur>>(this.joueurDAO.findAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Joueur> login(@RequestBody Joueur joueur, HttpSession session) {
		Joueur myJoueur = joueurDAO.login(joueur.getUsername(), joueur.getPassword());
		
		if (myJoueur != null) {
			session.setAttribute("joueur", myJoueur);
			return new ResponseEntity<Joueur>(myJoueur, HttpStatus.OK);
		}
		
		return new ResponseEntity<Joueur>(HttpStatus.FORBIDDEN);
	}
}
