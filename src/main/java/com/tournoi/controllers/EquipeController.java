package com.tournoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tournoi.entities.Equipe;
import com.tournoi.entities.Joueur;
import com.tournoi.services.EquipeService;
import com.tournoi.services.JoueurService;

@Controller
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;
	
	@Autowired
	JoueurService joueurService;
	
	@GetMapping("/equipes")
	public String getAll(Model model){
		 List<Equipe> equipes= equipeService.getAll();
		 model.addAttribute("equipes", equipes);
		 return "equipe";
	}
	
	@GetMapping("/formEquipe")
	public String formEqipe(Model model) {
		List<Joueur> joueurs=joueurService.getAll();
		model.addAttribute("equipe", new Equipe());
		model.addAttribute("joueurs", joueurs);
		return "formEquipe";
	}

	@PostMapping("/equipe/save")
	public String saveEquipeWithJoueurs(Equipe equipe, BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        return "formEquipe";
	    }
	    Equipe savedEquipe = equipeService.save(equipe);

	    equipe.getJoueurs().stream()
	            .peek(joueur -> joueur.setEquipe(savedEquipe))
	            .forEach(joueurService::save);

	    return "redirect:/equipes";
	}

	
	@GetMapping("/equipe/edit")
	public String editEquipe(Model model,Integer id) {
		
		Equipe equipe=equipeService.getById(id);
		model.addAttribute("equipe", equipe);
		
		List<Joueur> joueurs=joueurService.getAll();
		model.addAttribute("joueurs", joueurs);
		
		return "editEquipe";
	}
	
	@GetMapping("/equipe/delete/{id}")
	public String deleteEquipe(@PathVariable Integer id) {

		equipeService.deleteById(id);
		return "redirect:/equipes";
	}
	
}
