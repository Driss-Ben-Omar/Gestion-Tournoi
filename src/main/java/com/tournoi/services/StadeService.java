package com.tournoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.entities.Stade;
import com.tournoi.repositories.StadeRepository;

@Service
@Transactional
public class StadeService implements IStageService{
	
	@Autowired
	StadeRepository stadeRepository;

	@Override
	public Stade getById(Integer id) {
		return stadeRepository.findById(id).get();
	}

	@Override
	public List<Stade> getAll() {
		return stadeRepository.findAll();
	}

	@Override
	public Stade save(Stade stade) {
		return stadeRepository.save(stade);
	}

	@Override
	public Stade update(Stade stade) {
		return stadeRepository.save(stade);
	}

	@Override
	public void deleteById(Integer id) {
		stadeRepository.deleteById(id);
	}

	@Override
	public void delete(Stade stade) {
		stadeRepository.delete(stade);
	}

}
