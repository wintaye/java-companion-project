package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;
	

	public Game saveGame(Game game) {
		return gameRepository.saveGame(game);
	}

	public List<Game> retrieveAllGames() {
		return gameRepository.retrieveAllGames();
	}

	public Game findGameById(Long id) {
		return gameRepository.findGameById(id);
	}
	
	public Boolean deleteGame(Long id) {
		return gameRepository.deleteGame(id);
	}
	
	
	



}