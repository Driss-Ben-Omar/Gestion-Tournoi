package com.tournoi.entities;

import com.tournoi.enums.Poste;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "`joueur`")
public class Joueur {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomJoueur;
	
	@Enumerated(EnumType.STRING)
	private Poste poste;
	
	@ManyToOne
	private Equipe equipe;
	
	
	@Override
	public String toString() {
	    return "Joueur [id=" + id + ", nomJoueur=" + nomJoueur + ", poste=" + poste + ", equipe=" + (equipe != null ? equipe.getId() : null) + "]";
	}


}
