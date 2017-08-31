package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IJoueurDAO;
import com.sopra.dao.IPartieDAO;
import com.sopra.model.Joueur;
import com.sopra.model.Partie;

@RestController
@RequestMapping("partie")
public class PartieRestController {

	@Autowired
	private IPartieDAO sqlPartieDAO;
	
	@Autowired
	private IJoueurDAO sqlJoueurDAO;

	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Partie>> getAll() {
		return new ResponseEntity<List<Partie>> (this.sqlPartieDAO.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value="", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Partie> addPartie(@RequestBody Partie partie) {

		partie = this.sqlPartieDAO.save(partie);
		return new ResponseEntity<Partie> (partie, HttpStatus.OK);

	}


	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Partie> save(@PathVariable int id, @RequestParam(value="idJoueur") int idJoueur ) {

		Joueur myJoueur = this.sqlJoueurDAO.find(idJoueur);
		
		Partie myPartie = this.sqlPartieDAO.find(id);
		
		myPartie.setJoueur2(myJoueur);
		
		myPartie = this.sqlPartieDAO.save(myPartie);
		
		return new ResponseEntity<Partie> (myPartie, HttpStatus.OK);

		
	}
	
}

