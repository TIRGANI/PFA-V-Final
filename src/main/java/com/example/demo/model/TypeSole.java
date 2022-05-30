package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeSole")
public class TypeSole {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private String type;
	
	public TypeSole() {
		
	}
	public TypeSole(int id, String libelle, String type) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
