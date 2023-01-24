package com.organization.mvcproject.model;

import java.util.Objects;

public class Game {

	private Long id;
	private String name;
	private String genre;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Game game = (Game) o;
        return id == game.id && name.equals(game.name) && genre.equals(game.genre);
    }

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
