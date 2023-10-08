package com.tournoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tournoi.entities.Equipe;
import com.tournoi.services.EquipeService;

@Controller
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;
	
	@GetMapping("/equipes")
	public String getAll(Model model){
		 List<Equipe> equipes= equipeService.getAll();
		 model.addAttribute("equipes", equipes);
		 return "equipe";
	}
	
	@GetMapping("/equipe/{id}")
	public @ResponseBody Equipe getById(@PathVariable Integer id) {
		return equipeService.getById(id);
	}
	
	@GetMapping("/equipe/pays/{pays}")
	public @ResponseBody List<Equipe> getByPays(@PathVariable String pays){
		return equipeService.getByPays(pays);
	}
	
	@PostMapping("/equipe")
	public @ResponseBody Equipe save(@RequestBody Equipe equipe) {
		return equipeService.save(equipe);
	}
	
	@PutMapping("/equipe")
	public @ResponseBody Equipe update(@RequestBody Equipe equipe){
		return equipeService.update(equipe);
	}
	
	@DeleteMapping("/equipe/{id}")
	public @ResponseBody void deleteById(@PathVariable Integer id) {
		equipeService.deleteById(id);
	}
	
	@DeleteMapping("/equipe")
	public @ResponseBody void delete(@RequestBody Equipe equipe) {
		equipeService.delete(equipe);
	}
	
}
