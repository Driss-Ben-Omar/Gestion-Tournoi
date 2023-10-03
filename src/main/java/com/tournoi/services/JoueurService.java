package com.tournoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.entities.Joueur;
import com.tournoi.repositories.JoueurRepository;

@Service
@Transactional
public class JoueurService implements IJoueurService{
	
	@Autowired
	JoueurRepository joueurRepository;

	@Override
	public Joueur getById(Integer id) {
		return joueurRepository.findById(id).get();
	}

	@Override
	public List<Joueur> getAll() {
		return joueurRepository.findAll();
	}

	@Override
	public Joueur save(Joueur joueur) {
		return joueurRepository.save(joueur);
	}

	@Override
	public Joueur update(Joueur joueur) {
		return joueurRepository.save(joueur);
	}

	@Override
	public void deleteById(Integer id) {
		joueurRepository.deleteById(id);
	}

	@Override
	public void delete(Joueur joueur) {
		joueurRepository.delete(joueur);
	}

}
