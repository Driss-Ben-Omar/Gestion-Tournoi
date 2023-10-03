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

import com.tournoi.entities.Arbitre;
import com.tournoi.services.ArbitreService;

@RestController
public class ArbitreController {
	
	@Autowired
	ArbitreService arbitreService;
	
	@GetMapping("/arbitre/{id}")
	public Arbitre  getById(@PathVariable Integer id) {
		return arbitreService.getById(id);
	}
	
	@GetMapping("/arbitres")
	public List<Arbitre> getAll(){
		return arbitreService.getAll();
	}
	
	@PostMapping("/arbitre")
	public Arbitre save(@RequestBody Arbitre abArbitre) {
		return arbitreService.save(abArbitre);
	}
	
	@DeleteMapping("/arbitre/{id}")
	public void deleteById(@PathVariable Integer id) {
		arbitreService.deleteById(id);
	}
	
	@DeleteMapping("/arbitre")
	public void delete(Arbitre arbitre) {
		arbitreService.delete(arbitre);
	}

	@PutMapping("/arbitre")
	public Arbitre update(@RequestBody Arbitre arbitre) {
		return arbitreService.update(arbitre);
	}
	
}
