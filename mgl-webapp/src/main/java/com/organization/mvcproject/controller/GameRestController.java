package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;

@RestController
public class GameRestController {


	@Autowired
	private GameService gameService;

	@GetMapping(value = "/game/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}


	//@RequestMapping(value = "/game", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	//@RequestMapping(value = "/game", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping(value = "/game/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long id) {
		return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/game", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateGame(@RequestBody GameImpl game){
		return new ResponseEntity<>(gameService.saveGame(game), HttpStatus.OK);
	}
	
	
}
