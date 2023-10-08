package com.tournoi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Match> matchs;

}
