package com.sopra.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;

@RestController
@RequestMapping("/tetrimino")
public class TetriminoRestController {

	@Autowired
	private ITetriminoDAO sqlTetriminoDAO;


	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Tetrimino>> getAll() {

		List<Tetrimino> listeTetrimino = this.sqlTetriminoDAO.findAll();
		return new ResponseEntity<List<Tetrimino>> ( listeTetrimino , HttpStatus.OK);
	}


}
