package com.tournoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.tournoi.entities.Arbitre;
import com.tournoi.services.ArbitreService;

@Controller
public class ArbitreController {

	@Autowired
	ArbitreService arbitreService;

	
	@GetMapping("/arbitres")
	public String getAll(Model model) {
		List<Arbitre> arbitres = arbitreService.getAll();
		model.addAttribute("arbitres", arbitres);
		return "arbitre";
	}

	@GetMapping("/formArbitre")
	public String formPatient(Model model) {
		model.addAttribute("patient", new Arbitre());
		return "formArbitre";
	}

	@PostMapping("/save")
	public String save(Arbitre abArbitre, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formArbitre";
		}
		arbitreService.save(abArbitre);
		return "redirect:/arbitres";
	}

	@GetMapping("/delete/{id}")
	public String deleteArbitre(@PathVariable Integer id) {

		arbitreService.deleteById(id);
		return "redirect:/arbitres";
	}

	@GetMapping("/arbitre/edit")
	public String editArbitre(Model model,Integer id) {
		Arbitre arbitre=arbitreService.getById(id);
		
		model.addAttribute("arbitre", arbitre);
		
		return "editArbitre";
	}

}
