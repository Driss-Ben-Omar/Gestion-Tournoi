package com.tournoi.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "`arbitre`")
public class Arbitre {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private String nationalite;
	
	@OneToMany(mappedBy = "arbitre")
	private List<Match> matchs;

}
