package com.tournoi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.tournoi.entities.Stade;
import com.tournoi.services.StadeService;

@Controller
public class StadeController {
	
	@Autowired
	StadeService stadeService;

	@GetMapping("/stades")
	public String getAll(Model model){
		List<Stade> stades= stadeService.getAll();
		model.addAttribute("stades", stades);
		return "stade";
	}
	
	@GetMapping("/formStade")
	public String formStade(Model model) {
		model.addAttribute("stade", new Stade());
		return "formStade";
	}
	
	@PostMapping("/stade/save")
	public String save(Stade stade, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formStade";
		}
		stadeService.save(stade);
		return "redirect:/stades";
	}
	
	@GetMapping("/stade/edit")
	public String editStade(Model model,Integer id) {
		Stade stade=stadeService.getById(id);
		
		model.addAttribute("stade", stade);
		
		return "editStade";
	}
	
	@GetMapping("/stade/delete/{id}")
	public String deleteStade(@PathVariable Integer id) {

		stadeService.deleteById(id);
		return "redirect:/stades";
	}	
}
