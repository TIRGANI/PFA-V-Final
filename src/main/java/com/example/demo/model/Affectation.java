package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "affectation")
public class Affectation {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date datedebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Boitier boitier;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Parcelle parcelle;
	
	public Affectation() {
		
		
	}
	
	public Affectation(int id, Date datedebut, Date dateFin) {
		super();
		this.id = id;
		this.datedebut = datedebut;
		this.dateFin = dateFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Boitier getBoitier() {
		return boitier;
	}

	public void setBoitier(Boitier boitier) {
		this.boitier = boitier;
	}

	public Parcelle getParcelle() {
		return parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}
	
	

}
