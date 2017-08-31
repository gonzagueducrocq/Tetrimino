package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.IPartieDAO;
import com.sopra.dao.IScoreDAO;
import com.sopra.model.Partie;
import com.sopra.model.Score;
import com.sopra.model.Tetrimino;

@RestController
@RequestMapping("/score")
public class ScoreRestController {
	
	@Autowired
	private IScoreDAO sqlScoreDAO;

	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Score>> getAll() {
		
		List<Score> listeScore = this.sqlScoreDAO.findAll();
		return new ResponseEntity<List<Score>> ( listeScore , HttpStatus.OK);
	}
	
	@RequestMapping(value="", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Score> addScore(@RequestBody Score score) {
		
		score = this.sqlScoreDAO.save(score);
		return new ResponseEntity<Score>(score, HttpStatus.OK);
	}
	
}
