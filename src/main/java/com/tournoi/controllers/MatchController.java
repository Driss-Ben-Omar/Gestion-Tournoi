package com.tournoi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tournoi.entities.Arbitre;
import com.tournoi.entities.Equipe;
import com.tournoi.entities.Joueur;
import com.tournoi.entities.Match;
import com.tournoi.entities.Stade;
import com.tournoi.services.ArbitreService;
import com.tournoi.services.EquipeService;
import com.tournoi.services.MatchService;
import com.tournoi.services.StadeService;

@Controller
public class MatchController {

	@Autowired
	MatchService matchService;
	
	@Autowired
	EquipeService equipeService;
	
	@Autowired
	StadeService stadeService;
	
	@Autowired
	ArbitreService arbitreService;

	@GetMapping("/matchs")
	public String getAll(Model model) {
		List<Match> matchs = matchService.getAll();
		model.addAttribute("matchs", matchs);
		return "match";
	}
	
	@GetMapping("/formMatch")
	public String formMatch(Model model) {
		List<Equipe> equipes=equipeService.getAll();
		List<Stade> stades=stadeService.getAll();
		List<Arbitre> arbitres=arbitreService.getAll();
		model.addAttribute("equipe", new Equipe());
		model.addAttribute("equipes", equipes);
		model.addAttribute("stades", stades);
		model.addAttribute("arbitres", arbitres);
		return "formMatch";
	}
	
	@GetMapping("/match/edit")
	public String editMatch(Model model,Integer id) {
		
		Match match=matchService.getById(id);
		model.addAttribute("match", match);
		
		List<Equipe> equipes=equipeService.getAll();
		List<Stade> stades=stadeService.getAll();
		List<Arbitre> arbitres=arbitreService.getAll();
		model.addAttribute("equipes", equipes);
		model.addAttribute("stades", stades);
		model.addAttribute("arbitres", arbitres);
		
		return "editMatch";
	}

	@PostMapping("/match/save")
	public String saveMatchWithEquipes(Match match, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formMatch";
		}
		matchService.save(match);

		return "redirect:/matchs";
	}
	
	@GetMapping("/match/delete/{id}")
	public String deleteMatch(@PathVariable Integer id) {

		matchService.deleteById(id);
		return "redirect:/matchs";
	}
	
}
