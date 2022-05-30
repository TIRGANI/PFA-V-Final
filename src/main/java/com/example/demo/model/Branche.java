package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branche")
public class Branche {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int branche;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Boitier boitier;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Capteur capteur;
	
	public Branche() {
		
	}
	
	public Branche(int id, int branche) {
		super();
		this.id = id;
		this.branche = branche;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBranche() {
		return branche;
	}
	public void setBranche(int branche) {
		this.branche = branche;
	}

	public Boitier getBoitier() {
		return boitier;
	}

	public void setBoitier(Boitier boitier) {
		this.boitier = boitier;
	}
	
	

}
