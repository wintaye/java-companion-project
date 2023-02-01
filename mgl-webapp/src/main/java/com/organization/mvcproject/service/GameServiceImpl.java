package com.organization.mvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.dao.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	//dao
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public Game saveOrUpdateGame(Game game) {
		return gameRepository.saveOrUpdateGame(game);
	}

	@Override
	public List<Game> retrieveAllGames() {
		return gameRepository.retrieveAllGames();
	}

	@Override
	public Game findGameById(Long id) {
		return gameRepository.findGameById(id);
	}
	
	@Override
	public Boolean deleteGame(Long id) {
		return gameRepository.deleteGame(id);
	}

}