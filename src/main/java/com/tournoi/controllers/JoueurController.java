package com.tournoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tournoi.entities.Joueur;
import com.tournoi.services.IJoueurService;
import com.tournoi.services.JoueurService;

@RestController
public class JoueurController {
	
	@Autowired
	IJoueurService joueurService;
	
	@GetMapping("/joueurs")
	public List<Joueur> getAll(){
		return joueurService.getAll();
	}
	
	@GetMapping("/joueur/{id}")
	public Joueur getById(@PathVariable Integer id) {
		return joueurService.getById(id);
	}
	
	@PostMapping("/joueur")
	public Joueur save(@RequestBody Joueur joueur) {
		return joueurService.save(joueur);
	}
	
	@PutMapping("/joueur")
	public Joueur update(@RequestBody Joueur joueur) {
		return joueurService.update(joueur);
	}
	
	@DeleteMapping("/joueur/{id}")
	public void deleteById(@PathVariable Integer id) {
		joueurService.deleteById(id);
	}
	
	@DeleteMapping("/joueur")
	public void delete(@RequestBody Joueur joueur) {
		joueurService.delete(joueur);
	}

}
