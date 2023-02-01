package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.api.dao.GameDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.model.GameImpl;

@Repository
public class GameRepository implements GameDao{
	
	private static Long gameId = new Long(0);
	public static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}
		
	

		public Game saveOrUpdateGame(Game game) {
			if(game.getId() != null) {
				//find original game obj in list by id
				Game gameToUpdate = findGameById(game.getId());
				//replace original game obj with new game obj (same id, same location in list)
				int gameToUpdateIndex = games.indexOf(gameToUpdate);
				games.set(gameToUpdateIndex, (GameImpl) gameToUpdate);
				return game;
			} else {
				game.setId(++gameId);
				games.add((GameImpl) game);
				return game;
			}
			
		}
		
		public List<Game> retrieveAllGames() {
			return List.copyOf(games);
		}
		
		@Override
		public Game findGameById(Long id) {
			return games.stream().filter(g -> id.equals(g.getId())).findAny().orElse(null);
			
		}
		
		public Boolean deleteGame(Long id) {
			return games.removeIf(g -> id.equals(g.getId()));
		}


		
		//TODO filter by game genre, add to list if .equals(game.getGenre())
		//TODO search by keyword 
		
		

}
