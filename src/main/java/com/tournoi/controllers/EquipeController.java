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

import com.tournoi.entities.Equipe;
import com.tournoi.services.EquipeService;

@RestController
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;
	
	@GetMapping("/equipes")
	public List<Equipe> getAll(){
		return equipeService.getAll();
	}
	
	@GetMapping("/equipe/{id}")
	public Equipe getById(@PathVariable Integer id) {
		return equipeService.getById(id);
	}
	
	@GetMapping("/equipe/pays/{pays}")
	public List<Equipe> getByPays(@PathVariable String pays){
		return equipeService.getByPays(pays);
	}
	
	@PostMapping("/equipe")
	public Equipe save(@RequestBody Equipe equipe) {
		return equipeService.save(equipe);
	}
	
	@PutMapping("/equipe")
	public Equipe update(@RequestBody Equipe equipe){
		return equipeService.update(equipe);
	}
	
	@DeleteMapping("/equipe/{id}")
	public void deleteById(@PathVariable Integer id) {
		equipeService.deleteById(id);
	}
	
	@DeleteMapping("/equipe")
	public void delete(@RequestBody Equipe equipe) {
		equipeService.delete(equipe);
	}
	
}
