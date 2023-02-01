package com.organization.mvcproject.api.dao;

import java.util.List;


import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

public interface GameDao {
	
	Game saveOrUpdateGame(Game game);
	
	List<Game> retrieveAllGames();

	Game findGameById(Long id);
	
	Boolean deleteGame(Long id);

}
