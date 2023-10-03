package com.tournoi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tournoi.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer>{

	List<Equipe> findByPays(String pays);
	
}
