package com.tournoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tournoi.entities.Equipe;
import com.tournoi.entities.Joueur;
import com.tournoi.services.EquipeService;
import com.tournoi.services.IJoueurService;

@Controller
public class JoueurController {
	
	@Autowired
	IJoueurService joueurService;
	
	@Autowired
	EquipeService equipeService;
	
	@GetMapping("/joueurs")
	public String getAll(Model model){
		List<Joueur> joueurs=  joueurService.getAll();
		model.addAttribute("joueurs", joueurs);
		return "joueur";
	}
	
	@GetMapping("/formJoueur")
	public String formJoueur(Model model) {
		List<Equipe> equipes=equipeService.getAll();
		model.addAttribute("joueur", new Joueur());
		model.addAttribute("equipes", equipes);
		return "formJoueur";
	}
	
	@PostMapping("/joueur/save")
	public String saveJoueurWithEquipe(@ModelAttribute("joueur") Joueur joueur, BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        return "formJoueur";
	    }

	    joueurService.save(joueur);

	    return "redirect:/joueurs";
	}
	
	@GetMapping("/joueur/edit")
	public String editJoueur(Model model,Integer id) {
		Joueur joueur=joueurService.getById(id);
		List<Equipe> equipes=equipeService.getAll();
		model.addAttribute("equipes", equipes);
		model.addAttribute("joueur", joueur);
		
		return "editJoueur";
	}
	
	@GetMapping("/joueur/delete/{id}")
	public String deleteJoueur(@PathVariable Integer id) {

		joueurService.deleteById(id);
		return "redirect:/joueurs";
	}

}
