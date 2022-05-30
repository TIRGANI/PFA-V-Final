package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boitier")
public class Boitier {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String reference;
	private String type;
	
	public Boitier() {
		
	}
	
	public Boitier(int id, String reference, String type) {
		super();
		this.id = id;
		this.reference = reference;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
