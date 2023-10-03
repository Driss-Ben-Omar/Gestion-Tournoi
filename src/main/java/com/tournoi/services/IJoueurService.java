package com.tournoi.services;

import java.util.List;

import com.tournoi.entities.Joueur;

public interface IJoueurService {

	Joueur getById(Integer id);
	
	List<Joueur> getAll();
	
	Joueur save(Joueur joueur);
	
	Joueur update(Joueur joueur);
	
	void deleteById(Integer id);
	
	void delete(Joueur joueur);
	
}
