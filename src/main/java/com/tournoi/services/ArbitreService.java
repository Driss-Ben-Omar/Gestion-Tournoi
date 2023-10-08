package com.tournoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tournoi.controllers.MatchController;
import com.tournoi.entities.Arbitre;
import com.tournoi.entities.Match;
import com.tournoi.repositories.ArbitreRepository;
import com.tournoi.repositories.MatchRepository;



@Service
@Transactional
public class ArbitreService implements IArbitreService{
	
	@Autowired
	ArbitreRepository arbitreRepository;
	
	@Autowired
	MatchService matchService;

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
		Arbitre arb=arbitreRepository.save(arbitre);
		return arb;
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
		Arbitre arb=arbitreRepository.save(arbitre);
		List<Match> matchs=arb.getMatchs();
		System.out.println(matchs.size());
		for(Match match: matchs) {
			match.setArbitre(arbitre);
			matchService.update(match);
			System.out.println(match.getArbitre().getNom());
		}
		return arb;
	}
	
	

}
