package com.tournoi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tournoi.entities.Match;
import com.tournoi.services.MatchService;

@RestController
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@GetMapping("/matchs")
	public List<Match> getAll(){
		return matchService.getAll();
	}
	
	@GetMapping("/match/{id}")
	public Match getById(@PathVariable Integer id) {
		return matchService.getById(id);
	}
	
	@GetMapping("/match/date/{dateMatch}")
	public List<Match> getByDateMatch(@PathVariable("dateMatch") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateMatch) {
	    return matchService.getByDateMatch(dateMatch);
	}
	
	@PostMapping("/match")
	public Match save(@RequestBody Match match) {
		return matchService.save(match);
	}
	
	@PutMapping("/match")
	public Match update(@RequestBody Match match) {
		return matchService.update(match);
	}
	
	@DeleteMapping("/match/{id}")
	public void deleteById(@PathVariable Integer id) {
		matchService.deleteById(id);
	}

	@DeleteMapping("/match")
	public void delete(@RequestBody Match match) {
		matchService.delete(match);
	}
	
}
