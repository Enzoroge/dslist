package com.example.demo.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.GameListDTO;
import com.example.demo.model.GameList;
import com.example.demo.projections.GameMinProjection;
import com.example.demo.repositories.GameListRepository;
import com.example.demo.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
		
	}
	@Transactional
	public void  move(Long listId, int sourceIndex, int destinationIndex) {
	// buscando os jogos da lista
		List<GameMinProjection>list = gameRepository.searchByList(listId);
	//movendo um item da lista
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = 	sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max =   sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
			
		}

	}
}
