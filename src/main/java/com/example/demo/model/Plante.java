package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plante")
public class Plante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private String racine;
	private String photo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private TypePlante typePlante;
	public Plante() {
		
	}
	public Plante( String libelle, String racine, String photo, TypePlante typePlante) {
		
		this.libelle = libelle;
		this.racine = racine;
		this.photo = photo;
		this.typePlante = typePlante;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getRacine() {
		return racine;
	}
	public void setRacine(String racine) {
		this.racine = racine;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public TypePlante getTypePlante() {
		return typePlante;
	}
	public void setTypePlante(TypePlante typePlante) {
		this.typePlante = typePlante;
	}

}
