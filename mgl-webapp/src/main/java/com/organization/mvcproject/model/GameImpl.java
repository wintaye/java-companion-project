package com.organization.mvcproject.model;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Game;

@Component
public class GameImpl implements Game {

	private Long id;
	private String name;
	private String genre;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getGenre() {
		return genre;
	}
	
	@Override
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        Game game = (Game) o;
//        return id == game.id && name.equals(game.name) && genre.equals(game.genre);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Game{" +
          "id=" + id +
          ", name='" + name + '\'' +
           ", genre='" + genre + '\'' +
          '}';
    }
	
	
}
