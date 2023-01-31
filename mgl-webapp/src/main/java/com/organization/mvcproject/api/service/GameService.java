package com.organization.mvcproject.api.service;

import java.util.List;


import com.organization.mvcproject.api.model.Game;

public interface GameService {

	
	Game saveGame(Game game);
	
	List<Game> retrieveAllGames();

	Game findGameById(Long id);
	
	Boolean deleteGame(Long id);
}
