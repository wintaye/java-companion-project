package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.model.Game;

@Repository
public class MockGameDAO {
	
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		Game game2 = new Game();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		Game game3 = new Game();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
	

		public Game saveGame(Game game) {
			if(game.getId() != null) {
				//find original game obj in list by id
				Game gameToUpdate = findGameById(game.getId());
				//replace original game obj with new game obj (same id, same location in list)
				int gameToUpdateIndex = games.indexOf(gameToUpdate);
				games.set(gameToUpdateIndex, gameToUpdate);
				return game;
			} else {
				game.setId(++gameId);
				games.add(game);
				return game;
			}
			
		}
		
		public List<Game> retrieveAllGames() {
			return games;
		}
		
		public Game findGameById(Long id) {
			return games.stream().filter(g -> id.equals(g.getId())).findAny().orElse(null);
			
		}
		
		public boolean deleteGame(Long id) {
			return games.removeIf(g -> id.equals(g.getId()));
		}
		
		//TODO filter by game genre, add to list if .equals(game.getGenre())
		
		

}
