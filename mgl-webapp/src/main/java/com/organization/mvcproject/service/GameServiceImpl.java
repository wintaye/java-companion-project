package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.dao.MockGameDAO;
import com.organization.mvcproject.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private MockGameDAO mockGameDAO;
	


	public List<Game> retrieveAllGames() {
		return mockGameDAO.retrieveAllGames();
	}

	public Game saveGame(Game game) {
		return mockGameDAO.saveGame(game);
	}
	
	public boolean deleteGame(Long id) {
		return mockGameDAO.deleteGame(id);
	}
	
	public Game findGameById(Long id) {
		return mockGameDAO.findGameById(id);
	}
	
	
	



}