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

import com.tournoi.entities.Stade;
import com.tournoi.services.StadeService;

@Controller
public class StadeController {
	
	@Autowired
	StadeService stadeService;
	
	@GetMapping("/stade/{id}")
	public @ResponseBody Stade getById(@PathVariable Integer id) {
		return stadeService.getById(id);
	}
	
	@GetMapping("/stades")
	public String getAll(Model model){
		List<Stade> stades= stadeService.getAll();
		model.addAttribute("stades", stades);
		return "stade";
	}
	
	@PostMapping("/stade")
	public @ResponseBody Stade save(@RequestBody Stade stade) {
		return stadeService.save(stade);
	}
	
	@PutMapping("/stade")
	public @ResponseBody Stade update(@RequestBody Stade stade) {
		return stadeService.update(stade);
	}
	
	@DeleteMapping("/stade/{id}")
	public @ResponseBody void deleteById(@PathVariable Integer id) {
		stadeService.deleteById(id);
	}
	
	@DeleteMapping("/stade")
	public @ResponseBody void delete(@RequestBody Stade stade) {
		stadeService.delete(stade);
	}
	
}
