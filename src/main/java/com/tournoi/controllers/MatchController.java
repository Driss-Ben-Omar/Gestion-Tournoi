package com.tournoi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.tournoi.entities.Match;
import com.tournoi.services.MatchService;

@Controller
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@GetMapping("/matchs")
	public String getAll(Model model){
		List<Match> matchs= matchService.getAll();
		model.addAttribute("matchs", matchs);
		return "match";
	}
	
	@GetMapping("/match/{id}")
	public @ResponseBody Match getById(@PathVariable Integer id) {
		return matchService.getById(id);
	}
	
	@GetMapping("/match/date/{dateMatch}")
	public @ResponseBody List<Match> getByDateMatch(@PathVariable("dateMatch") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateMatch) {
	    return matchService.getByDateMatch(dateMatch);
	}
	
	@PostMapping("/match")
	public @ResponseBody Match save(@RequestBody Match match) {
		return matchService.save(match);
	}
	
	@PutMapping("/match")
	public @ResponseBody Match update(@RequestBody Match match) {
		
		return matchService.update(match);
	}
	
	@DeleteMapping("/match/{id}")
	public @ResponseBody void deleteById(@PathVariable Integer id) {
		matchService.deleteById(id);
	}

	@DeleteMapping("/match")
	public @ResponseBody void delete(@RequestBody Match match) {
		matchService.delete(match);
	}
	
}
