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
@Table(name="grandeur")
public class Grandeur {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String type;
	private Float valeur;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Parcelle parcelle;
	
	public Grandeur() {
		
	}
	public Grandeur(int id, String type, Float valeur, Date date,Parcelle parcelle) {
		super();
		this.id = id;
		this.type = type;
		this.valeur = valeur;
		this.date = date;
		this.parcelle= parcelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getValeur() {
		return valeur;
	}
	public void setValeur(Float valeur) {
		this.valeur = valeur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Parcelle getParcelle() {
		return parcelle;
	}
	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}
	
}
