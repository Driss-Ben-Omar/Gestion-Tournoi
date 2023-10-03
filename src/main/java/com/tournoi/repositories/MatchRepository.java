package com.tournoi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tournoi.entities.Match;
import java.util.Date;


public interface MatchRepository extends JpaRepository<Match, Integer>{

	List<Match> findByDateMatch(Date dateMatch);
	
}
