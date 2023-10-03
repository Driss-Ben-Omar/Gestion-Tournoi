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

import com.tournoi.entities.Stade;
import com.tournoi.services.StadeService;

@RestController
public class StadeController {
	
	@Autowired
	StadeService stadeService;
	
	@GetMapping("/stade/{id}")
	public Stade getById(@PathVariable Integer id) {
		return stadeService.getById(id);
	}
	
	@GetMapping("/stades")
	public List<Stade> getAll(){
		return stadeService.getAll();
	}
	
	@PostMapping("/stade")
	public Stade save(@RequestBody Stade stade) {
		return stadeService.save(stade);
	}
	
	@PutMapping("/stade")
	public Stade update(@RequestBody Stade stade) {
		return stadeService.update(stade);
	}
	
	@DeleteMapping("/stade/{id}")
	public void deleteById(@PathVariable Integer id) {
		stadeService.deleteById(id);
	}
	
	@DeleteMapping("/stade")
	public void delete(@RequestBody Stade stade) {
		stadeService.delete(stade);
	}
	
}
