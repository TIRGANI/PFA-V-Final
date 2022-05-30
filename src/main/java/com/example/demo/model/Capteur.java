package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "capteur")
public class Capteur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String type;
	private Float image;
	private Float description;
	
	public Capteur() {
		
	}
	public Capteur(int id, String type, Float image, Float description) {
		super();
		this.id = id;
		this.type = type;
		this.image = image;
		this.description = description;
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
	public Float getImage() {
		return image;
	}
	public void setImage(Float image) {
		this.image = image;
	}
	public Float getDescription() {
		return description;
	}
	public void setDescription(Float description) {
		this.description = description;
	}
	
}
