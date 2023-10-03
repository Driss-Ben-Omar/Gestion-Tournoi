package com.tournoi.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tournoi.entities.Match;
import com.tournoi.repositories.MatchRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MatchService implements IMatchService{

	@Autowired
	MatchRepository matchRepository;
	
	@Override
	public Match getById(Integer id) {
		return matchRepository.findById(id).get();
	}

	@Override
	public List<Match> getAll() {
		return matchRepository.findAll();
	}
	
	@Override
	public List<Match> getByDateMatch(Date dateMatch) {
		return matchRepository.findByDateMatch(dateMatch);
	}

	@Override
	public Match save(Match match) {
		return matchRepository.save(match);
	}

	@Override
	public Match update(Match match) {
		return matchRepository.save(match);
	}

	@Override
	public void deleteById(Integer id) {
		matchRepository.deleteById(id);
	}

	@Override
	public void delete(Match match) {
		matchRepository.delete(match);
	}

}
