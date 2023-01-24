package com.organization.mvcproject.service;

import java.util.List;


import com.organization.mvcproject.model.Game;

public interface GameService {

	Game saveGame(Game game);
	
	List<Game> retrieveAllGames();

	Game findGameById(Long id);
	
	Boolean deleteGame(Long id);
}
