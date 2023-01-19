package com.organization.mvcproject.GameTask.service;

import java.util.List;

import com.organization.mvcproject.GameTask.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
