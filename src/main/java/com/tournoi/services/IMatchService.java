package com.tournoi.services;

import java.util.Date;
import java.util.List;

import com.tournoi.entities.Match;

public interface IMatchService {
	
	Match getById(Integer id);
	
	List<Match> getAll();
	
	List<Match> getByDateMatch(Date dateMatch);
	
	Match save(Match match);
	
	Match update(Match match);
	
	void deleteById(Integer id);
	
	void delete(Match match);

}
