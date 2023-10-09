package com.tournoi.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "`match`")
public class Match {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date dateMatch;
	
	private String heureMatch;
	
	@ManyToOne
	@JoinColumn(name = "arbitre_id")
	private Arbitre arbitre;
	
	@ManyToOne
	private Stade stade;
	
	@ManyToMany
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinTable(name = "match_equipe", joinColumns = @JoinColumn(name="match_id"), inverseJoinColumns = @JoinColumn(name="equipe_id"))
	private List<Equipe> equipes;
	
	@Override
	public String toString() {
	    return "Match [id=" + id + ", date=" + dateMatch + ", stade=" + (stade != null ? stade.getId() : null) + "]";
	}



}
