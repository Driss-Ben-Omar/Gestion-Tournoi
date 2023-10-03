package com.tournoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.entities.Equipe;
import com.tournoi.repositories.EquipeRepository;


@Service
@Transactional
public class EquipeService implements IEquipeService{
	
	@Autowired 
	EquipeRepository equipeRepository;

	@Override
	public Equipe getById(Integer id) {
		return equipeRepository.findById(id).get();
	}

	@Override
	public List<Equipe> getAll() {
		return equipeRepository.findAll();
	}

	@Override
	public List<Equipe> getByPays(String pays) {
		return equipeRepository.findByPays(pays);
	}
	
	
	@Override
	public Equipe save(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public Equipe update(Equipe equipe) {
		return equipeRepository.save(equipe);
	}

	@Override
	public void deleteById(Integer id) {
		equipeRepository.deleteById(id);
	}

	@Override
	public void delete(Equipe equipe) {
		equipeRepository.delete(equipe);
	}


}
