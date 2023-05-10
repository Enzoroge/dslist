package com.example.demo.dto;

import com.example.demo.model.GameList;

public class GameListDTO {
	
	private Long id;
	private	String name;
	
	public GameListDTO() {
		
	}

	public GameListDTO(GameList model) {
		id = model.getId();
		name = model.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	

}
