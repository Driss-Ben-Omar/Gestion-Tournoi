package com.tournoi.services;

import java.util.List;

import com.tournoi.entities.Equipe;

public interface IEquipeService {
	
	Equipe getById(Integer id);
	
	List<Equipe> getAll();
	
	List<Equipe> getByPays(String pays);
	
	Equipe save(Equipe equipe);
	
	Equipe update(Equipe equipe);
	
	void deleteById(Integer id);
	
	void delete(Equipe equipe);

}
