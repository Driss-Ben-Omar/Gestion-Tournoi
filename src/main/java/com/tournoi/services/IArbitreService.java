package com.tournoi.services;

import java.util.List;

import com.tournoi.entities.Arbitre;

public interface IArbitreService {
	
	Arbitre getById(Integer id);
	
	List<Arbitre> getAll();
	
	Arbitre save(Arbitre arbitre);
	
	void deleteById(Integer id);
	
	void delete(Arbitre arbitre);
	
	Arbitre update(Arbitre arbitre);
	
}
