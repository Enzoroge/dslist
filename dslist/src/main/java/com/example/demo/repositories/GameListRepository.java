package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
