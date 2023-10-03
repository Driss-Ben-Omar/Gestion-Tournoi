package com.tournoi.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "`equipe`")
public class Equipe {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomEquipe;
	
	private String pays;
	
	@OneToMany(mappedBy = "equipe")
	private List<Joueur> joueurs;
	
	@ManyToMany(mappedBy = "equipes")
	private List<Match> matchs;

}
