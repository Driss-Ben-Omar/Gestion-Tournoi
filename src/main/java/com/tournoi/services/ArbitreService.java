package com.tournoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.entities.Arbitre;
import com.tournoi.repositories.ArbitreRepository;



@Service
@Transactional
public class ArbitreService implements IArbitreService{
	
	@Autowired
	ArbitreRepository arbitreRepository;

	@Override
	public Arbitre getById(Integer id) {
		return arbitreRepository.findById(id).get();
	}

	@Override
	public List<Arbitre> getAll() {
		return arbitreRepository.findAll();
	}

	@Override
	public Arbitre save(Arbitre arbitre) {
		return arbitreRepository.save(arbitre);
	}

	@Override
	public void deleteById(Integer id) {
		arbitreRepository.deleteById(id);
	}

	@Override
	public void delete(Arbitre arbitre) {
		arbitreRepository.delete(arbitre);
	}

	@Override
	public Arbitre update(Arbitre arbitre) {
		return arbitreRepository.save(arbitre);
	}
	
	

}
