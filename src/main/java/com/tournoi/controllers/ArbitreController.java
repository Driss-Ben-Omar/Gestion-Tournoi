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

import com.tournoi.entities.Arbitre;
import com.tournoi.services.ArbitreService;

@Controller
public class ArbitreController {
	
	@Autowired
	ArbitreService arbitreService;
	
	@GetMapping("/arbitre/{id}")
	public @ResponseBody Arbitre  getById(@PathVariable Integer id) {
		return arbitreService.getById(id);
	}
	
	@GetMapping("/arbitres")
	public String getAll(Model model){
		List<Arbitre> arbitres= arbitreService.getAll();
		model.addAttribute("arbitres", arbitres);
		return "arbitre";
	}
	
	@PostMapping("/arbitre")
	public @ResponseBody Arbitre save(@RequestBody Arbitre abArbitre) {
		return arbitreService.save(abArbitre);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteArbitre(@PathVariable Integer id) {
	    arbitreService.deleteById(id);
	    return "redirect:/arbitres";
	}

	
	@DeleteMapping("/arbitre")
	public @ResponseBody void delete(@RequestBody Arbitre arbitre) {
		arbitreService.delete(arbitre);
	}

	@PutMapping("/arbitre")
	public @ResponseBody Arbitre update(@RequestBody Arbitre arbitre) {
		return arbitreService.update(arbitre);
	}
	
}
