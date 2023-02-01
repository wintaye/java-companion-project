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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.model.GameImpl;

@RequestMapping(value = "/game")
@RestController
public class GameRestController {


	@Autowired
	private GameService gameService;

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}


	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createGame(@RequestBody GameImpl game) {
		Game createdGame = gameService.saveOrUpdateGame(game);
		return new ResponseEntity<>((GameImpl) createdGame, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable("id") Long id) {
		return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
	}
	
//	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> updateGame(@RequestBody GameImpl game){
//		gameService.saveOrUpdateGame(game);
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
	
}
