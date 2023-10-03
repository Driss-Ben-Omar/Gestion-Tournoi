package com.tournoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tournoi.entities.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Integer>{

}
