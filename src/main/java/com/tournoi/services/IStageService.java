package com.tournoi.services;

import java.util.List;

import com.tournoi.entities.Stade;

public interface IStageService {
	
	Stade getById(Integer id);
	
	List<Stade> getAll();
	
	Stade save(Stade stade);
	
	Stade update(Stade stade);
	
	void deleteById(Integer id);
	
	void delete(Stade stade);

}
